package control;

import dao.UsuarioDao;
//import dao.util.AtividadeDao;
import dao.util.Conexao;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
//import model.util.Atividade;
import model.util.LoggerTec;

@WebServlet(name = "Logout", urlPatterns = {"/Logout"})
public class Logout extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        Usuario usuario = (Usuario) request.getSession(false).getAttribute("usuario");
        String location = (String) request.getSession(false).getAttribute("location");
        LoggerTec log =  (LoggerTec) request.getAttribute("logger");
        
        Conexao conexao = new Conexao();
        conexao.setConexao(conexao.conectar());

        UsuarioDao usuarioDao = new UsuarioDao(conexao, log);
/*
        AtividadeDao atividadeDao = new AtividadeDao();
        atividadeDao.con = conexao.getConexao();

        Atividade atividade = new Atividade();
        atividade.setCampo("login");
        atividade.setOldValue("-1");
        atividade.setOperacao("login");
        atividade.setUsuario(usuario);
        atividade.setTabela("endereco");
        atividade.setIdDado(Integer.toString(usuario.getId()));
        atividade.setNewValue(Integer.toString(usuario.getId()));

        boolean result_a = atividadeDao.inserir(atividade);
        
        String geral = getServletContext().getRealPath("/images/relatorios/");
        geral += "\\" + usuario.getUsername() + "Geral.png";
        
        String estrutura =  getServletContext().getRealPath("/images/relatorios/");
        estrutura += "\\" + usuario.getUsername() + "Estrutura.png";
        
        String cliente =  getServletContext().getRealPath("/images/relatorios/");
        cliente += "\\" + usuario.getUsername() + "Cliente.png";
        
        
        File geralF = new File(geral);
        File estruturaF = new File(estrutura);
        File clienteF = new File(cliente);
        
        if( ( geralF.exists() && geralF.delete()) || (estruturaF.exists() && estruturaF.delete() ) || (clienteF.exists() && clienteF.delete() )){
            log.logInfo("Imagens de relatorios gerados por " + usuario.getNome() + " deletadas com sucesso.");
        }
        if (result_a) {*/
            try {
                request.getSession(false).invalidate();
                //atividadeDao.con.commit();
                usuarioDao.getCon().commit();
                conexao.fechar();
                log.logInfo("Usuario " + usuario.getNome() + " saiu do sistema com sucesso.");
                /*LoggerSab logger = new LoggerSab();
                logger.logInfo("Usuario " + usuario.getNome() + " saiu do sistema com sucesso.");
                logger.fileHandler.close();*/
                log.fileHandler.close();
                response.sendRedirect("index.jsp?e=0");
            } catch (SQLException ex) {
                conexao.fechar();
                log.logSevere("Tentativa de logout ("+ usuario.getNome() +") mal sucedida. SQLException: ", ex);
                /*LoggerSab logger = new LoggerSab();
                logger.logInfo("Usuario " + usuario.getNome() + " saiu do sistema com sucesso.");
                logger.fileHandler.close();*/
                log.fileHandler.close();
                System.out.println("SQLException em Logout: " + ex.getMessage());
                response.sendRedirect(location + "?e=9"); //erro atividade 
            } catch (IllegalStateException ex) {
                conexao.fechar();
                log.logSevere("Tentativa de logout em sessão inválida. IllegalStateException: ", ex);
                /*LoggerSab logger = new LoggerSab();
                logger.logInfo("Usuario " + usuario.getNome() + " saiu do sistema com sucesso.");
                logger.fileHandler.close();*/
                log.fileHandler.close();
                System.out.println("IllegalStateException em Logout: " + ex.getMessage());
                response.sendRedirect(location + "?e=9"); //erro atividade 
            }/*
        } else {
            try {
                atividadeDao.con.rollback();
                usuarioDao.con.rollback();
                conexao.fechar();
                log.logWarning("Tentativa de logout ("+ usuario.getNome() +"), nao inseriu atividade");
                LoggerSab logger = new LoggerSab();
                log.logWarning("Tentativa de logout ("+ usuario.getNome() +"), nao inseriu atividade");
                logger.fileHandler.close();
            } catch (SQLException ex) {
                log.logSevere("Tentativa de logout ("+ usuario.getNome() +"), nao inseriu atividade. SQLException: ", ex);
                LoggerSab logger = new LoggerSab();
                log.logSevere("Tentativa de logout ("+ usuario.getNome() +"), nao inseriu atividade. SQLException: ", ex);
                logger.fileHandler.close();
                System.out.println("SQLException lançada em Logout: " + ex.getMessage());
            }
            conexao.fechar();
            response.sendRedirect(location);
        }*/
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Logout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Logout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
