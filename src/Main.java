import helper.Help;
import models.CasaDeMarcatImplementare;
import models.Client;
import models.Produs;
import repository.BazaDeDate;
import service.Service;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static CasaDeMarcatImplementare mainRepository = new Help().construiesteCasaCuDateInitiale();

    public static void main(String[] args) throws SQLException {
      /*  CasaDeMarcatImplementare a = new Help().construiesteCasaCuDateInitiale();
        a.afisareClienti();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Magazinul " + a.getNumeMagazinCasa() + " va sta la dispozitie!");
        System.out.println("\n");
        Service service=new Service();

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
/*
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

*/
        BazaDeDate bazaDeDate = new BazaDeDate();

        try {
            Class.forName("com.mysql.jdbc.Driver");
//            Produs p = new Produs("mere", 3.89);

//            System.out.println("Produsu din baza: ");
//            System.out.println(bazaDeDate.getProduts());

            //   bazaDeDate.addProduct(p);

//            System.out.println("Persoane din baza: ");
//            System.out.println(bazaDeDate.getProduts());

 //           System.out.println("Id este " + bazaDeDate.getId("mere"));
 //           int id = bazaDeDate.getId("mere");
  //          bazaDeDate.deleteProduct(id);
  //          bazaDeDate.updateProduct(5.32, "mere");
  //          System.out.println("Persoane din baza: ");
   //         System.out.println(bazaDeDate.getProduts());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        JFrame jFrame = new JFrame("Magazin");

        JLabel nameLabel = new JLabel("Nume Produs: ");
        JTextField nameTextField = new JTextField();
        nameLabel.setBounds(230, 70, 200, 30);
        nameTextField.setBounds(310, 70, 200, 30);

        JLabel pretLabel = new JLabel("Pret Produs: ");
        JTextField pretTextField = new JTextField();
        pretLabel.setBounds(230, 120, 200, 30);
        pretTextField.setBounds(310, 120, 200, 30);

        JButton jButtonAdd = new JButton("Adauga produs");
        jButtonAdd.setBounds(20, 250, 150, 30);

        JButton jButtonUpd = new JButton("Schimba pret");
        jButtonUpd.setBounds(200, 250, 150, 30);

        JButton jButtonAfs = new JButton("Afiseaza produse");
        jButtonAfs.setBounds(550, 250, 200, 30);

        JButton jButtondel = new JButton("Sterge Produs");
        jButtondel.setBounds(380, 250, 150, 30);


        JList<Produs> jList = new JList<>();
        jList.setBounds(20, 300, 730, 400);

        jButtonAdd.addActionListener(addActionListener(nameTextField, pretTextField, bazaDeDate));
        jButtonAfs.addActionListener(afisareProduse(jList, bazaDeDate));
        jButtonUpd.addActionListener(updateProduse(nameTextField, pretTextField, bazaDeDate));
        jButtondel.addActionListener(deleteProdus(bazaDeDate, nameTextField));


        jFrame.add(nameLabel);
        jFrame.add(nameTextField);
        jFrame.add(pretLabel);
        jFrame.add(pretTextField);
        jFrame.add(jButtonAdd);
        jFrame.add(jButtonUpd);
        jFrame.add(jButtonAfs);
        jFrame.add(jButtondel);
        jFrame.add(jList);
        jFrame.setSize(800, 800);
        jFrame.setLayout(null);
        jFrame.setVisible(true);


    }

    private static ActionListener addActionListener(JTextField nameTextField, JTextField pretTextField, BazaDeDate bazaDeDate) {
        ActionListener actionListener = action -> {
            String name = nameTextField.getText();
            Double pret = Double.valueOf(pretTextField.getText());

            Produs produs = new Produs(name, pret);
            mainRepository.adaugaProdus(produs);
            try {
                bazaDeDate.addProduct(produs);
                System.out.println(bazaDeDate.getProduts());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Produsul a fost adaugat cu succes!");
        };
        return actionListener;
    }

    private static ActionListener updateProduse(JTextField nameTextField, JTextField pretTextField, BazaDeDate bazaDeDate) {
        ActionListener actionListener = action -> {
            String name = nameTextField.getText();
            Double pret = Double.valueOf(pretTextField.getText());
            try {
                bazaDeDate.updateProduct(pret, name);
                System.out.println(bazaDeDate.getProduts());
            } catch (SQLException e) {
                e.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "Produsului " + name + " i s-a schimbat pretu!");
        };
        return actionListener;
    }

    private static ActionListener deleteProdus(BazaDeDate bazaDeDate,JTextField nameTextField) {
        ActionListener actionListener = action -> {
            String name = nameTextField.getText();
            try {
                int id = bazaDeDate.getId(name);
                bazaDeDate.deleteProduct(id);
                System.out.println(bazaDeDate.getProduts());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Produsul " + name + " a fost sters!");
        };
        return actionListener;
    }

    private static ActionListener afisareProduse(JList jList, BazaDeDate bazaDeDate) {
        ActionListener actionListener = action -> {
            try {
                jList.setListData(getPeopleAsArray(bazaDeDate));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        };
        return actionListener;
    }

    private static Produs[] getPeopleAsArray(BazaDeDate bazaDeDate) throws SQLException {
        return bazaDeDate.getProduts().toArray(new Produs[0]);
    }
}
