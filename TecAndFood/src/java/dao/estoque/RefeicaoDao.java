package dao.estoque;

import dao.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
