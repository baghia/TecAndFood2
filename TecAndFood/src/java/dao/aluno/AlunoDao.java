package dao.aluno;

import dao.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.aluno.Aluno;
import model.aluno.Endereco;
import model.aluno.Estado;
import model.util.LoggerTec;
import model.util.Parametro;

public class AlunoDao {
    private Conexao conexao = null;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs;
    private LoggerTec logger;

    public AlunoDao(Conexao conexao, LoggerTec logger) {
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

    public int inserir(Aluno aluno) {
        String sql = "INSERT INTO aluno VALUES(default, ?, ?, ?, ?, ?, true, ?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, aluno.getRg());
            ps.setString(2, aluno.getCpf());
            ps.setString(3, aluno.getMatricula());
            ps.setInt(4, aluno.getEndereco().getId());
            ps.setDate(5, aluno.getDataSql());
            ps.setString(6, aluno.getNome());
            ps.execute();
            rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            return id;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro inserir AlunoDao. SQLException: ", ex);
            System.out.println("Erro inserir AlunoDao: " + ex.getMessage());
            return -1;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro inserir AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro inserir AlunoDao: " + ex.getMessage());
            return -1;
        }
    }
   
    /* ** UPDATES ** */

    public boolean alterarNome(String valor, int id) {
        String sql = "UPDATE aluno SET nome=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarNome(" + valor + ", " + id + ") AlunoDao. SQLException: ", ex);
            System.out.println("Erro alterarNome(" + valor + ", " + id + ") AlunoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarNome(" + valor + ", " + id + ") AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro alterarNome(" + valor + ", " + id + ") AlunoDao: " + ex.getMessage());
            return false;
        }
    }

    public boolean alterarCPF(String valor, int id) {
        String sql = "UPDATE aluno SET cpf=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarCPF(" + valor + ", " + id + ") AlunoDao. SQLException: ", ex);
            System.out.println("Erro alterarCPF(" + valor + ", " + id + ") AlunoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarCPF(" + valor + ", " + id + ") AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro alterarCPF(" + valor + ", " + id + ") AlunoDao: " + ex.getMessage());
            return false;
        }
    }

    public boolean alterarRG(String valor, int id) {
        String sql = "UPDATE aluno SET rg=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarRG(" + valor + ", " + id + ") AlunoDao. SQLException: ", ex);
            System.out.println("Erro alterarRG(" + valor + ", " + id + ") AlunoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarRG(" + valor + ", " + id + ") AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro alterarRG(" + valor + ", " + id + ") AlunoDao: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean alterarMatricula(String valor, int id) {
        String sql = "UPDATE aluno SET matricula=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarMatricula(" + valor + ", " + id + ") AlunoDao. SQLException: ", ex);
            System.out.println("Erro alterarMatricula(" + valor + ", " + id + ") AlunoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarMatricula(" + valor + ", " + id + ") AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro alterarMatricula(" + valor + ", " + id + ") AlunoDao: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean alterarEndereco(int valor, int id) {
        String sql = "UPDATE aluno SET endereco=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarEndereco(" + valor + ", " + id + ") AlunoDao. SQLException: ", ex);
            System.out.println("Erro alterarEndereco(" + valor + ", " + id + ") AlunoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarEndereco(" + valor + ", " + id + ") AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro alterarEndereco(" + valor + ", " + id + ") AlunoDao: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean alterarDataNascimento(java.sql.Date data, int id) {
        String sql = "UPDATE aluno SET dataNascimento=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setDate(1, data);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarDataNascimento(" + data + ", " + id + ") AlunoDao. SQLException: ", ex);
            System.out.println("Erro alterarDataNascimento(" + data + ", " + id + ") AlunoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarDataNascimento(" + data + ", " + id + ") AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro alterarDataNascimento(" + data + ", " + id + ") AlunoDao: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean desativar(int id) {
        String sql = "UPDATE aluno SET ativo=false WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro desativar AlunoDao. SQLException: ", ex);
            System.out.println("Erro desativar AlunoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro desativar AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro desativar AlunoDao: " + ex.getMessage());
            return false;
        }
    }

    public boolean ativar(int id) {
        String sql = "UPDATE aluno SET ativo=true WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro ativar AlunoDao. SQLException: ", ex);
            System.out.println("Erro ativar AlunoDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro ativar AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro ativar AlunoDao: " + ex.getMessage());
            return false;
        }
    }
    /* * SELECTS **/

    public ArrayList<Aluno> listarAtivos() {
        String sql = "SELECT DISTINCT aluno.*, endereco.rua, endereco.bairro, endereco.num, endereco.cidade, estado.sigla as sigla, endereco.cep as cep "
                + "FROM aluno join endereco on (aluno.endereco = endereco.id) join estado on (endereco.estado = estado.id) WHERE aluno.status=true ORDER BY aluno.nome ASC";
        ArrayList<Aluno> alunos = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                Estado estado = new Estado();
                Endereco endereco = new Endereco();

                estado.setId(rs.getInt("estado"));
                estado.setSigla(rs.getString("sigla"));

                endereco.setId(rs.getInt("endereco"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setId(rs.getInt("num"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(estado);
                
                aluno.setId(rs.getInt("id"));
                aluno.setStatus(rs.getBoolean("status"));
                aluno.setNome(rs.getString("nome"));
                aluno.setRg(rs.getString("rg"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setMatricula(rs.getString("matricula"));
                aluno.setDataSql(rs.getDate("dataNascimento"));
                aluno.setEndereco(endereco);
                alunos.add(aluno);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro listarAtivos AlunoDao. SQLException: ", ex);
            System.out.println("Erro listarAtivos AlunoDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro listarAtivos AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro listarAtivos AlunoDao: " + ex.getMessage());
        }
        return alunos;
    }

    public ArrayList<Aluno> listarAtivos(int offset) {
        String sql = "SELECT DISTINCT aluno.*, endereco.rua, endereco.bairro, endereco.num, endereco.cidade, estado.sigla as sigla, endereco.cep as cep "
                + "FROM aluno join endereco on (aluno.endereco = endereco.id) join estado on (endereco.estado = estado.id) WHERE aluno.status=true ORDER BY aluno.nome ASC limit 10 offset ?";
        ArrayList<Aluno> alunos = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, offset);
            rs = ps.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                Estado estado = new Estado();
                Endereco endereco = new Endereco();

                estado.setId(rs.getInt("estado"));
                estado.setSigla(rs.getString("sigla"));

                endereco.setId(rs.getInt("endereco"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setId(rs.getInt("num"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(estado);
                
                aluno.setId(rs.getInt("id"));
                aluno.setStatus(rs.getBoolean("status"));
                aluno.setNome(rs.getString("nome"));
                aluno.setRg(rs.getString("rg"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setMatricula(rs.getString("matricula"));
                aluno.setDataSql(rs.getDate("dataNascimento"));
                aluno.setEndereco(endereco);
                alunos.add(aluno);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro listarAtivos(" + offset + ") AlunoDao. SQLException: ", ex);
            System.out.println("Erro listarAtivos(" + offset + ") AlunoDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro listarAtivos(" + offset + ") AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro listarAtivos(" + offset + ") AlunoDao: " + ex.getMessage());
        }
        return alunos;
    }
    public ArrayList<Aluno> listarInativos() {
        String sql = "SELECT DISTINCT aluno.*, endereco.rua, endereco.bairro, endereco.num, endereco.cidade, estado.sigla as sigla, endereco.cep as cep "
                + "FROM aluno join endereco on (aluno.endereco = endereco.id) join estado on (endereco.estado = estado.id) WHERE aluno.status=false ORDER BY aluno.nome ASC";
        ArrayList<Aluno> alunos = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                Estado estado = new Estado();
                Endereco endereco = new Endereco();

                estado.setId(rs.getInt("estado"));
                estado.setSigla(rs.getString("sigla"));

                endereco.setId(rs.getInt("endereco"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setId(rs.getInt("num"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(estado);
                
                aluno.setId(rs.getInt("id"));
                aluno.setStatus(rs.getBoolean("status"));
                aluno.setNome(rs.getString("nome"));
                aluno.setRg(rs.getString("rg"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setMatricula(rs.getString("matricula"));
                aluno.setDataSql(rs.getDate("dataNascimento"));
                aluno.setEndereco(endereco);
                alunos.add(aluno);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro listarInativos AlunoDao. SQLException: ", ex);
            System.out.println("Erro listarInativos AlunoDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro listarInativos AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro listarInativos AlunoDao: " + ex.getMessage());
        }
        return alunos;
    }

    public ArrayList<Aluno> listarInativos(int offset) {
        String sql = "SELECT DISTINCT aluno.*, endereco.rua, endereco.bairro, endereco.num, endereco.cidade, estado.sigla as sigla, endereco.cep as cep "
                + "FROM aluno join endereco on (aluno.endereco = endereco.id) join estado on (endereco.estado = estado.id) WHERE aluno.status=false ORDER BY aluno.nome ASC limit 10 offset ?";
        ArrayList<Aluno> alunos = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, offset);
            rs = ps.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                Estado estado = new Estado();
                Endereco endereco = new Endereco();

                estado.setId(rs.getInt("estado"));
                estado.setSigla(rs.getString("sigla"));

                endereco.setId(rs.getInt("endereco"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setId(rs.getInt("num"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(estado);
                
                aluno.setId(rs.getInt("id"));
                aluno.setStatus(rs.getBoolean("status"));
                aluno.setNome(rs.getString("nome"));
                aluno.setRg(rs.getString("rg"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setMatricula(rs.getString("matricula"));
                aluno.setDataSql(rs.getDate("dataNascimento"));
                aluno.setEndereco(endereco);
                alunos.add(aluno);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro listarInativos(" + offset + ") AlunoDao. SQLException: ", ex);
            System.out.println("Erro alunoDao listar inativos: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro listarInativos(" + offset + ") AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro alunoDao listar inativos: " + ex.getMessage());
        }
        return alunos;
    }

    public Aluno consultar(int id) {
        String sql = "SELECT aluno.*, endereco.rua, endereco.bairro, endereco.num, endereco.cidade, estado.sigla as sigla, endereco.cep as cep "
                + "FROM aluno join endereco on (aluno.endereco = endereco.id) join estado on (endereco.estado = estado.id) WHERE  aluno.id=?";
        Aluno aluno = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                aluno = new Aluno();
                Estado estado = new Estado();
                Endereco endereco = new Endereco();

                estado.setId(rs.getInt("estado"));
                estado.setSigla(rs.getString("sigla"));

                endereco.setId(rs.getInt("endereco"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setId(rs.getInt("num"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(estado);
                
                aluno.setId(rs.getInt("id"));
                aluno.setStatus(rs.getBoolean("status"));
                aluno.setNome(rs.getString("nome"));
                aluno.setRg(rs.getString("rg"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setMatricula(rs.getString("matricula"));
                aluno.setDataSql(rs.getDate("dataNascimento"));
                aluno.setEndereco(endereco);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro consultar(" + id + ") AlunoDao. SQLException: ", ex);
            System.out.println("Erro consultar(" + id + ") AlunoDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro consultar(" + id + ") AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro consultar(" + id + ") AlunoDao: " + ex.getMessage());
        }
        return aluno;
    }
    
    public ArrayList<Aluno> pesquisar(String sql, ArrayList<Parametro> parametros) {
        ArrayList<Aluno> alunos = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            for(Parametro parametro : parametros){
                switch(parametro.getNome()){
                    case "endereco":
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
                Aluno aluno = new Aluno();
                Estado estado = new Estado();
                Endereco endereco = new Endereco();

                estado.setId(rs.getInt("estado"));
                estado.setSigla(rs.getString("sigla"));

                endereco.setId(rs.getInt("endereco"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setId(rs.getInt("num"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(estado);
                
                aluno.setId(rs.getInt("id"));
                aluno.setStatus(rs.getBoolean("status"));
                aluno.setNome(rs.getString("nome"));
                aluno.setRg(rs.getString("rg"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setMatricula(rs.getString("matricula"));
                aluno.setDataSql(rs.getDate("dataNascimento"));
                aluno.setEndereco(endereco);
                alunos.add(aluno);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro pesquisar(" + sql + ") AlunoDao. SQLException: ", ex);
            System.out.println("Erro pesquisar(" + sql + ") AlunoDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro pesquisar(" + sql + ") AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro pesquisar(" + sql + ") AlunoDao: " + ex.getMessage());
        }
        return alunos;
    }
    
    public ArrayList<Aluno> pesquisarOffset(String sql, ArrayList<Parametro> parametros, int offset) {
        ArrayList<Aluno> alunos = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            for(Parametro parametro : parametros){
                switch(parametro.getNome()){
                    case "endereco":
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
                Aluno aluno = new Aluno();
                Estado estado = new Estado();
                Endereco endereco = new Endereco();

                estado.setId(rs.getInt("estado"));
                estado.setSigla(rs.getString("sigla"));

                endereco.setId(rs.getInt("endereco"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setId(rs.getInt("num"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(estado);
                
                aluno.setId(rs.getInt("id"));
                aluno.setStatus(rs.getBoolean("status"));
                aluno.setNome(rs.getString("nome"));
                aluno.setRg(rs.getString("rg"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setMatricula(rs.getString("matricula"));
                aluno.setDataSql(rs.getDate("dataNascimento"));
                aluno.setEndereco(endereco);
                alunos.add(aluno);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro pesquisarOffset(" + sql + ", " + offset + ") AlunoDao. SQLException: ", ex);
            System.out.println("Erro pesquisarOffset(" + sql + ", " + offset + ") AlunoDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro pesquisarOffset(" + sql + ", " + offset + ") AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro pesquisarOffset(" + sql + ", " + offset + ") AlunoDao: " + ex.getMessage());
        }
        return alunos;
    }
    public Aluno buscarMatricula(String matricula) {
        String sql = "SELECT id, nome FROM aluno WHERE aluno.matricula=?";
        Aluno aluno = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, matricula);
            rs = ps.executeQuery();
            while (rs.next()) {
                aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro buscarMatricula" + matricula + ") AlunoDao. SQLException: ", ex);
            System.out.println("Erro buscarMatricula" + matricula + ") AlunoDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro buscarMatricula" + matricula + ") AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro buscarMatricula" + matricula + ") AlunoDao: " + ex.getMessage());
        }
        return aluno;
    }

    public double calcularPaginacaoInativos() {
        String sql = "SELECT count(id) as count FROM aluno WHERE ativo=false";
        int count = -1;
        double result = -1;
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
            this.logger.logSevere("Erro calcularPaginacaoInativos AlunoDao. SQLException: ", ex);
            System.out.println("Erro alunoDao calcularPaginacaoInativos: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro calcularPaginacaoInativos AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro alunoDao calcularPaginacaoInativos: " + ex.getMessage());
        }
        return result;
    }    
    public double calcularPaginacaoAtivos() {
        String sql = "SELECT count(id) as count FROM aluno WHERE ativo=true";
        int count = -1;
        double result = -1;
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
            this.logger.logSevere("Erro calcularPaginacaoAtivos AlunoDao. SQLException: ", ex);
            System.out.println("Erro alunoDao calcularPaginacaoAtivos: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro calcularPaginacaoAtivos AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro alunoDao calcularPaginacaoAtivos: " + ex.getMessage());
        }
        return result;
    }
    public double calcularPaginacaoPesquisaLivre(String sql, ArrayList<Parametro> parametros) {
        int count = -1;
        double result = -1;
        try {
            ps = con.prepareStatement(sql);
            for(Parametro parametro : parametros){
                switch(parametro.getNome()){
                    case "endereco":
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
            this.logger.logSevere("Erro calcularPaginacaoPesquisaLivre("+ sql +") AlunoDao. SQLException: ", ex);
            System.out.println("Erro alunoDao calcularPaginacaoPesquisaLivre("+ sql +"): " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro calcularPaginacaoPesquisaLivre("+ sql +") AlunoDao. NullPointerException: ", ex);
            System.out.println("Erro alunoDao calcularPaginacaoPesquisaLivre("+ sql +"): " + ex.getMessage());
        }
        return result;
    }
}
