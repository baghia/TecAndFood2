package model.util;
public class Tipo {
    private int id;
    private String nome;
    private String descricao;
    private int codDescricao;

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public int getCodDescricao() {
        return codDescricao;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setCodDescricao(int codDescricao) {
        this.codDescricao = codDescricao;
    }
}
