package model.estoque;
public class UnidadeMedida {
    private int id;
    private String nome;
    private String sigla;
    
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getSigla() {
        return sigla;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
