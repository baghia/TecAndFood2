package model.aluno;

import model.util.Tipo;

public class Contato {
    private int id;
    private Tipo tipo;
    private Aluno aluno;
    private String valor;

    public int getId() {
        return id;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public Aluno getAluno() {
        return aluno;
    }
    public String getValor() {
        return valor;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
}
