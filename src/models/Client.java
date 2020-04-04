package models;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String nume;
    private String prenume;
    private List<Produs> produse = new ArrayList<>();

    public Client(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    public Client(String nume, String prenume, List<Produs> produse) {
        this.nume = nume;
        this.prenume = prenume;
        this.produse = produse;
    }

    public List<Produs> getProduse() {
        return produse;
    }

    public void setProduse(List<Produs> produse) {
        this.produse = produse;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
}
