package model.cardapio;

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
    }
    public void setDiaSql(java.sql.Date diaSql) {
        this.diaSql = diaSql;
    }
    public void setPratos(ArrayList<PratoCardapioDiario> pratos) {
        this.pratos = pratos;
    }
}
