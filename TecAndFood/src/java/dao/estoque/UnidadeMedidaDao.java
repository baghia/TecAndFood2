package dao.estoque;

import dao.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.estoque.UnidadeMedida;
import model.util.LoggerTec;

public class UnidadeMedidaDao {
    private Conexao conexao = null;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs;
    private LoggerTec logger;

    public UnidadeMedidaDao(Conexao conexao, LoggerTec logger) {
        this.conexao = conexao;
        this.con = conexao.getConexao();
        this.logger = logger;
    }    
    
    public Connection getCon(){
        return this.con;
    }
    
    /* ** INSERT **/
    public boolean inserir(UnidadeMedida unidade){
        String sql = "INSERT INTO unidadeMedida VALUES(default, ?, ?)";
        boolean i;
        try {
            //on = conexao.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, unidade.getNome());
            ps.setString(2, unidade.getSigla());
            i = ps.execute();
            return i;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro inserir UnidadeMedidaDao. SQLException: ", ex);
            System.out.println("Erro inserir UnidadeMedidaDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro inserir UnidadeMedidaDao. NullPointerException: ", ex);
            System.out.println("Erro inserir UnidadeMedidaDao: " + ex.getMessage());
            return false;
        }
    }
    
    /* ** UPDATES ** */
    public boolean alterarNome(String valor, int id){
        String sql = "UPDATE unidadeMedida SET nome=? WHERE id=?";
        boolean i;
        try {
            //con = conexao.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, id);
            i = ps.execute();
            return i;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarNome("+ valor +", " + id +") UnidadeMedidaDao. SQLException: ", ex);
            System.out.println("Erro alterarNome("+ valor +", " + id +") UnidadeMedidaDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarNome("+ valor +", " + id +") UnidadeMedidaDao. NullPointerException: ", ex);
            System.out.println("Erro alterarNome("+ valor +", " + id +") UnidadeMedidaDao: " + ex.getMessage());
            return false;
        }
    }
    public boolean alterarSigla(String valor, int id){
        String sql = "UPDATE unidadeMedida SET sigla=? WHERE id=?";
        boolean i;
        try {
            //con = conexao.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, id);
            i = ps.execute();
            return i;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarSigla("+ valor +", " + id +") UnidadeMedidaDao. SQLException: ", ex);
            System.out.println("Erro alterarSigla("+ valor +", " + id +") UnidadeMedidaDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarSigla("+ valor +", " + id +") UnidadeMedidaDao. NullPointerException: ", ex);
            System.out.println("Erro alterarSigla("+ valor +", " + id +") UnidadeMedidaDao: " + ex.getMessage());
            return false;
        }
    }
    /* * SELECTS **/
    public ArrayList<UnidadeMedida> listar(){
        String sql = "SELECT * FROM unidadeMedida ORDER BY nome asc";        
        ArrayList<UnidadeMedida> unidadesMedida = new ArrayList<>();
        try{
            //con = conexao.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                UnidadeMedida unidadeMedida = new UnidadeMedida();
                unidadeMedida.setId(rs.getInt("id"));
                unidadeMedida.setNome(rs.getString("nome"));
                unidadeMedida.setSigla(rs.getString("sigla"));
                unidadesMedida.add(unidadeMedida);            
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro listar UnidadeMedidaDao. SQLException: ", ex);
            System.out.println("Erro listar UnidadeMedidaDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro listar UnidadeMedidaDao. NullPointerException: ", ex);
            System.out.println("Erro listar UnidadeMedidaDao: " + ex.getMessage());
        }
        return unidadesMedida;
    }
    
    public UnidadeMedida consultar(int id){
        String sql = "SELECT * FROM unidadeMedida WHERE id=?";        
        UnidadeMedida unidadeMedida = new UnidadeMedida();
        try{
            //con = conexao.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                unidadeMedida.setId(rs.getInt("id"));
                unidadeMedida.setNome(rs.getString("nome"));
                unidadeMedida.setSigla(rs.getString("sigla"));           
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro consultar("+ id +") UnidadeMedidaDao. SQLException: ", ex);
            System.out.println("Erro consultar("+ id +") UnidadeMedidaDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro consultar("+ id +") UnidadeMedidaDao. NullPointerException: ", ex);
            System.out.println("Erro consultar("+ id +") UnidadeMedidaDao: " + ex.getMessage());
        }
        return unidadeMedida;
    }
}
