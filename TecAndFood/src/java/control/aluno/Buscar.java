package control.aluno;

//import dao.cliente.ClienteDao;
//import dao.util.Conexao;
import com.google.gson.Gson;
import control.*;
import dao.aluno.AlunoDao;
import dao.util.Conexao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.aluno.Aluno;
import model.util.LoggerTec;
//import model.cliente.Cliente;
//import model.util.LoggerSab;

@WebServlet(name = "BuscarAluno", urlPatterns = {"/control/BuscarAluno"})
public class Buscar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String matricula = request.getParameter("matricula");
        AlunoDao alunodao = new AlunoDao(new Conexao(), new LoggerTec());
        alunodao.setCon(new Conexao().conectar());
        Aluno aluno = alunodao.buscarMatricula(matricula);

        Gson gson = new Gson();
        response.setCharacterEncoding("UTF8");
        if (aluno != null) {
//            String value = new String(aluno.getNome().getBytes("UTF-8"));
//            aluno.setNome(value);
            response.getWriter().write(gson.toJson(aluno));
        } else {
            response.getWriter().write("{\"error\":\"true\"}");
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
