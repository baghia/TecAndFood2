package control.aluno;

import dao.aluno.AlunoDao;
import dao.util.Conexao;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import model.aluno.Aluno;
import model.aluno.Endereco;
import model.util.LoggerTec;

@WebServlet(name = "NovoAluno", urlPatterns = {"/control/NovoAluno"})
public class NovoAluno extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usuario = new Usuario();
        usuario.setNome("demonstracao");
        LoggerTec logger = new LoggerTec(usuario);
        try {
            Conexao conexao = new Conexao();
            conexao.setConexao(conexao.conectar());

            SimpleDateFormat dtformat = new SimpleDateFormat("dd/MM/yyyy");
            Date data = dtformat.parse(request.getParameter("data"));
            dtformat = new SimpleDateFormat("yyyy-MM-dd");
            String dataBanco = dtformat.format(data);

            AlunoDao alunoDao = new AlunoDao(conexao, logger);

            Aluno aluno = new Aluno();
            aluno.setNome(request.getParameter("nome"));
            aluno.setRg(request.getParameter("rg"));
            aluno.setCpf(request.getParameter("cpf"));
            aluno.setMatricula(request.getParameter("matricula"));
            aluno.setEndereco(new Endereco());
            aluno.getEndereco().setId(1);
            aluno.setDataSql(java.sql.Date.valueOf(dataBanco));

            int result = alunoDao.inserir(aluno);
            if (result > 0) {
                try {
                    alunoDao.getCon().commit();
                    conexao.fechar();
                    logger.logInfo("NovoAluno> Aluno inserido com sucesso.");
                    response.sendRedirect("../content/aluno/index.jsp?e=0");
                } catch (SQLException ex) {
                    logger.logSevere("NovoAluno > e=. SQLException: ", ex);
                    System.out.println("SQLException lançada em NovoAluno: " + ex.getMessage());
                    conexao.fechar();
                    response.sendRedirect("../content/aluno/index.jsp?e=12"); //erro atividade
                }
            } else {
                try {
                    alunoDao.getCon().rollback();
                    conexao.fechar();
                    logger.logWarning("NovoAluno> Erro ao inserir aluno.");
                    response.sendRedirect("../content/aluno/index.jsp?e=0");
                } catch (SQLException ex) {
                    logger.logSevere("NovoAluno > e=. SQLException: ", ex);
                    System.out.println("SQLException lançada em NovoAluno: " + ex.getMessage());
                    conexao.fechar();
                    response.sendRedirect("../content/aluno/index.jsp?e=12"); //erro atividade
                }
            }

        } catch (ParseException parse) {
            logger.logSevere("NovoPedido > ParseException: ", parse);
            System.out.println("ParseException lançada em novoPedido: " + parse.getMessage());
            response.sendRedirect("../content/aluno/index.jsp?e=103");
        } catch (NullPointerException nullPointer) {
            logger.logSevere("NovoPedido > NullPointerException: ", nullPointer);
            System.out.println("NullPointerException lançada em novoPedido: " + nullPointer.getMessage());
            response.sendRedirect("../content/aluno/index.jsp?e=102");
        } catch (IOException io) {
            logger.logSevere("NovoPedido > IOException: ", io);
            System.out.println("IOException lançada em NovoPedido: " + io.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
