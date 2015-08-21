package control.prato;

//import dao.cliente.ClienteDao;
//import dao.util.Conexao;
import control.aluno.*;
import com.google.gson.Gson;
import control.*;
import dao.aluno.AlunoDao;
import dao.cardapio.PratoDao;
import dao.util.Conexao;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.aluno.Aluno;
import model.cardapio.IngredientePrato;
import model.cardapio.Prato;
import model.estoque.Ingrediente;
import model.util.LoggerTec;
//import model.cliente.Cliente;
//import model.util.LoggerSab;

@WebServlet(name = "InserirPrato", urlPatterns = {"/control/InserirPrato"})
public class Inserir extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] quantidade = request.getParameterValues("quantidade");
        String[] nome = request.getParameterValues("nome");
        String[] id = request.getParameterValues("id");
        if (id != null) {
            Prato prato = new Prato();
            ArrayList<IngredientePrato> ingredientesPrato = new ArrayList<>();
            Ingrediente ingrediente = null;
            IngredientePrato ingredientePrato = null;
            StringBuilder descricaoPrato = new StringBuilder();

            for (int i = 0; i < id.length; i++) {
                ingrediente = new Ingrediente();
                ingredientePrato = new IngredientePrato();
                ingrediente.setId(Integer.valueOf(id[i]));
                ingrediente.setNome(nome[i]);
                descricaoPrato.append(nome[i]);
                if (i < id.length - 1) {
                    descricaoPrato.append(",");
                }
                ingredientePrato.setIngrediente(ingrediente);
                ingredientePrato.setQuantidade(Float.parseFloat(quantidade[0]));
                ingredientesPrato.add(ingredientePrato);
            }
            System.out.println(descricaoPrato.toString());
            prato.setIngredientes(ingredientesPrato);
            prato.setNome(descricaoPrato.toString());
//            PratoDao pdao = new PratoDao();
        }
        response.sendRedirect("/TecAndFood/home.jsp");
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
