package model.cardapio;

import java.util.ArrayList;

public class Prato {
    private int id;
    private String nome;
    private ArrayList<IngredientePrato> ingredientes;

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public ArrayList<IngredientePrato> getIngredientes() {
        return ingredientes;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setIngredientes(ArrayList<IngredientePrato> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
