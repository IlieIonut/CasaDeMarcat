package contracts;

import models.Client;
import models.Produs;

public interface CasaDeMarcat {
    void adaugaProdus(Produs produs);
    void stergeProdus(int index);
    void editarePretProdus(int index,double pret);
    void afisareIndexProduse();
    void afisareIndexProdus(String name);
    void afisareClienti();
    void adaugareClienti(Client client);
    void afisareProduse();
}
