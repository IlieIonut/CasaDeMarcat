package models;


import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;


public class CasaDeMarcatImplementare implements contracts.CasaDeMarcat {

    private String NumeMagazinCasa;
    private String LocatieMagazin;

    private List<Client> Clienti = new ArrayList<>();
    private List<Plata> Plati = new ArrayList<>();
    private List<Produs> Produse = new ArrayList<>();

    public CasaDeMarcatImplementare(String numeMagazinCasa, String locatieMagazin) {
        NumeMagazinCasa = numeMagazinCasa;
        LocatieMagazin = locatieMagazin;
    }

    public CasaDeMarcatImplementare(String numeMagazinCasa, String locatieMagazin, List<Client> clienti, List<Produs> produs) {
        NumeMagazinCasa = numeMagazinCasa;
        LocatieMagazin = locatieMagazin;
        Clienti = clienti;
        Produse = produs;
    }

    public List<Client> getClienti() {
        return Clienti;
    }

    public void setClienti(List<Client> clienti) {
        this.Clienti = clienti;
    }

    public List<Plata> getPlata() {
        return Plati;
    }

    public void setPlata(List<Plata> plata) {
        this.Plati = plata;
    }

    public List<Produs> getProdus() {
        return Produse;
    }

    public void setProdus(List<Produs> produs) {
        this.Produse = produs;
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
        this.Produse.add(produs);
        System.out.println(">>>>>>>>>>>S-a adaugat produsul: " + produs.getNumeProdus() + "<<<<<<<<<<<<<<");
    }

    @Override
    public void stergeProdus(int index) {
        if (Produse.size() == 0)
            System.out.println("Magazinul nu are niciun produs => nu aveti ce sterge :)");
        else {
            if (index + 1 > Produse.size()) {
                System.out.println("Produsul cu indexul " + index + " nu exista");
            } else {
                System.out.println("<<<<<<<<<<S-a sters produsul: " + Produse.get(index).getNumeProdus() + ">>>>>>>>>>");
                this.Produse.remove(index);
            }
        }
    }

    @Override
    public void editarePretProdus(int index, double pret) {
        if (index + 1 > Produse.size()) {
            System.out.println("Produsul cu indexul " + index + " nu exista");
        } else {
            System.out.println("Vechiul pret era: " + Produse.get(index).getPretProdus());
            Produse.get(index).setPretProdus(pret);
            System.out.println("<<<<<<<<<<Produsul " + Produse.get(index).getNumeProdus() + " are pretul " + Produse.get(index).getPretProdus() + ">>>>>>>>>>");
        }
    }

    @Override
    public void afisareClienti() {
        for (int i = 0; i < this.Clienti.size(); i++) {
            System.out.println("\n" + this.Clienti.get(i).getNume() + " " + this.Clienti.get(i).getPrenume() + " a platit " + Clienti.get(i).getPlata());
            for (int j = 0; j < this.Clienti.get(i).getProduse().size(); j++) {
                System.out.println("Produsul " + (j + 1));
                System.out.println("Produsul se numeste : " + this.Clienti.get(i).getProduse().get(j).getNumeProdus());
                System.out.println("Produsul costa : " + this.Clienti.get(i).getProduse().get(j).getPretProdus());
            }
        }
    }

    @Override
    public void afisareProduse() {
        if (Produse.size() == 0)
            System.out.println("Magazinul este gol");
        else
            for (int i = 0; i < this.Produse.size(); i++) {
                System.out.println("\nProdusul " + (i + 1));
                System.out.println("Produsul se numeste : " + this.Produse.get(i).getNumeProdus());
                System.out.println("Produsul costa : " + this.Produse.get(i).getPretProdus());
            }
    }

    @Override
    public void afisareIndexProduse() {
        if (Produse.size() == 0)
            System.out.println("Magazinul este gol");
        else
            for (int i = 0; i < this.Produse.size(); i++) {
                System.out.println("Produsul " + this.Produse.get(i).getNumeProdus() + " are indexul " + i);
            }
    }

    @Override
    public void afisareIndexProdus(String name) {
        if (Produse.size() == 0)
            System.out.println("Magazinul este gol");
        else {
            int ok = 1;
            for (int i = 0; i < this.Produse.size(); i++) {
                if (this.Produse.get(i).getNumeProdus().compareTo(name) == 0) {
                    System.out.println("Produsul " + this.Produse.get(i).getNumeProdus() + " are indexul " + i);
                    ok = 0;
                }
            }
            if (ok == 1)
                System.out.println("Nu exista niciun produs cu numele " + name);
        }
    }

    @Override
    public void adaugareClienti(Client client) {
        System.out.println("Cate produse a cumparat clientul din urmatorele: ");
        afisareProduse();
        Scanner scanner = new Scanner(System.in);
        List<Produs> produses = new ArrayList<>();
        double suma = 0.0;
        Plata platit = new Plata(0, 0, 0);
        int nr = Integer.parseInt(scanner.next());
        for (int i = 0; i < nr; i++) {
            System.out.println("Spune numarul produsului pe care clientul l-a cumparat: ");
            int nrProdus = Integer.parseInt(scanner.next());
            produses.add(Produse.get(nrProdus - 1));
            suma = suma + Produse.get(nrProdus - 1).getPretProdus();
        }
        client.setProduse(produses);

        while (suma != 0.0) {
            System.out.println("Clientul " + client.getPrenume() + " a platit cash din totatul de " + suma + " suma de:");
            platit.setCash(Double.parseDouble(scanner.next()));
            suma = suma - platit.getCash();
            if (suma != 0) {
                System.out.println("Clientul " + client.getPrenume() + " a platit cu cardul din totatul de " + suma + " suma de:");
                platit.setCard(Double.parseDouble(scanner.next()));
                suma = suma - platit.getCard();
                if (suma != 0) {
                    platit.setBonuri_valorice(suma);
                    suma = suma - platit.getBonuri_valorice();
                }
            }
        }
        client.setPlata(platit);

        this.Clienti.add(client);
        System.out.println("S-a adaugat un nou client: " + client.getNume() + " " + client.getPrenume());
    }
}