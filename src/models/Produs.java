package models;

public class Produs {
    private  String NumeProdus;
    private double PretProdus;
    private int IdProdus;

    public Produs(String numeProdus, double pretProdus) {
        NumeProdus = numeProdus;
        PretProdus = pretProdus;
    }

    public Produs(int idProdus,String numeProdus, double pretProdus) {
        IdProdus=idProdus;
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
        return "Produs{" +
                "NumeProdus='" + NumeProdus + '\'' +
                ", PretProdus=" + PretProdus +
                ", IdProdus=" + IdProdus +
                '}';
    }
}
