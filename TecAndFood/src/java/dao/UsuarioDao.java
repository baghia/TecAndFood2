package dao;

import dao.util.Conexao;
import dao.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.util.LoggerTec;
import model.util.Tipo;
import model.Usuario;

public class UsuarioDao {
    private Conexao conexao = null;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs;
    private LoggerTec logger;    

    public UsuarioDao(Conexao conexao, LoggerTec logger) {
        this.conexao = conexao;
        this.con = conexao.getConexao();
        this.logger = logger;
    }
    
    
    public Connection getCon(){
        return this.con;
    }
    public void setCon(Connection con) {
        this.con = con;
    }
    /* *** INSERTS ** */
    public int inserir(Usuario usuario){
        String sql = "INSERT INTO usuario VALUES(default, ?, ?, ?, ?, true)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getUsername());
            ps.setString(3, usuario.getSenha());
            ps.setInt(4, usuario.getTipo().getId());
            ps.execute();
            rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            return id;
        } catch (SQLException ex) {
            //this.logger.logSevere("Erro inserir UsuarioDao. SQLException: ", ex);
            System.out.println("Erro inserir UsuarioDao: " + ex.getMessage());
            return -1;
        } catch (NullPointerException ex) {
            //this.logger.logSevere("Erro inserir UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro inserir UsuarioDao: " + ex.getMessage());
            return -1;
        }
    }    
    /* *** UPDATES ** */
    public boolean alterarNome(String valor, int id){
        String sql = "UPDATE usuario SET nome=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarNome("+ valor + ", " + id +") UsuarioDao. SQLException: ", ex);
            System.out.println("Erro alterarNome("+ valor + ", " + id +") UsuarioDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarNome("+ valor + ", " + id +") UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro alterarNome("+ valor + ", " + id +") UsuarioDao: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean alterarUsername(String valor, int id){
        String sql = "UPDATE usuario SET username=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarUsername("+ valor + ", " + id +") UsuarioDao. SQLException: ", ex);
            System.out.println("Erro alterarUsername("+ valor + ", " + id +") UsuarioDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarUsername("+ valor + ", " + id +") UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro alterarUsername("+ valor + ", " + id +") UsuarioDao: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean alterarSenha(String valor, int id){
        String sql = "UPDATE usuario SET senha=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarSenha("+ valor + ", " + id +") UsuarioDao. SQLException: ", ex);
            System.out.println("Erro alterarSenha("+ valor + ", " + id +") UsuarioDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarSenha("+ valor + ", " + id +") UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro alterarSenha("+ valor + ", " + id +") UsuarioDao: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean alterarTipo(int valor, int id){
        String sql = "UPDATE usuario SET senha=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro alterarTipo("+ valor + ", " + id +") UsuarioDao. SQLException: ", ex);
            System.out.println("Erro alterarTipo("+ valor + ", " + id +") UsuarioDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro alterarTipo("+ valor + ", " + id +") UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro alterarTipo("+ valor + ", " + id +") UsuarioDao: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean desativar(int id){
        String sql = "UPDATE usuario SET ativo=false WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro desativar("+ id +") UsuarioDao. SQLException: ", ex);
            System.out.println("Erro desativar("+ id +") UsuarioDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro desativar("+ id +") UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro desativar("+ id +") UsuarioDao: " + ex.getMessage());
            return false;
        }
    }
    public boolean ativar(int id){
        String sql = "UPDATE usuario SET ativo=true WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            this.logger.logSevere("Erro ativar("+ id +") UsuarioDao. SQLException: ", ex);
            System.out.println("Erro ativar("+ id +") UsuarioDao: " + ex.getMessage());
            return false;
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro ativar("+ id +") UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro ativar("+ id +") UsuarioDao: " + ex.getMessage());
            return false;
        }
    }
    /* *** SELECTS ** */
    public Usuario login( Usuario user) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario where username=? AND senha=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getSenha());
            rs = ps.executeQuery();
            while(rs.next()){
                usuario = new Usuario();
                Tipo tipo = new Tipo();
                
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setUsername(rs.getString("username"));
                usuario.setSenha(rs.getString("senha"));
                tipo.setId(rs.getInt("tipo"));
                usuario.setTipo(tipo);
                usuario.setAtivo(rs.getBoolean("ativo"));
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro login UsuarioDao. SQLException: ", ex);
            System.out.println("Erro login UsuarioDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro login UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro login UsuarioDao: " + ex.getMessage());
        }
        return usuario;
    }
    
    public Usuario consultar( int id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){    //move o curusuario de registros
                usuario = new Usuario();
                Tipo tipo = new Tipo();
                
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setUsername(rs.getString("username"));
                usuario.setSenha(rs.getString("senha"));
                tipo.setId(rs.getInt("tipo"));
                usuario.setTipo(tipo);
                usuario.setAtivo(rs.getBoolean("ativo"));
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro consultar("+ id +") UsuarioDao. SQLException: ", ex);
            System.out.println("Erro consultar("+ id +") UsuarioDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro consultar("+ id +") UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro consultar("+ id +") UsuarioDao: " + ex.getMessage());
        }
        return usuario;
    }
    
    public ArrayList<Usuario> listarTipo(int id) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario where tipo=?";        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){    //move o curusuario de registros
                Usuario usuario = new Usuario();
                Tipo tipo = new Tipo();
                
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setUsername(rs.getString("username"));
                usuario.setSenha(rs.getString("senha"));
                tipo.setId(rs.getInt("tipo"));
                usuario.setTipo(tipo);
                usuario.setAtivo(rs.getBoolean("ativo"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro listarTipo("+ id +") UsuarioDao. SQLException: ", ex);
            System.out.println("Erro listarTipo("+ id +") UsuarioDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro listarTipo("+ id +") UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro listarTipo("+ id +") UsuarioDao: " + ex.getMessage());
        }
        return usuarios;
    }
    
    public ArrayList<Usuario> listarAtivosAdmin() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT usuario.*, tipo.nome as nomeTipo FROM usuario join tipo on (usuario.tipo = tipo.id) where usuario.ativo=true order by usuario.nome asc";        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){    //move o curusuario de registros
                Usuario usuario = new Usuario();
                Tipo tipo = new Tipo();
                tipo.setId(rs.getInt("tipo"));
                tipo.setNome(rs.getString("nomeTipo"));
                
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setUsername(rs.getString("username"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(tipo);
                usuario.setAtivo(rs.getBoolean("ativo"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro listarAtivosAdmin UsuarioDao. SQLException: ", ex);
            System.out.println("Erro listarAtivosAdmin UsuarioDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro listarAtivosAdmin UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro listarAtivosAdmin UsuarioDao: " + ex.getMessage());
        }
        return usuarios;
    }
    public ArrayList<Usuario> listarAtivosAdmin(int offset) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT usuario.*, tipo.nome as nomeTipo FROM usuario join tipo on (usuario.tipo = tipo.id) where usuario.ativo=true order by usuario.nome asc limit 10 offset ?";        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, offset);
            rs = ps.executeQuery();
            while(rs.next()){    //move o curusuario de registros
                Usuario usuario = new Usuario();
                Tipo tipo = new Tipo();
                tipo.setId(rs.getInt("tipo"));
                tipo.setNome(rs.getString("nomeTipo"));
                
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setUsername(rs.getString("username"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(tipo);
                usuario.setAtivo(rs.getBoolean("ativo"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro listarAtivosAdmin("+ offset +") UsuarioDao. SQLException: ", ex);
            System.out.println("Erro listarAtivosAdmin("+ offset +") UsuarioDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro listarAtivosAdmin("+ offset +") UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro listarAtivosAdmin("+ offset +") UsuarioDao: " + ex.getMessage());
        }
        return usuarios;
    }
    
    public ArrayList<Usuario> listarInativosAdmin() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT usuario.*, tipo.nome as nomeTipo FROM usuario join tipo on (usuario.tipo = tipo.id) where usuario.ativo=false order by usuario.nome asc";        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){    //move o curusuario de registros
                Usuario usuario = new Usuario();
                Tipo tipo = new Tipo();
                tipo.setId(rs.getInt("tipo"));
                tipo.setNome(rs.getString("nomeTipo"));
                
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setUsername(rs.getString("username"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(tipo);
                usuario.setAtivo(rs.getBoolean("ativo"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro listarInativosAdmin UsuarioDao. SQLException: ", ex);
            System.out.println("Erro listarInativosAdmin UsuarioDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro listarInativosAdmin UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro listarInativosAdmin UsuarioDao: " + ex.getMessage());
        }
        return usuarios;
    }
    public ArrayList<Usuario> listarInativosAdmin(int offset) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT usuario.*, tipo.nome as nomeTipo FROM usuario join tipo on (usuario.tipo = tipo.id) where usuario.ativo=false order by usuario.nome asc limit 10 offset ?";        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, offset);
            rs = ps.executeQuery();
            while(rs.next()){    //move o curusuario de registros
                Usuario usuario = new Usuario();
                Tipo tipo = new Tipo();
                tipo.setId(rs.getInt("tipo"));
                tipo.setNome(rs.getString("nomeTipo"));
                
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setUsername(rs.getString("username"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(tipo);
                usuario.setAtivo(rs.getBoolean("ativo"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro listarInativosAdmin("+ offset +") UsuarioDao. SQLException: ", ex);
            System.out.println("Erro listarInativosAdmin("+ offset +") UsuarioDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro listarInativosAdmin("+ offset +") UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro listarInativosAdmin("+ offset +") UsuarioDao: " + ex.getMessage());
        }
        return usuarios;
    }
    
    public ArrayList<Usuario> listarAtivosControle() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT usuario.*, tipo.nome as nomeTipo FROM usuario join tipo on (usuario.tipo = tipo.id) where usuario.ativo=true and usuario.tipo != 1 order by usuario.nome asc";        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){    //move o curusuario de registros
                Usuario usuario = new Usuario();
                Tipo tipo = new Tipo();
                tipo.setId(rs.getInt("tipo"));
                tipo.setNome(rs.getString("nomeTipo"));
                
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setUsername(rs.getString("username"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(tipo);
                usuario.setAtivo(rs.getBoolean("ativo"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro listarAtivosControle UsuarioDao. SQLException: ", ex);
            System.out.println("Erro listarAtivosControle UsuarioDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro listarAtivosControle UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro listarAtivosControle UsuarioDao: " + ex.getMessage());
        }
        return usuarios;
    }
    public ArrayList<Usuario> listarAtivosControle(int offset) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT usuario.*, tipo.nome as nomeTipo FROM usuario join tipo on (usuario.tipo = tipo.id) where usuario.ativo=true and usuario.tipo != 1 order by usuario.nome asc limit 10 offset ?";        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, offset);
            rs = ps.executeQuery();
            while(rs.next()){    //move o curusuario de registros
                Usuario usuario = new Usuario();
                Tipo tipo = new Tipo();
                tipo.setId(rs.getInt("tipo"));
                tipo.setNome(rs.getString("nomeTipo"));
                
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setUsername(rs.getString("username"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(tipo);
                usuario.setAtivo(rs.getBoolean("ativo"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro listarAtivosControle("+ offset +") UsuarioDao. SQLException: ", ex);
            System.out.println("Erro listarAtivosControle("+ offset +") UsuarioDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro listarAtivosControle("+ offset +") UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro listarAtivosControle("+ offset +") UsuarioDao: " + ex.getMessage());
        }
        return usuarios;
    }
    
    public ArrayList<Usuario> listarInativosControle() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT usuario.*, tipo.nome as nomeTipo FROM usuario join tipo on (usuario.tipo = tipo.id) where usuario.ativo=false and usuario.tipo != 1 order by usuario.nome asc";        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){    //move o curusuario de registros
                Usuario usuario = new Usuario();
                Tipo tipo = new Tipo();
                tipo.setId(rs.getInt("tipo"));
                tipo.setNome(rs.getString("nomeTipo"));
                
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setUsername(rs.getString("username"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(tipo);
                usuario.setAtivo(rs.getBoolean("ativo"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro listarInativosControle UsuarioDao. SQLException: ", ex);
            System.out.println("Erro listarInativosControle UsuarioDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro listarInativosControle UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro listarInativosControle UsuarioDao: " + ex.getMessage());
        }
        return usuarios;
    }
    public ArrayList<Usuario> listarInativosControle(int offset) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT usuario.*, tipo.nome as nomeTipo FROM usuario join tipo on (usuario.tipo = tipo.id) where usuario.ativo=false and usuario.tipo != 1 order by usuario.nome asc limit 10 offset ?";        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, offset);
            rs = ps.executeQuery();
            while(rs.next()){    //move o curusuario de registros
                Usuario usuario = new Usuario();
                Tipo tipo = new Tipo();
                tipo.setId(rs.getInt("tipo"));
                tipo.setNome(rs.getString("nomeTipo"));
                
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setUsername(rs.getString("username"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(tipo);
                usuario.setAtivo(rs.getBoolean("ativo"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro listarInativosControle("+ offset +") UsuarioDao. SQLException: ", ex);
            System.out.println("Erro listarInativosControle("+ offset +") UsuarioDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro listarInativosControle("+ offset +") UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro listarInativosControle("+ offset +") UsuarioDao: " + ex.getMessage());
        }
        return usuarios;
    }
    
    public double calcularPaginacaoAdminAtivos() {
        String sql = "SELECT count(id) as count FROM usuario WHERE ativo=true";
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
            this.logger.logSevere("Erro calcularPaginacaoAdminAtivos UsuarioDao. SQLException: ", ex);
            System.out.println("Erro calcularPaginacaoAdminAtivos UsuarioDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro calcularPaginacaoAdminAtivos UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro calcularPaginacaoAdminAtivos UsuarioDao: " + ex.getMessage());
        }
        return result;
    }
    public double calcularPaginacaoAdminInativos() {
        String sql = "SELECT count(id) as count FROM usuario WHERE ativo=false";
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
            this.logger.logSevere("Erro calcularPaginacaoAdminInativos UsuarioDao. SQLException: ", ex);
            System.out.println("Erro calcularPaginacaoAdminInativos UsuarioDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro calcularPaginacaoAdminInativos UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro calcularPaginacaoAdminInativos UsuarioDao: " + ex.getMessage());
        }
        return result;
    }
    
    public double calcularPaginacaoControleAtivos() {
        String sql = "SELECT count(id) as count FROM usuario WHERE tipo!=1 and ativo=true";
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
            this.logger.logSevere("Erro calcularPaginacaoControleAtivos UsuarioDao. SQLException: ", ex);
            System.out.println("Erro calcularPaginacaoControleAtivos UsuarioDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro calcularPaginacaoControleAtivos UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro calcularPaginacaoControleAtivos UsuarioDao: " + ex.getMessage());
        }
        return result;
    }
    public double calcularPaginacaoControleInativos() {
        String sql = "SELECT count(id) as count FROM usuario WHERE tipo!=1 and ativo=false";
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
            this.logger.logSevere("Erro calcularPaginacaoControleInativos UsuarioDao. SQLException: ", ex);
            System.out.println("Erro calcularPaginacaoControleInativos UsuarioDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro calcularPaginacaoControleInativos UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro calcularPaginacaoControleInativos UsuarioDao: " + ex.getMessage());
        }
        return result;
    }
    
    public ArrayList<Usuario> pesquisarNomeAdministrador(String chave) {
        String sql = "SELECT DISTINCT usuario.*, tipo.nome as nomeTipo "
                + "FROM tipo join usuario on (tipo.id = usuario.tipo) "
                + "WHERE (lower(usuario.nome) like '%" + chave + "%') or (lower(usuario.username) like '%" + chave + "%') ORDER BY usuario.nome ASC";
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                Tipo tipo = new Tipo();

                tipo.setId(rs.getInt("tipo"));
                tipo.setNome(rs.getString("nomeTipo"));
                
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setUsername(rs.getString("username"));
                usuario.setTipo(tipo);
                usuario.setAtivo(rs.getBoolean("ativo"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro pesquisarNome(" + chave + ") UsuarioDao. SQLException: ", ex);
            System.out.println("Erro pesquisarNome(" + chave + ") UsuarioDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro pesquisarNome(" + chave + ") UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro pesquisarNome(" + chave + ") UsuarioDao: " + ex.getMessage());
        }
        return usuarios;
    }
    public ArrayList<Usuario> pesquisarNomeControle(String chave) {
        String sql = "SELECT DISTINCT usuario.*, tipo.nome as nomeTipo "
                + "FROM tipo join usuario on (tipo.id = usuario.tipo) "
                + "WHERE ( (lower(usuario.nome) like '%" + chave + "%') or (lower(usuario.username) like '%" + chave + "%') ) and usuario.tipo > 1 ORDER BY usuario.nome ASC";
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                Tipo tipo = new Tipo();

                tipo.setId(rs.getInt("tipo"));
                tipo.setNome(rs.getString("nomeTipo"));
                
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setUsername(rs.getString("username"));
                usuario.setTipo(tipo);
                usuario.setAtivo(rs.getBoolean("ativo"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro pesquisarNome(" + chave + ") UsuarioDao. SQLException: ", ex);
            System.out.println("Erro pesquisarNome(" + chave + ") UsuarioDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro pesquisarNome(" + chave + ") UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro pesquisarNome(" + chave + ") UsuarioDao: " + ex.getMessage());
        }
        return usuarios;
    }
    
    public int verificaUsername(String chave) {
        String sql = "SELECT id FROM usuario WHERE username=?";
        int id = -1;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, chave);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            this.logger.logSevere("Erro verificaUsername(" + chave + ") UsuarioDao. SQLException: ", ex);
            System.out.println("Erro verificaUsername(" + chave + ") UsuarioDao: " + ex.getMessage());
        } catch (NullPointerException ex) {
            this.logger.logSevere("Erro verificaUsername(" + chave + ") UsuarioDao. NullPointerException: ", ex);
            System.out.println("Erro verificaUsername(" + chave + ") UsuarioDao: " + ex.getMessage());
        }
        return id;
    }
}
