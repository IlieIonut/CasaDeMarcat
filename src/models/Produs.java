package models;

public class Produs {
    private  String NumeProdus;
    private double PretProdus;

    public Produs(String numeProdus, double pretProdus) {
        NumeProdus = numeProdus;
        PretProdus = pretProdus;
    }

    public String getNumeProdus() {
        return NumeProdus;
    }

    public void setNumeProdus(String numeProdus) {
        NumeProdus = numeProdus;
    }

    public double getPretProdus() {
        return PretProdus;
    }

    public void setPretProdus(double pretProdus) {
        PretProdus = pretProdus;
    }

    @Override
    public String toString() {
        return "produs{" +
                "NumeProdus='" + NumeProdus + '\'' +
                ", PretProdus=" + PretProdus +
                '}';
    }
}
