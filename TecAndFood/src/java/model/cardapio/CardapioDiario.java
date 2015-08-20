package model.cardapio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CardapioDiario {
    private int id;
    private java.util.Date dia;
    private java.sql.Date diaSql;
    private ArrayList<PratoCardapioDiario> pratos;

    public int getId() {
        return id;
    }
    public Date getDia() {
        return dia;
    }
    public java.sql.Date getDiaSql() {
        return diaSql;
    }
    public ArrayList<PratoCardapioDiario> getPratos() {
        return pratos;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setDia(Date dia) {
        this.dia = dia;
        this.diaSql = new java.sql.Date(dia.getTime());
    }
    public void setDiaSql(java.sql.Date diaSql) {
        this.diaSql = diaSql;
        this.dia = new java.util.Date(diaSql.getTime());
    }
    public void setPratos(ArrayList<PratoCardapioDiario> pratos) {
        this.pratos = pratos;
    }
    
    public String dia() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String format = formato.format(this.dia);
        return format;
    }
}
