package model.aluno;

import java.util.Date;

public class Aluno {
    private int id;
    private String nome;
    private String rg;
    private String cpf;
    private String matricula;
    private java.util.Date dataNascimento;
    private Endereco endereco;
    private boolean status;

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getRg() {
        return rg;
    }
    public String getCpf() {
        return cpf;
    }
    public String getMatricula() {
        return matricula;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public boolean isStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
}
