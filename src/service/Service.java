package service;

import models.CasaDeMarcatImplementare;

import java.io.*;

public class Service {
    private String filePath = "C:\\Users\\iliec\\Desktop\\javalab\\proiect\\src\\repository\\ReportData1.csv";
    private String filePath1 = "C:\\Users\\iliec\\Desktop\\javalab\\proiect\\src\\repository\\ReportData2.csv";

    public void writeDataToReport(CasaDeMarcatImplementare C1) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            for (int i = 0; i < C1.getClienti().size(); i++) {
                bufferedWriter.append(C1.getClienti().get(i).getNume());
                bufferedWriter.append(",");
                bufferedWriter.append(C1.getClienti().get(i).getPrenume());
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(C1.getClienti().get(i).getPlata().getCash()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(C1.getClienti().get(i).getPlata().getCard()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(C1.getClienti().get(i).getPlata().getBonuri_valorice()));
                bufferedWriter.append(",");
                for (int j = 0; j < C1.getClienti().get(i).getProduse().size(); j++) {
                    bufferedWriter.append(String.valueOf(j+1));
                    bufferedWriter.append(",");
                    bufferedWriter.append(C1.getClienti().get(i).getProduse().get(j).getNumeProdus());
                    bufferedWriter.append(",");
                    bufferedWriter.append(String.valueOf(C1.getClienti().get(i).getProduse().get(j).getPretProdus()));
                    bufferedWriter.append("\n");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeDataToReport1(CasaDeMarcatImplementare C1) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath1, true))) {
            for (int i = 0; i < C1.getProdus().size(); i++) {
                bufferedWriter.append(String.valueOf(i+1));
                bufferedWriter.append(",");
                bufferedWriter.append(C1.getProdus().get(i).getNumeProdus());
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(C1.getProdus().get(i).getPretProdus()));
                bufferedWriter.append(",");
                bufferedWriter.append("\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public  void initReportHeader() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.append("NUME");
            bufferedWriter.append(",");
            bufferedWriter.append("Prenume");
            bufferedWriter.append(",");
            bufferedWriter.append("Plata Cash");
            bufferedWriter.append(",");
            bufferedWriter.append("Plata Card");
            bufferedWriter.append(",");
            bufferedWriter.append("Plata Bonuri Valorice");
            bufferedWriter.append(",");
            bufferedWriter.append("Nr Produs");
            bufferedWriter.append(",");
            bufferedWriter.append("Nume Produs");
            bufferedWriter.append(",");
            bufferedWriter.append("Pret Produs");
            bufferedWriter.append("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public  void initReportHeader1() {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath1))) {
                bufferedWriter.append("Nr Produs");
                bufferedWriter.append(",");
                bufferedWriter.append("Nume Produs");
                bufferedWriter.append(",");
                bufferedWriter.append("Pret Produs");
                bufferedWriter.append("\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }

    public void readDataFromCsv() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String record;
            while ((record = bufferedReader.readLine()) != null) {
                String[] recordData = record.split(",");
                System.out.println(recordData[0] + " " + recordData[1]);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

