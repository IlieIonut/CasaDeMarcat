package models;

public class Plata {
    private double cash;
    private double card;
    private double bonuri_valorice;

    public Plata(double cash, double card, double bonuri_valorice) {
        this.cash = cash;
        this.card = card;
        this.bonuri_valorice = bonuri_valorice;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getCard() {
        return card;
    }

    public void setCard(double card) {
        this.card = card;
    }

    public double getBonuri_valorice() {
        return bonuri_valorice;
    }

    public void setBonuri_valorice(double bonuri_valorice) {
        this.bonuri_valorice = bonuri_valorice;
    }

    @Override
    public String toString() {
        return
                "cash=" + cash +
                ", card=" + card +
                ", bonuri_valorice=" + bonuri_valorice ;
    }
}
