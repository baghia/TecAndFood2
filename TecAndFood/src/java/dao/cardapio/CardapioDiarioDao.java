package dao.cardapio;

import dao.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.cardapio.CardapioDiario;
import model.util.LoggerTec;

public class CardapioDiarioDao {
    private Conexao conexao = null;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs;
    private LoggerTec logger;

    public CardapioDiarioDao(Conexao conexao, LoggerTec logger) {
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

    public int inserir(CardapioDiario cardapio) {
        String sql = "INSERT INTO cardapioDiario VALUES(default, ?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, cardapio.getDiaSql());
            ps.execute();
            rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            return id;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro inserir CardapioDiarioDao. SQLException: ", ex);
            System.out.println("Erro inserir CardapioDiarioDao: " + ex.getMessage());
            return -1;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro inserir CardapioDiarioDao. NullPointerException: ", ex);
            System.out.println("Erro inserir CardapioDiarioDao: " + ex.getMessage());
            return -1;
        }
    }
   
    /* ** UPDATES ** */

    public boolean alterarData(java.sql.Date valor, int id) {
        String sql = "UPDATE intervalo SET dia=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setDate(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarData(" + valor + ", " + id + ") CardapioDiarioDao. SQLException: ", ex);
            System.out.println("Erro alterarData(" + valor + ", " + id + ") CardapioDiarioDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarData(" + valor + ", " + id + ") CardapioDiarioDao. NullPointerException: ", ex);
            System.out.println("Erro alterarData(" + valor + ", " + id + ") CardapioDiarioDao: " + ex.getMessage());
            return false;
        }
    }
    
    public ArrayList<CardapioDiario> listarAtivos() {
        String sql = "SELECT * FROM cardapioDiario ORDER BY dia DESC";
        ArrayList<CardapioDiario> cardapios = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CardapioDiario cardapio = new CardapioDiario();
                cardapio.setId(rs.getInt("id"));
                cardapio.setDiaSql(rs.getDate("dia"));
                cardapios.add(cardapio);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro listar CardapioDiarioDao. SQLException: ", ex);
            System.out.println("Erro listar CardapioDiarioDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro listar CardapioDiarioDao. NullPointerException: ", ex);
            System.out.println("Erro listar CardapioDiarioDao: " + ex.getMessage());
        }
        return cardapios;
    }
}
