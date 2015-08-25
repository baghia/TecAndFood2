package dao.cardapio;

import dao.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.cardapio.CardapioDiario;
import model.cardapio.Prato;
import model.cardapio.PratoCardapioDiario;
import model.util.LoggerTec;
import model.util.Tipo;


public class PratoCardapioDiarioDao {
    private Conexao conexao = null;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs;
    private LoggerTec logger;

    public PratoCardapioDiarioDao(Conexao conexao, LoggerTec logger) {
        this.conexao = conexao;
        this.con = conexao.getConexao();
        this.logger = logger;
    }
    
    public Connection getCon() {
        return this.con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    /* ** INSERT **/

    public int inserir(PratoCardapioDiario prato) {
        String sql = "INSERT INTO pratoCarDiario VALUES(default, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, prato.getCardapio().getId());
            ps.setInt(2, prato.getPrato().getId());
            ps.setInt(3, prato.getTurno().getId());
            ps.execute();
            rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            return id;
        } catch (SQLException ex) {
            //this.logger.logSevere("Erro inserir PratoCardapioDiarioDao. SQLException: ", ex);
            System.out.println("Erro inserir PratoCardapioDiarioDao: " + ex.getMessage());
            return -1;
        } catch (NullPointerException ex) {
            //this.logger.logSevere("Erro inserir PratoCardapioDiarioDao. NullPointerException: ", ex);
            System.out.println("Erro inserir PratoCardapioDiarioDao: " + ex.getMessage());
            return -1;
        }
    }
   
    /* ** UPDATES ** */

    public boolean alterarPrato(int valor, int id) {
        String sql = "UPDATE pratoCarDiario SET prato=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            //this.logger.logSevere("Erro alterarPrato(" + valor + ", " + id + ") PratoCardapioDiarioDao. SQLException: ", ex);
            System.out.println("Erro alterarPrato(" + valor + ", " + id + ") PratoCardapioDiarioDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            //this.logger.logSevere("Erro alterarPrato(" + valor + ", " + id + ") PratoCardapioDiarioDao. NullPointerException: ", ex);
            System.out.println("Erro alterarPrato(" + valor + ", " + id + ") PratoCardapioDiarioDao: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean alterarCardapio(int valor, int id) {
        String sql = "UPDATE pratoCarDiario SET cardapio=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            //this.logger.logSevere("Erro alterarCardapio(" + valor + ", " + id + ") PratoCardapioDiarioDao. SQLException: ", ex);
            System.out.println("Erro alterarCardapio(" + valor + ", " + id + ") PratoCardapioDiarioDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            //this.logger.logSevere("Erro alterarCardapio(" + valor + ", " + id + ") PratoCardapioDiarioDao. NullPointerException: ", ex);
            System.out.println("Erro alterarCardapio(" + valor + ", " + id + ") PratoCardapioDiarioDao: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean alterarTurno(int valor, int id) {
        String sql = "UPDATE pratoCarDiario SET turno=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            //this.logger.logSevere("Erro alterarTurno(" + valor + ", " + id + ") PratoCardapioDiarioDao. SQLException: ", ex);
            System.out.println("Erro alterarTurno(" + valor + ", " + id + ") PratoCardapioDiarioDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            //this.logger.logSevere("Erro alterarTurno(" + valor + ", " + id + ") PratoCardapioDiarioDao. NullPointerException: ", ex);
            System.out.println("Erro alterarTurno(" + valor + ", " + id + ") PratoCardapioDiarioDao: " + ex.getMessage());
            return false;
        }
    }
    
    public ArrayList<PratoCardapioDiario> listarCardapio(int cardapioId) {
        String sql = "SELECT pratoCarDiario.*, prato.nome as nomePrato, tipo.nome as nomeTurno, cardapioDiario.dia "
                + "FROM "
                + "cardapioDiario join pratoCarDiario on (pratoCarDiario.cardapio = cardapioDiario.id) "
                + "join prato on (pratoCarDiario.prato = prato.id) "
                + "join tipo on (pratoCarDiario.turno = tipo.id) "
                + "WHERE pratoCarDiario.cardapio = ? "
                + "ORDER BY pratoCarDiario.turno ASC";
        ArrayList<PratoCardapioDiario> pratos = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cardapioId);
            rs = ps.executeQuery();
            while (rs.next()) {
                PratoCardapioDiario pratoC = new PratoCardapioDiario();
                Prato prato = new Prato();
                CardapioDiario cardapio = new CardapioDiario();
                Tipo turno = new Tipo();
                
                cardapio.setId(rs.getInt("cardapio"));
                cardapio.setDiaSql(rs.getDate("dia"));
                
                turno.setId(rs.getInt("turno"));
                turno.setNome(rs.getString("nomeTurno"));
                
                prato.setId(rs.getInt("prato"));
                prato.setNome(rs.getString("nomePrato"));
                        
                pratoC.setId(rs.getInt("id"));
                pratoC.setCardapio(cardapio);
                pratoC.setTurno(turno);
                pratoC.setPrato(prato);
                pratos.add(pratoC);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro listarCardapio("+ cardapioId+") PratoCardapioDiarioDao. SQLException: ", ex);
            System.out.println("Erro listarCardapio("+ cardapioId+") PratoCardapioDiarioDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro listarCardapio("+ cardapioId+") PratoCardapioDiarioDao. NullPointerException: ", ex);
            System.out.println("Erro listarCardapio("+ cardapioId+") PratoCardapioDiarioDao: " + ex.getMessage());
        }
        return pratos;
    }
}
