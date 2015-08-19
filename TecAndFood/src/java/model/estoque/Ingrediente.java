package model.estoque;
public class Ingrediente {
    private int id;
    private String nome;
    private UnidadeMedida unidadeMedida;

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
}
