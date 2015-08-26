package model.estoque;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Intervalo {

    private int id;
    private java.util.Date dataHora;
    private java.sql.Timestamp dataHoraSql;
    private boolean ativo;
    private int qtdEsperada;

    public int getId() {
        return id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public java.sql.Timestamp getDataHoraSql() {
        return dataHoraSql;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
        this.dataHoraSql = new java.sql.Timestamp(dataHora.getTime());
    }

    public void setDataHoraSql(java.sql.Timestamp dataHoraSql) {
        this.dataHoraSql = dataHoraSql;
        this.dataHora = new java.util.Date(dataHoraSql.getTime());
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String dataHora() {
        
        SimpleDateFormat formato = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy - HH:mm");
        String format = formato.format(this.dataHora);
        return format;
    }

    public int getQtdEsperada() {
        return qtdEsperada;
    }

    public void setQtdEsperada(int qtdEsperada) {
        this.qtdEsperada = qtdEsperada;
    }

}
