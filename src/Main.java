import helper.Help;
import models.CasaDeMarcatImplementare;
import models.Client;
import models.Produs;
import service.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CasaDeMarcatImplementare a = new Help().construiesteCasaCuDateInitiale();
        a.afisareClienti();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Magazinul " + a.getNumeMagazinCasa() + " va sta la dispozitie!");
        System.out.println("\n");
        Service service=new Service();
/*
        while (true) {
            System.out.println("Selectati una din optiunile de mai jos pentru a afla mai multe informatii.");
            System.out.println("1.Adauga produs");
            System.out.println("2.Sterge produs");
            System.out.println("3.Editare pret produs");
            System.out.println("4.Afisare produse");
            System.out.println("5.Afisare clienti");
            System.out.println("6.Afisare index pentru fiecare produs");
            System.out.println("7.Afisare index pentru un anumit produs");
            System.out.println("8.Adauga un client nou");
            System.out.println("exit");
            String optiune = scanner.next();
            switch (optiune) {
                case "1":
                    System.out.println("Introduceti numele produs: ");
                    String numeProdus = scanner.next();
                    System.out.println("Introduceti pretul produsului: ");
                    double pretProdus = Double.parseDouble(scanner.next());
                    Produs produs = new Produs(numeProdus, pretProdus);
                    a.adaugaProdus(produs);
                    break;
                case "2":
                    System.out.println("Introduceti indexul produsului: ");
                    String index = scanner.next();
                    a.stergeProdus(Integer.valueOf(index));
                    break;
                case "3":
                    System.out.println("Pret nou produs : ");
                    double pretProdus1 = Double.parseDouble(scanner.next());
                    System.out.println("Introduceti indexul produsului: ");
                    String index1 = scanner.next();
                    a.editarePretProdus(Integer.valueOf(index1), pretProdus1);
                    break;
                case "4":
                    System.out.println("Produsele din magazin sunt: ");
                    a.afisareProduse();
                    System.out.println("\n");
                    break;
                case "5":
                    System.out.println("Clientii magazinului sunt: ");
                    a.afisareClienti();
                    System.out.println("\n");
                    break;
                case "6":
                    a.afisareIndexProduse();
                    System.out.println("\n");
                    break;
                case "7":
                    System.out.println("Numele produsului pentru care vreti sa aflati indexul: ");
                    String numeProdusIndex = scanner.next();
                    a.afisareIndexProdus(numeProdusIndex);
                    System.out.println("\n");
                    break;
                case "8":
                    System.out.println("Introduceti numele clientului: ");
                    String nume = scanner.next();
                    System.out.println("Introduceti prenumele clientului: ");
                    String prenume = scanner.next();
                    Client client = new Client(nume, prenume);
                    a.adaugareClienti(client);
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n");
                    System.out.println("Ai ales o optiune incorecta, selectati una din cele de mai jos.");
            }
        }*/

        System.out.println("1.Afisarea clientilor");
        System.out.println("2.Afisarea produselor");

        while (true) {
            String line = scanner.nextLine();
            switch (line) {
                case "1":
                    service.initReportHeader();
                    service.writeDataToReport(a);
                    break;

                case "2":
                    service.initReportHeader1();
                    service.writeDataToReport1(a);
                    break;
            }
            break;
        }


    }
}
