package control;

import dao.cliente.ClienteDao;
import dao.util.Conexao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.cliente.Cliente;
import model.util.LoggerSab;

@WebServlet(name = "VerificaCNPJ", urlPatterns = {"/control/VerificaCNPJ"})
public class VerificaAlimentos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LoggerSab log =  (LoggerSab) request.getAttribute("logger");
        request.getSession().setAttribute("target", "cliente");
        try {
            Conexao conexao = (Conexao) request.getAttribute("conexao");
            ClienteDao clienteDao = new ClienteDao();
            clienteDao.con = conexao.getConexao();
            clienteDao.logger = log;
            
            String cnpj = request.getParameter("c");
            int id = Integer.parseInt(request.getParameter("i"));
            int result = clienteDao.buscarCNPJ(cnpj);
            if(id > 0){
                Cliente cliente = clienteDao.consultar(id);
                if ( (result > -1) && (!cliente.getCnpj().equals(cnpj))) {
                    response.getWriter().write("f");
                } else {
                    response.getWriter().write("t");
                }
            } else {
                if ( result > -1) {
                    response.getWriter().write("f");
                } else {
                    response.getWriter().write("t");
                }
            }
        } catch (IOException io) {
            log.logSevere("VerificaCNPJ > IOException: ", io);
            System.out.println("IOException lançada em VerificaCNPJ: " + io.getMessage());
            response.getWriter().write("t");
        } catch (NumberFormatException number) {
            log.logSevere("VerificaCNPJ > NumberFormatException: ", number);
            System.out.println("NumberFormatException lançada em VerificaCNPJ: " + number.getMessage());
            response.getWriter().write("t");
        } catch(NullPointerException nex){
            log.logSevere("VerificaCNPJ > NullPointerException: ", nex);
            System.out.println("NullPointerException lançada em VerificaCNPJ: " + nex.getMessage());
            response.getWriter().write("t");
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
