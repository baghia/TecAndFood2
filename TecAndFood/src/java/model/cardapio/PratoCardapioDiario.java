package model.cardapio;

import model.util.Tipo;

public class PratoCardapioDiario {
    private int id;
    private Prato prato;
    private CardapioDiario cardapio;
    private Tipo turno;

    public int getId() {
        return id;
    }
    public Prato getPrato() {
        return prato;
    }
    public CardapioDiario getCardapio() {
        return cardapio;
    }
    public Tipo getTurno() {
        return turno;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setPrato(Prato prato) {
        this.prato = prato;
    }
    public void setCardapio(CardapioDiario cardapio) {
        this.cardapio = cardapio;
    }
    public void setTurno(Tipo turno) {
        this.turno = turno;
    }
}
