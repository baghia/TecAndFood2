package dao.estoque;

import dao.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.estoque.Ingrediente;
import model.estoque.UnidadeMedida;
import model.util.LoggerTec;
import model.util.Parametro;

public class IngredienteDao {

    private Conexao conexao = null;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs;
    private LoggerTec logger;

    public IngredienteDao(Conexao conexao, LoggerTec logger) {
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
     unidadeMedida
     */
    public int inserir(Ingrediente ingrediente) {
        String sql = "INSERT INTO ingrediente VALUES(default, ?, ?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ingrediente.getNome());
            ps.setInt(2, ingrediente.getUnidadeMedida().getId());
            ps.execute();
            rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            return id;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro inserir IngredienteDao. SQLException: ", ex);
            System.out.println("Erro inserir IngredienteDao: " + ex.getMessage());
            return -1;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro inserir IngredienteDao. NullPointerException: ", ex);
            System.out.println("Erro inserir IngredienteDao: " + ex.getMessage());
            return -1;
        }
    }

    /* ** UPDATES ** */
    public boolean alterarNome(String valor, int id) {
        String sql = "UPDATE ingrediente SET nome=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarNome(" + valor + ", " + id + ") IngredienteDao. SQLException: ", ex);
            System.out.println("Erro alterarNome(" + valor + ", " + id + ") IngredienteDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarNome(" + valor + ", " + id + ") IngredienteDao. NullPointerException: ", ex);
            System.out.println("Erro alterarNome(" + valor + ", " + id + ") IngredienteDao: " + ex.getMessage());
            return false;
        }
    }

    public boolean alterarUnidadeMedida(int valor, int id) {
        String sql = "UPDATE ingrediente SET unidadeMedida=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarUnidadeMedida(" + valor + ", " + id + ") IngredienteDao. SQLException: ", ex);
            System.out.println("Erro alterarUnidadeMedida(" + valor + ", " + id + ") IngredienteDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarUnidadeMedida(" + valor + ", " + id + ") IngredienteDao. NullPointerException: ", ex);
            System.out.println("Erro alterarUnidadeMedida(" + valor + ", " + id + ") IngredienteDao: " + ex.getMessage());
            return false;
        }
    }
    /* * SELECTS **/

    public ArrayList<Ingrediente> listar() {
        String sql = "SELECT ingrediente.*, unidadeMedida.nome as nomeUnidade, unidadeMedida.sigla as siglaUnidade "
                + "FROM ingrediente join unidadeMedida on (ingrediente.unidadeMedida = unidadeMedida.id) ORDER BY ingrediente.nome ASC";
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ingrediente ingrediente = new Ingrediente();
                UnidadeMedida unidadeMedida = new UnidadeMedida();

                unidadeMedida.setId(rs.getInt("unidadeMedida"));
                unidadeMedida.setNome(rs.getString("nomeUnidade"));
                unidadeMedida.setSigla(rs.getString("siglaUnidade"));

                ingrediente.setId(rs.getInt("id"));
                ingrediente.setNome(rs.getString("nome"));
                ingrediente.setUnidadeMedida(unidadeMedida);
                ingredientes.add(ingrediente);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro listar IngredienteDao. SQLException: ", ex);
            System.out.println("Erro listar IngredienteDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro listar IngredienteDao. NullPointerException: ", ex);
            System.out.println("Erro listar IngredienteDao: " + ex.getMessage());
        }
        return ingredientes;
    }

    public ArrayList<Ingrediente> listar(int offset) {
        String sql = "SELECT ingrediente.*, unidadeMedida.nome as nomeUnidade, unidadeMedida.sigla as siglaUnidade "
                + "FROM ingrediente join unidadeMedida on (ingrediente.unidadeMedida = unidadeMedida.id) ORDER BY ingrediente.nome ASC limit 10 offset ?";
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, offset);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ingrediente ingrediente = new Ingrediente();
                UnidadeMedida unidadeMedida = new UnidadeMedida();

                unidadeMedida.setId(rs.getInt("unidadeMedida"));
                unidadeMedida.setNome(rs.getString("nomeUnidade"));
                unidadeMedida.setSigla(rs.getString("siglaUnidade"));

                ingrediente.setId(rs.getInt("id"));
                ingrediente.setNome(rs.getString("nome"));
                ingrediente.setUnidadeMedida(unidadeMedida);
                ingredientes.add(ingrediente);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro listar(" + offset + ") IngredienteDao. SQLException: ", ex);
            System.out.println("Erro listar(" + offset + ") IngredienteDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro listar(" + offset + ") IngredienteDao. NullPointerException: ", ex);
            System.out.println("Erro listar(" + offset + ") IngredienteDao: " + ex.getMessage());
        }
        return ingredientes;
    }

    public Ingrediente consultar(int id) {
        String sql = "SELECT ingrediente.*, unidadeMedida.nome as nomeUnidade, unidadeMedida.sigla as siglaUnidade "
                + "FROM ingrediente join unidadeMedida on (ingrediente.unidadeMedida = unidadeMedida.id) WHERE  ingrediente.id=?";
        Ingrediente ingrediente = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                ingrediente = new Ingrediente();
                UnidadeMedida unidadeMedida = new UnidadeMedida();

                unidadeMedida.setId(rs.getInt("unidadeMedida"));
                unidadeMedida.setNome(rs.getString("nomeUnidade"));
                unidadeMedida.setSigla(rs.getString("siglaUnidade"));

                ingrediente.setId(rs.getInt("id"));
                ingrediente.setUnidadeMedida(unidadeMedida);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro consultar(" + id + ") IngredienteDao. SQLException: ", ex);
            System.out.println("Erro consultar(" + id + ") IngredienteDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro consultar(" + id + ") IngredienteDao. NullPointerException: ", ex);
            System.out.println("Erro consultar(" + id + ") IngredienteDao: " + ex.getMessage());
        }
        return ingrediente;
    }

    public ArrayList<Ingrediente> pesquisar(String sql, ArrayList<Parametro> parametros) {
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            for (Parametro parametro : parametros) {
                switch (parametro.getNome()) {
                    case "unidadeMedida":
                        ps.setInt(parametro.getPosicao(), Integer.parseInt(parametro.getValor()));
                        break;
                    case "limit":
                        ps.setInt(parametro.getPosicao(), Integer.parseInt(parametro.getValor()));
                        break;
                    default:
                        ps.setString(parametro.getPosicao(), parametro.getValor());
                        break;
                }
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Ingrediente ingrediente = new Ingrediente();
                UnidadeMedida unidadeMedida = new UnidadeMedida();

                unidadeMedida.setId(rs.getInt("unidadeMedida"));
                unidadeMedida.setNome(rs.getString("nomeUnidade"));
                unidadeMedida.setSigla(rs.getString("siglaUnidade"));

                ingrediente.setId(rs.getInt("id"));
                ingrediente.setUnidadeMedida(unidadeMedida);
                ingredientes.add(ingrediente);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro pesquisar(" + sql + ") IngredienteDao. SQLException: ", ex);
            System.out.println("Erro pesquisar(" + sql + ") IngredienteDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro pesquisar(" + sql + ") IngredienteDao. NullPointerException: ", ex);
            System.out.println("Erro pesquisar(" + sql + ") IngredienteDao: " + ex.getMessage());
        }
        return ingredientes;
    }

    public ArrayList<Ingrediente> pesquisarOffset(String sql, ArrayList<Parametro> parametros, int offset) {
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            for (Parametro parametro : parametros) {
                switch (parametro.getNome()) {
                    case "unidadeMedida":
                        ps.setInt(parametro.getPosicao(), Integer.parseInt(parametro.getValor()));
                        break;
                    case "limit":
                        ps.setInt(parametro.getPosicao(), Integer.parseInt(parametro.getValor()));
                        break;
                    default:
                        ps.setString(parametro.getPosicao(), parametro.getValor());
                        break;
                }
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Ingrediente ingrediente = new Ingrediente();
                UnidadeMedida unidadeMedida = new UnidadeMedida();

                unidadeMedida.setId(rs.getInt("unidadeMedida"));
                unidadeMedida.setNome(rs.getString("nomeUnidade"));
                unidadeMedida.setSigla(rs.getString("siglaUnidade"));

                ingrediente.setId(rs.getInt("id"));
                ingrediente.setUnidadeMedida(unidadeMedida);
                ingredientes.add(ingrediente);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro pesquisarOffset(" + sql + ", " + offset + ") IngredienteDao. SQLException: ", ex);
            System.out.println("Erro pesquisarOffset(" + sql + ", " + offset + ") IngredienteDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro pesquisarOffset(" + sql + ", " + offset + ") IngredienteDao. NullPointerException: ", ex);
            System.out.println("Erro pesquisarOffset(" + sql + ", " + offset + ") IngredienteDao: " + ex.getMessage());
        }
        return ingredientes;
    }

    public double calcularPaginacao() {
        String sql = "SELECT count(id) as count FROM ingrediente";
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
            this.logger.logSevere("Erro calcularPaginacao IngredienteDao. SQLException: ", ex);
            System.out.println("Erro ingredienteDao calcularPaginacao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro calcularPaginacao IngredienteDao. NullPointerException: ", ex);
            System.out.println("Erro ingredienteDao calcularPaginacao: " + ex.getMessage());
        }
        return result;
    }

    public double calcularPaginacaoPesquisaLivre(String sql, ArrayList<Parametro> parametros) {
        int count = -1;
        double result = 1;
        try {
            ps = con.prepareStatement(sql);
            for (Parametro parametro : parametros) {
                switch (parametro.getNome()) {
                    case "unidadeMedida":
                        ps.setInt(parametro.getPosicao(), Integer.parseInt(parametro.getValor()));
                        break;
                    case "limit":
                        ps.setInt(parametro.getPosicao(), Integer.parseInt(parametro.getValor()));
                        break;
                    default:
                        System.out.println("Parametro: " + parametro.getValor());
                        ps.setString(parametro.getPosicao(), parametro.getValor());
                        break;
                }
            }
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
            this.logger.logSevere("Erro calcularPaginacaoPesquisaLivre(" + sql + ") IngredienteDao. SQLException: ", ex);
            System.out.println("Erro ingredienteDao calcularPaginacaoPesquisaLivre(" + sql + "): " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro calcularPaginacaoPesquisaLivre(" + sql + ") IngredienteDao. NullPointerException: ", ex);
            System.out.println("Erro ingredienteDao calcularPaginacaoPesquisaLivre(" + sql + "): " + ex.getMessage());
        }
        return result;
    }
}
