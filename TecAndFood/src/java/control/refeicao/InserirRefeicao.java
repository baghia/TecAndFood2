package control.refeicao;

//import dao.cliente.ClienteDao;
//import dao.util.Conexao;
import control.*;
import dao.aluno.AlunoDao;
import dao.estoque.RefeicaoDao;
import dao.util.Conexao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.aluno.Aluno;
import model.cardapio.IngredientePrato;
import model.cardapio.PratoCardapioDiario;
import model.estoque.Refeicao;
import model.util.LoggerTec;
//import model.cliente.Cliente;
//import model.util.LoggerSab;

@WebServlet(name = "InserirRefeicao", urlPatterns = {"/control/InserirRefeicao"})
public class InserirRefeicao extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String matricula = request.getParameter("matricula");
        String alimentosSelecionados = request.getParameter("alimentos_selecionados");
        Refeicao refeicao = new Refeicao();
        RefeicaoDao rdao = new RefeicaoDao(new Conexao(), new LoggerTec());
        rdao.setCon(new Conexao().conectar());
        AlunoDao alunoDao = new AlunoDao(new Conexao(), new LoggerTec());
        alunoDao.setCon(new Conexao().conectar());
        Aluno aluno = alunoDao.buscarMatricula(matricula);
        String alimentos[] = alimentosSelecionados.split(",");
        if (aluno != null) {

            for (String idIngrediente : alimentos) {
                refeicao = new Refeicao();
                refeicao.setAluno(aluno);
                IngredientePrato ip = new IngredientePrato();
                ip.setId(Integer.parseInt(idIngrediente));
                refeicao.setIngrediente(ip);
                PratoCardapioDiario pcd = new PratoCardapioDiario();
                pcd.setId(1);
                refeicao.setPrato(pcd);
                rdao.inserir(refeicao);
                System.out.println("Código d: " + matricula);
                for (String alimento : alimentos) {
                    System.out.println(alimento);
                }
            }
        }

        System.out.println("Código: " + matricula);
        for (String alimento : alimentos) {
            System.out.println(alimento);
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
