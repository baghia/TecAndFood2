package control.intervalo;

//import dao.cliente.ClienteDao;
//import dao.util.Conexao;
import control.aluno.*;
import com.google.gson.Gson;
import control.*;
import control.refeicao.InserirRefeicao;
import dao.aluno.AlunoDao;
import dao.estoque.IntervaloDao;
import dao.estoque.RefeicaoDao;
import dao.util.Conexao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

@WebServlet(name = "InserirIntervalo", urlPatterns = {"/control/InserirIntervalo"})
public class Inserir extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        IntervaloDao intervaloDao = new IntervaloDao(conexao, new LoggerTec());
        intervaloDao.setCon(con);
        int quantidadeEsperada = Integer.parseInt(request.getParameter("quantidade"));
        int id = intervaloDao.inserir(quantidadeEsperada);
        if (id >= 0) {
            try {
                con.commit();
                response.sendRedirect("../stepThree.jsp");
            } catch (SQLException ex) {
                //Logger.getLogger(Inserir.class.getName()).log(Level.SEVERE, null, ex);
            }
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
