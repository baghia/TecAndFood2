package model;

import model.util.Tipo;

public class Usuario {
    private int id;
    private String nome;
    private String username;
    private String senha;
    private Tipo tipo;
    private boolean ativo;

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getUsername() {
        return username;
    }
    public String getSenha() {
        return senha;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public boolean getAtivo() {
        return ativo;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
