package Dreidimensionale;

import DataRetriver.DataRetriever;

import java.util.HashMap;

public abstract class DreidimensionaleFigur
{
    private static DataRetriever retrieverOberflaeche = new DataRetriever("Materialpreise Oberflaechen.csv");
    private static DataRetriever retrieverFuellung = new DataRetriever("Materialpreise Fuellung.csv");
    private static HashMap<String, Double> preiseOberflaeche = retrieverOberflaeche.getRecords();
    private static HashMap<String,Double> preiseFuellung = retrieverFuellung.getRecords();

    public abstract double oberflaeche();

    public abstract double volumen();

    public double berechnePreis(String oberflaechenMaterial, String fuellMaterial)
    {
        double preis = this.volumen() * preiseFuellung.get(fuellMaterial);
        preis = preis + this.oberflaeche() * preiseOberflaeche.get(oberflaechenMaterial);
        return preis;
    }
}
