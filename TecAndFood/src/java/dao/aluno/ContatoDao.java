package dao.aluno;

import dao.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.aluno.Aluno;
import model.aluno.Contato;
import model.util.LoggerTec;
import model.util.Tipo;

public class ContatoDao {
    private Conexao conexao = null;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs;
    private LoggerTec logger;

    
    public ContatoDao(Conexao conexao, LoggerTec logger) {
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

    /* ** INSERT ** */
    public boolean inserir(Contato contato) {
        String sql = "INSERT INTO contato VALUES(default, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, contato.getTipo().getId());
            ps.setInt(1, contato.getAluno().getId());
            ps.setString(3, contato.getValor());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro inserir ContatoDao. SQLException: ", ex);
            System.out.println("Erro inserir ContatoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro inserir ContatoDao. NullPointerException: ", ex);
            System.out.println("Erro iinserir ContatoDao: " + ex.getMessage());
            return false;
        }
    }

    /* ** UPDATES **/
    public boolean alterarAluno(int valor, int id) {
        String sql = "UPDATE contato SET aluno=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarAluno(" + valor + ", " + id + ") ContatoDao. SQLException: ", ex);
            System.out.println("Erro alterarAluno(" + valor + ", " + id + ") ContatoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarAluno(" + valor + ", " + id + ") ContatoDao. NullPointerException: ", ex);
            System.out.println("Erro alterarAluno(" + valor + ", " + id + ") ContatoDao: " + ex.getMessage());
            return false;
        }
    }

    public boolean alterarValor(String valor, int id) {
        String sql = "UPDATE contato SET valor=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarValor(" + valor + ", " + id + ") ContatoDao. SQLException: ", ex);
            System.out.println("Erro alterarValor(" + valor + ", " + id + ") ContatoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarValor(" + valor + ", " + id + ") ContatoDao. NullPointerException: ", ex);
            System.out.println("Erro alterarValor(" + valor + ", " + id + ") ContatoDao: " + ex.getMessage());
            return false;
        }
    }

    public Contato buscar(int aluno) {
        String sql = "SELECT contato.*, tipo.nome FROM contato join tipo on (tipo.id = contato.tipo) WHERE aluno=?";
        Contato contato = new Contato();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, aluno);
            rs = ps.executeQuery();
            while (rs.next()) {
                contato.setAluno(new Aluno());
                contato.getAluno().setId(aluno);
                contato.setTipo(new Tipo());
                contato.getTipo().setId(rs.getInt("tipo"));
                contato.setValor(rs.getString("valor"));
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro buscar("+ aluno +") ContatoDao. SQLException: ", ex);
            System.out.println("Erro buscar("+ aluno +") ContatoDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro buscar("+ aluno +") ContatoDao. NullPointerException: ", ex);
            System.out.println("Erro buscar("+ aluno +") ContatoDao: " + ex.getMessage());
        }
        return contato;
    }
}
