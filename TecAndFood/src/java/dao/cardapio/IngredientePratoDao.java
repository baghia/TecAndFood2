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
import java.util.ArrayList;
import model.aluno.Aluno;
import model.cardapio.IngredientePrato;
import model.cardapio.Prato;
import model.estoque.Ingrediente;
import model.estoque.UnidadeMedida;
import model.util.LoggerTec;

/**
 *
 * @author Windows
 */
public class IngredientePratoDao {

    private Conexao conexao = null;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs;
    private LoggerTec logger;

    public IngredientePratoDao(Conexao conexao, LoggerTec logger) {
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

    public ArrayList<IngredientePrato> buscarPorPrato(Prato prato) {
        String sql = "SELECT ingredienteprato.id, ingredienteprato.ingrediente, ingredienteprato.prato, ingredienteprato.quantidade,"+
                " ingrediente.nome, unidademedida.sigla FROM ingredienteprato, ingrediente, unidademedida "
                + "WHERE prato=? "
                + "AND ingredienteprato.ingrediente = ingrediente.id "
                + "AND ingrediente.unidademedida = unidademedida.id";
        ArrayList<IngredientePrato> ingredientePratos = new ArrayList<>();
        IngredientePrato ingredientePrato = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, prato.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                ingredientePrato = new IngredientePrato();
                ingredientePrato.setId(rs.getInt("id"));
                Ingrediente ingrediente = new Ingrediente();
                UnidadeMedida um = new UnidadeMedida();
                um.setSigla(rs.getString("sigla"));
                ingrediente.setId(rs.getInt("ingrediente"));
                ingrediente.setNome(rs.getString("nome"));
                ingrediente.setUnidadeMedida(um);
                ingredientePrato.setIngrediente(ingrediente);
                ingredientePrato.setQuantidade(rs.getFloat("quantidade"));
                
                
                
                ingredientePratos.add(ingredientePrato);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro buscarPorPrato" + prato.getId() + ") IngredientePratoDao. SQLException: ", ex);
            System.out.println("Erro buscarPorPrato" + prato.getId() + ") IngredientePratoDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro buscarPorPrato" + prato.getId() + ") IngredientePratoDao. NullPointerException: ", ex);
            System.out.println("Erro buscarPorPrato" + prato.getId() + ") IngredientePratoDao: " + ex.getMessage());
        }
        return ingredientePratos;
    }
}
