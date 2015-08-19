package dao.aluno;

import dao.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.aluno.Aluno;
import model.aluno.Responsavel;
import model.util.LoggerTec;
import model.util.Tipo;

public class ResponsavelDao {
    private Conexao conexao = null;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs;
    private LoggerTec logger;
    
    public ResponsavelDao(Conexao conexao, LoggerTec logger) {
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
    /*
     id serial PRIMARY KEY,
     nome text NOT NULL,
     tipo integer NOT NULL,
     aluno 
     */

    public int inserir(Responsavel responsavel) {
        String sql = "INSERT INTO responsavel VALUES(default, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, responsavel.getNome());
            ps.setInt(2, responsavel.getAluno().getId());
            ps.setInt(3, responsavel.getTipo().getId());
            ps.execute();
            rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            return id;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro inserir ResponsavelDao. SQLException: ", ex);
            System.out.println("Erro inserir ResponsavelDao: " + ex.getMessage());
            return -1;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro inserir ResponsavelDao. NullPointerException: ", ex);
            System.out.println("Erro inserir ResponsavelDao: " + ex.getMessage());
            return -1;
        }
    }

    /* ** UPDATES ** */
    public boolean alterarNome(String valor, int id) {
        String sql = "UPDATE responsavel SET nome=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarNome(" + valor + ", " + id + ") ResponsavelDao. SQLException: ", ex);
            System.out.println("Erro alterarNome(" + valor + ", " + id + ") ResponsavelDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarNome(" + valor + ", " + id + ") ResponsavelDao. NullPointerException: ", ex);
            System.out.println("Erro alterarNome(" + valor + ", " + id + ") ResponsavelDao: " + ex.getMessage());
            return false;
        }
    }

    public boolean alterarTipo(int valor, int id) {
        String sql = "UPDATE responsavel SET tipo=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarTipo(" + valor + ", " + id + ") ResponsavelDao. SQLException: ", ex);
            System.out.println("Erro alterarTipo(" + valor + ", " + id + ") ResponsavelDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarTipo(" + valor + ", " + id + ") ResponsavelDao. NullPointerException: ", ex);
            System.out.println("Erro alterarTipo(" + valor + ", " + id + ") ResponsavelDao: " + ex.getMessage());
            return false;
        }
    }

    public boolean alterarAluno(int valor, int id) {
        String sql = "UPDATE responsavel SET aluno=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarAluno(" + valor + ", " + id + ") ResponsavelDao. SQLException: ", ex);
            System.out.println("Erro alterarAluno(" + valor + ", " + id + ") ResponsavelDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarAluno(" + valor + ", " + id + ") ResponsavelDao. NullPointerException: ", ex);
            System.out.println("Erro alterarAluno(" + valor + ", " + id + ") ResponsavelDao: " + ex.getMessage());
            return false;
        }
    }
    /* * SELECTS **/

    public ArrayList<Responsavel> buscar(int idaluno) {
        String sql = "SELECT responsavel.*, aluno.nome as nomealuno, tipo.nome as nometipo "
                + "FROM aluno join responsavel on (responsavel.aluno = aluno.id) join tipo on (responsavel.tipo = tipo.id) "
                + "WHERE aluno=?";
        ArrayList<Responsavel> responsaveis = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idaluno);
            rs = ps.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                Tipo tipo = new Tipo();
                Responsavel responsavel = new Responsavel();

                tipo.setId(rs.getInt("tipo"));
                tipo.setNome(rs.getString("nometipo"));

                aluno.setId(rs.getInt("aluno"));
                aluno.setNome(rs.getString("nomealuno"));

                responsavel.setId(rs.getInt("id"));
                responsavel.setAluno(aluno);
                responsavel.setTipo(tipo);
                responsaveis.add(responsavel);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro buscar(" + idaluno + ") ResponsavelDao. SQLException: ", ex);
            System.out.println("Erro buscar(" + idaluno + ") ResponsavelDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro buscar(" + idaluno + ") ResponsavelDao. NullPointerException: ", ex);
            System.out.println("Erro buscar(" + idaluno + ") ResponsavelDao: " + ex.getMessage());
        }
        return responsaveis;
    }
}
