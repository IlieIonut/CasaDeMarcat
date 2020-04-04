package helper;

import contracts.CasaDeMarcatHelper;
import models.CasaDeMarcatImplementare;
import models.Client;
import models.Plata;
import models.Produs;

import java.util.ArrayList;
import java.util.List;

public class Help extends CasaDeMarcatHelper {

    @Override
    public CasaDeMarcatImplementare construiesteCasaCuDateInitiale() {

        List<Client> clients = new ArrayList<>();
        List<Produs> products = new ArrayList<>();
        List<Produs> products2 = new ArrayList<>();
        List<Plata> plata = new ArrayList<>();

        Plata plata1 = new Plata(0,3.57,0);
        plata.add(plata1);

        Produs produsList1 = new Produs("mere",3.57);
        products.add(produsList1);

        Client client1 = new Client("Ilie","Ionut");
        clients.add(client1);
        clients.get(0).setProduse(products);

        Produs produsList2 = new Produs("ciocolata",4.57);
        Produs produsList3 = new Produs("lapte",6.2);
        products2.add(produsList2);
        products2.add(produsList3);

        return new CasaDeMarcatImplementare(
                "Magazin1",
                "Pitesti",
                clients,
                plata,
                products
                );
    }
}
