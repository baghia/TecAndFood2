package dao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.util.LoggerTec;
import model.util.Tipo;

public class TipoDao {
    private Conexao conexao = null;
    public Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs;
    public LoggerTec logger;
    
    public Connection getCon(){
        return this.con;
    }
    public void setCon(Connection con){
       this.con = con;
    }
    
    /* ** INSERT **/
    public boolean inserir(Tipo tipo){
        String sql = "INSERT INTO tipo VALUES(default, ?, ?, ?)";
        boolean i;
        try {
            //on = conexao.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipo.getNome());
            ps.setString(2, tipo.getDescricao());
            ps.setInt(3, tipo.getCodDescricao());
            i = ps.execute();
            return i;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro inserir TipoDao. SQLException: ", ex);
            System.out.println("Erro inserir TipoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro inserir TipoDao. NullPointerException: ", ex);
            System.out.println("Erro inserir TipoDao: " + ex.getMessage());
            return false;
        }
    }
    
    /* ** UPDATES ** */
    public boolean alterarNome(String valor, int id){
        String sql = "UPDATE tipo SET nome=? WHERE id=?";
        boolean i;
        try {
            //con = conexao.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, id);
            i = ps.execute();
            return i;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarNome("+ valor +", " + id +") TipoDao. SQLException: ", ex);
            System.out.println("Erro alterarNome("+ valor +", " + id +") TipoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarNome("+ valor +", " + id +") TipoDao. NullPointerException: ", ex);
            System.out.println("Erro alterarNome("+ valor +", " + id +") TipoDao: " + ex.getMessage());
            return false;
        }
    }
    public boolean alterarDescricao(String valor, int id){
        String sql = "UPDATE tipo SET descricao=? WHERE id=?";
        boolean i;
        try {
            //con = conexao.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, id);
            i = ps.execute();
            return i;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarDescricao("+ valor +", " + id +") TipoDao. SQLException: ", ex);
            System.out.println("Erro alterarDescricao("+ valor +", " + id +") TipoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarDescricao("+ valor +", " + id +") TipoDao. NullPointerException: ", ex);
            System.out.println("Erro alterarDescricao("+ valor +", " + id +") TipoDao: " + ex.getMessage());
            return false;
        }
    }
    public boolean alterarCodDescricao(int valor, int id){
        String sql = "UPDATE tipo SET codDescricao=? WHERE id=?";
        boolean i;
        try {
            //con = conexao.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, valor);
            ps.setInt(2, id);
            i = ps.execute();
            return i;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarCodDescricao("+ valor +", " + id +") TipoDao. SQLException: ", ex);
            System.out.println("Erro alterarCodDescricao("+ valor +", " + id +") TipoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarCodDescricao("+ valor +", " + id +") TipoDao. NullPointerException: ", ex);
            System.out.println("Erro alterarCodDescricao("+ valor +", " + id +") TipoDao: " + ex.getMessage());
            return false;
        }
    }
    /* * SELECTS **/
    public ArrayList<Tipo> listar(){
        String sql = "SELECT * FROM tipo";        
        ArrayList<Tipo> tipos = new ArrayList<>();
        try{
            //con = conexao.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Tipo tipo = new Tipo();
                tipo.setId(rs.getInt("id"));
                tipo.setNome(rs.getString("nome"));
                tipo.setDescricao(rs.getString("descricao"));
                tipo.setCodDescricao(rs.getInt("codDescricao"));
                tipos.add(tipo);            
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro listar TipoDao. SQLException: ", ex);
            System.out.println("Erro listar TipoDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro listar TipoDao. NullPointerException: ", ex);
            System.out.println("Erro listar TipoDao: " + ex.getMessage());
        }
        return tipos;
    }
    public ArrayList<Tipo> listarCodDescricao(int cod){
        String sql = "SELECT * FROM tipo WHERE codDescricao=?";        
        ArrayList<Tipo> tipos = new ArrayList<>();
        try{
            //con = conexao.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            while(rs.next()){
                Tipo tipo = new Tipo();
                tipo.setId(rs.getInt("id"));
                tipo.setNome(rs.getString("nome"));
                tipo.setDescricao(rs.getString("descricao"));
                tipo.setCodDescricao(rs.getInt("codDescricao"));
                tipos.add(tipo);            
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro listarCodDescricao("+ cod +") TipoDao. SQLException: ", ex);
            System.out.println("Erro listarCodDescricao("+ cod +") TipoDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro listarCodDescricao("+ cod +") TipoDao. NullPointerException: ", ex);
            System.out.println("Erro listarCodDescricao("+ cod +") TipoDao: " + ex.getMessage());
        }
        return tipos;
    }
    public Tipo consultar(int id){
        String sql = "SELECT * FROM tipo WHERE id=?";        
        Tipo tipo = new Tipo();
        try{
            //con = conexao.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                tipo.setId(rs.getInt("id"));
                tipo.setNome(rs.getString("nome"));
                tipo.setDescricao(rs.getString("descricao"));
                tipo.setCodDescricao(rs.getInt("codDescricao"));           
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro consultar("+ id +") TipoDao. SQLException: ", ex);
            System.out.println("Erro consultar("+ id +") TipoDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro consultar("+ id +") TipoDao. NullPointerException: ", ex);
            System.out.println("Erro consultar("+ id +") TipoDao: " + ex.getMessage());
        }
        return tipo;
    }
}
