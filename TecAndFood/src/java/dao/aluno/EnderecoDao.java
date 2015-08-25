package dao.aluno;

import dao.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.aluno.Endereco;
import model.aluno.Estado;
import model.util.LoggerTec;

public class EnderecoDao {
    private Conexao conexao = null;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs;
    private LoggerTec logger;
    
    
    public EnderecoDao(Conexao conexao, LoggerTec logger) {
        this.conexao = conexao;
        this.con = conexao.getConexao();
        this.logger = logger;
    }
    public Connection getCon(){
        return this.con;
    }
    public void setCon(Connection con){
       this.con = con;
    }
    /* ** INSERT **/
    public int inserir(Endereco endereco){
        String sql = "INSERT INTO endereco VALUES(default, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, endereco.getRua());
            ps.setString(2, endereco.getBairro());
            ps.setInt(3, endereco.getNum());
            ps.setString(4, endereco.getCidade());
            ps.setInt(5, endereco.getEstado().getId());
            ps.setString(6, endereco.getCep());
            ps.execute();
            rs = ps.getGeneratedKeys();  
            rs.next();  
            int id = rs.getInt(1);  
            return id;
        } catch (SQLException ex) {
            //this.logger.logSevere("Erro inserir EnderecoDao. SQLException: ", ex);
            System.out.println("Erro inserir EnderecoDao: " + ex.getMessage());
            return -1;
        } catch (NullPointerException ex) {
            //this.logger.logSevere("Erro inserir EnderecoDao. NullPointerException: ", ex);
            System.out.println("Erro inserir EnderecoDao: " + ex.getMessage());
            return -1;
        }
    }
    
    /* ** UPDATES ** */
    public boolean alterarRua(String valor, int id){
        String sql = "UPDATE endereco SET rua=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            //this.logger.logSevere("Erro alterarRua("+ valor +", " + id +") EnderecoDao. SQLException: ", ex);
            System.out.println("Erro alterarRua("+ valor +", " + id +") EnderecoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            //this.logger.logSevere("Erro alterarRua("+ valor +", " + id +") EnderecoDao. NullPointerException: ", ex);
            System.out.println("Erro alterarRua("+ valor +", " + id +") EnderecoDao: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean alterarBairro(String valor, int id){
        String sql = "UPDATE endereco SET bairro=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            //this.logger.logSevere("Erro alterarBairro("+ valor +", " + id +") EnderecoDao. SQLException: ", ex);
            System.out.println("Erro alterarBairro("+ valor +", " + id +") EnderecoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            //this.logger.logSevere("Erro alterarBairro("+ valor +", " + id +") EnderecoDao. NullPointerException: ", ex);
            System.out.println("Erro alterarBairro("+ valor +", " + id +") EnderecoDao: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean alterarNum(int valor, int id){
        String sql = "UPDATE endereco SET num=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            //this.logger.logSevere("Erro alterarNum("+ valor +", " + id +") EnderecoDao. SQLException: ", ex);
            System.out.println("Erro alterarNum("+ valor +", " + id +") EnderecoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            //this.logger.logSevere("Erro alterarNum("+ valor +", " + id +") EnderecoDao. NullPointerException: ", ex);
            System.out.println("Erro alterarNum("+ valor +", " + id +") EnderecoDao: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean alterarCidade(String valor, int id){
        String sql = "UPDATE endereco SET cidade=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            //this.logger.logSevere("Erro alterarCidade("+ valor +", " + id +") EnderecoDao. SQLException: ", ex);
            System.out.println("Erro alterarCidade("+ valor +", " + id +") EnderecoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            //this.logger.logSevere("Erro alterarCidade("+ valor +", " + id +") EnderecoDao. NullPointerException: ", ex);
            System.out.println("Erro alterarCidade("+ valor +", " + id +") EnderecoDao: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean alterarEstado(int valor, int id){
        String sql = "UPDATE endereco SET estado=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            //this.logger.logSevere("Erro alterarEstado("+ valor +", " + id +") EnderecoDao. SQLException: ", ex);
            System.out.println("Erro alterarEstado("+ valor +", " + id +") EnderecoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            //this.logger.logSevere("Erro alterarEstado("+ valor +", " + id +") EnderecoDao. NullPointerException: ", ex);
            System.out.println("Erro alterarEstado("+ valor +", " + id +") EnderecoDao: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean alterarCep(String valor, int id){
        String sql = "UPDATE endereco SET cep=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            //this.logger.logSevere("Erro alterarCEP("+ valor +", " + id +") EnderecoDao. SQLException: ", ex);
            System.out.println("Erro alterarCEP("+ valor +", " + id +") EnderecoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            //this.logger.logSevere("Erro alterarCEP("+ valor +", " + id +") EnderecoDao. NullPointerException: ", ex);
            System.out.println("Erro alterarCEP("+ valor +", " + id +") EnderecoDao: " + ex.getMessage());
            return false;
        }
    }
    
    /* * SELECTS **/
    public ArrayList<Endereco> listar(){
        String sql = "SELECT endereco.*, estado.nome as nomeEstado FROM endereco join estado on (endereco.estado = estado.id)";        
        ArrayList<Endereco> enderecos = new ArrayList<>();
        try{
            //con = conexao.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Endereco endereco = new Endereco();
                endereco.setEstado(new Estado());
                
                endereco.setId(rs.getInt("id"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setNum(rs.getInt("num"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.getEstado().setId(rs.getInt("estado"));
                endereco.getEstado().setNome(rs.getString("nomeEstado"));
                enderecos.add(endereco);
            }
        } catch(SQLException ex){
            //this.logger.logSevere("Erro listar EnderecoDao. SQLException: ", ex);
            System.out.println("Erro listar EnderecoDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            //this.logger.logSevere("Erro listar EnderecoDao. NullPointerException: ", ex);
            System.out.println("Erro listar EnderecoDao: " + ex.getMessage());
        }
        return enderecos;
    }
    public Endereco consultar(int id){
        String sql = "SELECT * from endereco where id=?"; 
        Endereco endereco = new Endereco();       
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                endereco.setId(rs.getInt("id"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setNum(rs.getInt("num"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(new Estado());
                endereco.getEstado().setId(rs.getInt("estado"));
                endereco.setCep(rs.getString("cep"));
            }
        } catch(SQLException ex){
            //this.logger.logSevere("Erro consultar("+ id +") EnderecoDao. SQLException: ", ex);
            System.out.println("Erro consultar("+ id +") EnderecoDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            //this.logger.logSevere("Erro consultar("+ id +") EnderecoDao. NullPointerException: ", ex);
            System.out.println("Erro consultar("+ id +") EnderecoDao: " + ex.getMessage());
        }
        return endereco;
    }
    public Endereco consultarfull(int id){
        String sql = "SELECT endereco.*, estado.sigla as sigla from endereco join estado on (endereco.estado = estado.id) where endereco.id=?"; 
        Endereco endereco = new Endereco();       
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                endereco.setId(rs.getInt("id"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(new Estado());
                endereco.getEstado().setId(rs.getInt("estado"));
                endereco.getEstado().setSigla(rs.getString("sigla"));
            }
        } catch(SQLException ex){
            //this.logger.logSevere("Erro consultarFull("+ id +") EnderecoDao. SQLException: ", ex);
            System.out.println("Erro consultarFull("+ id +") EnderecoDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            //.logger.logSevere("Erro consultarFull("+ id +") EnderecoDao. NullPointerException: ", ex);
            System.out.println("Erro consultarFull("+ id +") EnderecoDao: " + ex.getMessage());
        }
        return endereco;
    }
}
