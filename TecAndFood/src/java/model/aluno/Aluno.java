package model.aluno;

import java.util.Date;

public class Aluno {

    private int id;
    private String nome;
    private String rg;
    private String cpf;
    private String matricula;
    private java.util.Date dataNascimento;
    private java.sql.Date dataSql;
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

    public boolean getStatus() {
        return status;
    }

    public java.sql.Date getDataSql() {
        return dataSql;
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
        this.dataSql = new java.sql.Date(dataNascimento.getTime());
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setDataSql(java.sql.Date dataSql) {
        this.dataSql = dataSql;
        this.dataNascimento = new java.util.Date(dataSql.getTime());
    }

    @Override
    public String toString() {
        return "Aluno{" + "id=" + id + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", matricula=" + matricula + ", dataNascimento=" + dataNascimento + ", dataSql=" + dataSql + ", endereco=" + endereco + ", status=" + status + '}';
    }
    
}
