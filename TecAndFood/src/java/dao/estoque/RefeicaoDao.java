package dao.estoque;

import dao.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.estoque.Refeicao;
import model.util.LoggerTec;

public class RefeicaoDao {
    private Conexao conexao = null;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs;
    private LoggerTec logger;
    
    public RefeicaoDao(Conexao conexao, LoggerTec logger) {
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
    
    /*
    id serial PRIMARY KEY,
    aluno integer NOT NULL,
    pratoCarDiario integer NOT NULL,
    ingredientePrato integer NOT NULL,
    dataHora
    */
    public boolean inserir(Refeicao refeicao) {
        String sql = "INSERT INTO refeicao VALUES(default, ?, ?, ?, default)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, refeicao.getAluno().getId());
            ps.setInt(2, refeicao.getPrato().getId());
            ps.setInt(3, refeicao.getIngrediente().getId());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro inserir IngredienteDao. SQLException: ", ex);
            System.out.println("Erro inserir IngredienteDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro inserir IngredienteDao. NullPointerException: ", ex);
            System.out.println("Erro inserir IngredienteDao: " + ex.getMessage());
            return false;
        }
    }
}
