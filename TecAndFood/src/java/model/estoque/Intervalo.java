package model.estoque;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Intervalo {
    private int id;
    private java.util.Date dataHora;
    private java.sql.Date dataHoraSql;
    private boolean ativo;

    public int getId() {
        return id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public java.sql.Date getDataHoraSql() {
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
        this.dataHoraSql = new java.sql.Date(dataHora.getTime());
    }

    public void setDataHoraSql(java.sql.Date dataHoraSql) {
        this.dataHoraSql = dataHoraSql;
        this.dataHora = new java.util.Date(dataHoraSql.getTime());
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public String dataHora() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String format = formato.format(this.dataHora);
        return format;
    }
    
}
