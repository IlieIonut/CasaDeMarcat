package contracts;

import models.Produs;

public interface CasaDeMarcat {
    void adaugaProdus(Produs produs);
    void stergeProdus(int index);
    void editarePretProdus(int index,Produs produs,double pret);
    void afisareClienti();
    void afisareProduse();
}
