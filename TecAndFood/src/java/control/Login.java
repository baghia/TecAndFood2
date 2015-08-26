package control;

//import dao.util.AtividadeDao;
import dao.util.Conexao;
import dao.UsuarioDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import model.util.Atividade;
import model.util.LoggerTec;
import model.Usuario;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        Usuario usuario = new Usuario();
        usuario.setUsername(request.getParameter("username"));
        usuario.setSenha(request.getParameter("senha"));

        Conexao conexao = new Conexao();
        conexao.setConexao(conexao.conectar());
        LoggerTec logger = new LoggerTec();

        UsuarioDao usuarioDao = new UsuarioDao(conexao, logger);
        //AtividadeDao atividadeDao = new AtividadeDao();

        //Atividade atividade = new Atividade();
        //atividadeDao.con = conexao.getConexao();
        //usuarioDao.con = conexao.getConexao();
        if ((!usuario.getUsername().equals("")) && (!usuario.getSenha().equals(""))) {
            Usuario login = usuarioDao.login(usuario);
            if (login != null) {
                if (login.getAtivo()) {
                    /*atividade.setCampo("login");
                    atividade.setOldValue("-1");
                    atividade.setOperacao("login");
                    atividade.setUsuario(login);
                    atividade.setTabela("endereco");
                    atividade.setIdDado(Integer.toString(login.getId()));
                    atividade.setNewValue(Integer.toString(login.getId()));

                    boolean result_a = atividadeDao.inserir(atividade);
                    if (result_a) {*/
                        try {
                            //atividadeDao.con.commit();
                            usuarioDao.getCon().commit();
                            conexao.fechar();
                            request.getSession(true).setAttribute("usuario", login);
                            //logger.logInfo("Usuario " + login.getNome() + " logado com sucesso.");
                            //logger.fileHandler.close();
                            response.sendRedirect("home.jsp");
                        } catch (SQLException ex) {
                            //logger.logSevere("Login: falha ao logar(commit). e=4. SQLException: ", ex);
                            conexao.fechar();
                            response.sendRedirect("index.jsp?e=4");
                        }/*
                    } else {
                        try {
                            //atividadeDao.con.rollback();
                            usuarioDao.getCon().rollback();
                            conexao.fechar();
                            logger.logInfo("Login: falha ao logar(rollback). e=4");
                            response.sendRedirect("index.jsp?e=4");
                        } catch (SQLException ex) {
                            logger.logSevere("Login: falha ao logar(rollback). e=4. SQLException: ", ex);
                            conexao.fechar();
                            response.sendRedirect("index.jsp?e=4");
                        }
                    }*/
                } else {
                    //logger.logWarning("Login: tentativa de entrada de usuário desativado: " + login.getUsername() +".");
                    conexao.fechar();
                    response.sendRedirect("index.jsp?e=6");
                }
            } else {
                //logger.logWarning("Login: tentativa de entrada de usuário inexistente: " + usuario.getUsername() +".");
                conexao.fechar();
                response.sendRedirect("index.jsp?e=3");
            }
        } else {
            //logger.logWarning("Login: tentativa de entrada de usuário sem preenchimento dos campos.");
            conexao.fechar();
            response.sendRedirect("index.jsp?e=1");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
