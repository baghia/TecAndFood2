package dao.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
    private String driver = "org.postgresql.Driver";
    private String usuario = "postgres";
    private String senha = "postgres";
    private String banco = "sab";
    private String host = "localhost";
    private String porta = "5432";
    private String url = "jdbc:postgresql://" + this.host + ":" + this.porta + "/" + this.banco;
    private Connection conexao;
    
    public void setConexao(Connection con){
        this.conexao = con;
    }
    public Connection getConexao(){
        return this.conexao;
    }
    public Connection conectar() {
        try {
            Class.forName(driver);
            this.conexao = DriverManager.getConnection(url, usuario, senha);
            this.conexao.setAutoCommit(false);
            System.out.println("Conexão ok!");
        } catch (SQLException ex) {
            System.out.println("erro na conexao");
        } catch (ClassNotFoundException ex) {
            System.out.println("erro no driver");
        }
        return this.conexao;
    }
   public void fechar() {
        try {
            this.conexao.close();
            System.out.println("Conexão fechada.");
        } catch (SQLException ex) {
            System.out.println("erro ao fechar conexao");
        }
    }
}
