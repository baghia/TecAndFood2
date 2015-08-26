package dao.estoque;

import dao.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.estoque.Intervalo;
import model.util.LoggerTec;

public class IntervaloDao {

    private Conexao conexao = null;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs;
    private LoggerTec logger;

    public IntervaloDao(Conexao conexao, LoggerTec logger) {
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

    public int inserir(int quantidadeEsperada) {
        String sql = "INSERT INTO intervalo VALUES(default, default, default, ?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, quantidadeEsperada);
            ps.execute();
            rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            return id;
        } catch (SQLException ex) {
            //this.logger.logSevere("Erro inserir IntervaloDao. SQLException: ", ex);
            System.out.println("Erro inserir IntervaloDao: " + ex.getMessage());
            return -1;
        } catch (NullPointerException ex) {
            //this.logger.logSevere("Erro inserir IntervaloDao. NullPointerException: ", ex);
            System.out.println("Erro inserir IntervaloDao: " + ex.getMessage());
            return -1;
        }
    }

    /* ** UPDATES ** */
    public boolean alterarStatus(boolean valor, int id) {
        String sql = "UPDATE intervalo SET ativo=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            //this.logger.logSevere("Erro alterarNome(" + valor + ", " + id + ") AlunoDao. SQLException: ", ex);
            System.out.println("Erro alterarNome(" + valor + ", " + id + ") AlunoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            //this.logger.logSevere("Erro alterarNome(" + valor + ", " + id + ") AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro alterarNome(" + valor + ", " + id + ") AlunoDao: " + ex.getMessage());
            return false;
        }
    }

    public Intervalo buscarUltimo() {
        String sql = "SELECT * from intervalo where dataHora = (SELECT max(dataHora) FROM intervalo)";
        Intervalo intervalo = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                intervalo = new Intervalo();
                intervalo.setId(rs.getInt("id"));
                intervalo.setDataHoraSql(rs.getTimestamp("dataHora"));
                intervalo.setAtivo(rs.getBoolean("ativo"));
                intervalo.setQtdEsperada(rs.getInt("qtdesperada"));
            }
        } catch (SQLException ex) {
            //this.logger.logSevere("Erro buscarUltimo IntervaloDao. SQLException: ", ex);
            System.out.println("Erro buscarUltimo IntervaloDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            //this.logger.logSevere("Erro buscarUltimo IntervaloDao. NullPointerException: ", ex);
            System.out.println("Erro buscarUltimo IntervaloDao: " + ex.getMessage());
        }
        return intervalo;
    }

    public Intervalo buscarPorId(int id) {
        String sql = "SELECT * from intervalo where id = ?";
        Intervalo intervalo = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                intervalo = new Intervalo();
                intervalo.setId(rs.getInt("id"));
                intervalo.setDataHoraSql(rs.getTimestamp("dataHora"));
                intervalo.setAtivo(rs.getBoolean("ativo"));
                intervalo.setQtdEsperada(rs.getInt("qtdesperada"));
            }
        } catch (SQLException ex) {
            //this.logger.logSevere("Erro buscarUltimo IntervaloDao. SQLException: ", ex);
            System.out.println("Erro buscarUltimo IntervaloDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            //this.logger.logSevere("Erro buscarUltimo IntervaloDao. NullPointerException: ", ex);
            System.out.println("Erro buscarUltimo IntervaloDao: " + ex.getMessage());
        }
        return intervalo;
    }
    
      public double calcularPaginacao() {
        String sql = "SELECT count(id) as count FROM intervalo";
        int count = -1;
        double result = 1;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
            if (count > 10) {
                result = (double) count / 10;
                double floor = (double) Math.floor(result);
                double diferenca = result - floor;
                if (diferenca > 0.0) {
                    result++;
                }
            }
        } catch (SQLException ex) {
            //this.logger.logSevere("Erro calcularPaginacao IngredienteDao. SQLException: ", ex);
            System.out.println("Erro intervaloDao calcularPaginacao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            //this.logger.logSevere("Erro calcularPaginacao IngredienteDao. NullPointerException: ", ex);
            System.out.println("Erro intervaloDao calcularPaginacao: " + ex.getMessage());
        }
        return result;
    }
      
      public ArrayList<Intervalo> listar(int offset) {
        String sql = "SELECT * FROM intervalo ORDER BY datahora DESC limit 10 offset ?";
        ArrayList<Intervalo> intervalos = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, offset);
            rs = ps.executeQuery();
            while (rs.next()) {
                Intervalo intervalo = new Intervalo();
                intervalo.setId(rs.getInt("id"));
                intervalo.setAtivo(rs.getBoolean("ativo"));
                intervalo.setQtdEsperada(rs.getInt("qtdesperada"));
                intervalo.setDataHoraSql(rs.getTimestamp("datahora"));
                intervalos.add(intervalo);
            }
        } catch (SQLException ex) {
            //this.logger.logSevere("Erro listar(" + offset + ") IngredienteDao. SQLException: ", ex);
            System.out.println("Erro listar(" + offset + ") IntervaloDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            //this.logger.logSevere("Erro listar(" + offset + ") IngredienteDao. NullPointerException: ", ex);
            System.out.println("Erro listar(" + offset + ") IntervaloDao: " + ex.getMessage());
        }
        return intervalos;
    }
}
