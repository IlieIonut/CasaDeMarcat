import helper.Help;
import models.CasaDeMarcatImplementare;
import models.Produs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CasaDeMarcatImplementare a = new Help().construiesteCasaCuDateInitiale();
        a.afisareClienti();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Magazinul "+ a.getNumeMagazinCasa() + " va sta la dispozitie!");
        System.out.println("\n");
        System.out.println("Selectati una din optiunile de mai jos pentru a afla mai multe informatii.");

        System.out.println("1.Adauga produs");
        System.out.println("2.Sterge produs");
        System.out.println("3.Editare pret produs");
        System.out.println("4.Afisare produse");
        System.out.println("5.Afisare clienti");
        System.out.println("6.exit");

        while (true) {
            String optiune = scanner.next();
            switch (optiune) {
                case "1":
                    System.out.println("Introduceti numele produs: ");
                    String numeProdus = scanner.next();
                    System.out.println("Introduceti pretul produsului: ");
                    double pretProdus = Double.parseDouble(scanner.next());
                    Produs produs = new Produs(numeProdus,pretProdus);
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
                    System.out.println("Introduceti numele produs: ");
                    String numeProdus1 = scanner.next();
                    Produs produs1 = new Produs(numeProdus1,pretProdus1);
                    System.out.println("Introduceti indexul produsului: ");
                    String index1 = scanner.next();
                    a.editarePretProdus(Integer.valueOf(index1),produs1,pretProdus1);
                    break;
                case "4":
                    System.out.println("Produsele din magazin sunt: ");
                    System.out.println("\n");
                    a.afisareProduse();
                    break;
                case "5":
                    System.out.println("Clientii magazinului sunt: ");
                    System.out.println("\n");
                    a.afisareClienti();
                    break;
                case "exit" :
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n");
                    System.out.println("Ai ales o optiune incorecta, selectati una din cele de mai sus.");
            }
        }

    }
}
