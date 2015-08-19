package model.aluno;

import model.util.Tipo;

public class Responsavel {
    private int id;
    private String nome;
    private Tipo tipo;
    private Aluno aluno;

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public Aluno getAluno() {
        return aluno;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
