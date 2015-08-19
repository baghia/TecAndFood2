package model.aluno;
public class Endereco {
    private int id;
    private String rua;
    private String bairro;
    private String cidade;
    private Estado estado;
    private int num;
    private String cep;
    
    public int getId() {
        return id;
    }
    public String getRua() {
        return rua;
    }
    public String getBairro() {
        return bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public Estado getEstado() {
        return estado;
    }
    public String getCep() {
        return cep;
    }
    public int getNum() {
        return num;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
}
