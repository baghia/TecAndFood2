package model.estoque;

import java.util.Date;
import model.aluno.Aluno;
import model.cardapio.IngredientePrato;
import model.cardapio.PratoCardapioDiario;

public class Refeicao {

    private int id;
    private Aluno aluno;
    private PratoCardapioDiario prato;
    private IngredientePrato ingrediente;
    private java.util.Date dataHora;
    private Intervalo intervalo;

    public int getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public PratoCardapioDiario getPrato() {
        return prato;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setPrato(PratoCardapioDiario prato) {
        this.prato = prato;
    }

    public void setIngrediente(IngredientePrato ingrediente) {
        this.ingrediente = ingrediente;
    }

    public IngredientePrato getIngrediente() {
        return ingrediente;
    }

    public Intervalo getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(Intervalo intervalo) {
        this.intervalo = intervalo;
    }
}
