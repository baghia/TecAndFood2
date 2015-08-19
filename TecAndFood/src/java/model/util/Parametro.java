package model.util;
public class Parametro {
    private String nome;
    private String valor;
    private Integer posicao;

    public String getNome() {
        return nome;
    }
    public String getValor() {
        return valor;
    }
    public Integer getPosicao() {
        return posicao;
    }
    

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }    
}
