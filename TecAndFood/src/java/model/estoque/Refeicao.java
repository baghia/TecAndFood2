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
    public IngredientePrato getIngrediente() {
        return ingrediente;
    }   
}
