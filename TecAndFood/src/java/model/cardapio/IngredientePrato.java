package model.cardapio;

import model.estoque.Ingrediente;

public class IngredientePrato {
    private int id;
    private Ingrediente ingrediente;
    private Prato prato;
    private Float quantidade;

    public int getId() {
        return id;
    }
    public Ingrediente getIngrediente() {
        return ingrediente;
    }
    public Prato getPrato() {
        return prato;
    }
    public Float getQuantidade() {
        return quantidade;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }
    public void setPrato(Prato prato) {
        this.prato = prato;
    }
    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }
}
