/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.cardapio;

import dao.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.aluno.Aluno;
import model.cardapio.Prato;
import model.util.LoggerTec;

/**
 *
 * @author Windows
 */
public class PratoDao {
    private Conexao conexao = null;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs;
    private LoggerTec logger;

    public PratoDao(Conexao conexao, LoggerTec logger) {
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
//    
//    public Prato buscarId(Integer id) {
//        String sql = "SELECT id, nome FROM aluno WHERE aluno.matricula=?";
//        
//        Aluno aluno = null;
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1, matricula);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                aluno = new Aluno();
//                aluno.setId(rs.getInt("id"));
//                aluno.setNome(rs.getString("nome"));
//            }
//        } catch (SQLException ex) {
//            this.logger.logSevere("Erro buscarMatricula" + matricula + ") AlunoDao. SQLException: ", ex);
//            System.out.println("Erro buscarMatricula" + matricula + ") AlunoDao: " + ex.getMessage());
//        } catch (NullPointerException ex) {
//            this.logger.logSevere("Erro buscarMatricula" + matricula + ") AlunoDao. NullPointerException: ", ex);
//            System.out.println("Erro buscarMatricula" + matricula + ") AlunoDao: " + ex.getMessage());
//        }
//        return aluno;
//    }
}
