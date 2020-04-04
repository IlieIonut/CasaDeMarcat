package models;


import java.util.ArrayList;
import java.util.List;

public class CasaDeMarcatImplementare implements contracts.CasaDeMarcat {

    private String NumeMagazinCasa;
    private String LocatieMagazin;

    private List<Client> clienti = new ArrayList<>();
    private List<Plata> plati = new ArrayList<>();
    private List<Produs> produse = new ArrayList<>();

    public CasaDeMarcatImplementare(String numeMagazinCasa, String locatieMagazin) {
        NumeMagazinCasa = numeMagazinCasa;
        LocatieMagazin = locatieMagazin;
    }

    public CasaDeMarcatImplementare(String numeMagazinCasa, String locatieMagazin, List<Client> clienti, List<Plata> plata, List<Produs> produs) {
        NumeMagazinCasa = numeMagazinCasa;
        LocatieMagazin = locatieMagazin;
        this.clienti = clienti;
        this.plati = plata;
        this.produse = produs;
    }

    public List<Client> getClienti() {
        return clienti;
    }

    public void setClienti(List<Client> clienti) {
        this.clienti = clienti;
    }

    public List<Plata> getPlata() {
        return plati;
    }

    public void setPlata(List<Plata> plata) {
        this.plati = plata;
    }

    public List<Produs> getProdus() {
        return produse;
    }

    public void setProdus(List<Produs> produs) {
        this.produse = produs;
    }

    public String getNumeMagazinCasa() {
        return NumeMagazinCasa;
    }

    public void setNumeMagazinCasa(String numeMagazinCasa) {
        NumeMagazinCasa = numeMagazinCasa;
    }

    public String getLocatieMagazin() {
        return LocatieMagazin;
    }

    public void setLocatieMagazin(String locatieMagazin) {
        LocatieMagazin = locatieMagazin;
    }

    @Override
    public void adaugaProdus(Produs produs) {
        this.produse.add(produs);
        System.out.println(">>>>>>>>>>>S-a adaugat la produsul: <<<<<<<<<<<<<<");
        System.out.println(produs);

    }

    @Override
    public void stergeProdus(int index) {
        System.out.println("<<<<<<<<<<S-a sters un produs>>>>>>>>>>");
        this.produse.remove(index);

    }

    @Override
    public void editarePretProdus(int index, Produs produs, double pret) {
        produse.get(index).setPretProdus(pret);
        System.out.println("<<<<<<<<<<Produsul " + produs.getNumeProdus() + " are pretul " + produse.get(index).getPretProdus() + ">>>>>>>>>>");
    }

    @Override
    public void afisareClienti() {
        for (int i = 0; i < this.clienti.size(); i++) {
            System.out.println("\n" + this.clienti.get(i).getNume() + " " + this.clienti.get(i).getPrenume());
            for (int j = 0; j < this.clienti.get(i).getProduse().size(); j++) {
                System.out.println("Produsul " + (j + 1));
                System.out.println("Produsul se numeste : " + this.clienti.get(i).getProduse().get(j).getNumeProdus());
                System.out.println("Produsul costa : " + this.clienti.get(i).getProduse().get(j).getPretProdus());
            }
        }
    }

    @Override
    public void afisareProduse() {
        for (int i = 0; i < this.produse.size(); i++) {
            System.out.println("\nProdusul " + (i + 1));
            System.out.println("Produsul se numeste : " + this.produse.get(i).getNumeProdus());
            System.out.println("Produsul costa : " + this.produse.get(i).getPretProdus());
        }
    }
}