package Wetterdienst;

public class Wetterdaten extends Subjekt
{
    private double temperatur;
    private double luftdruck;
    private double luftfeuchte;

    public Wetterdaten(double temperatur, double luftdruck, double luftfeuchte)
    {
        this.temperatur = temperatur;
        this.luftdruck = luftdruck;
        this.luftfeuchte = luftfeuchte;
    }

    public double getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(double temperatur) {
        this.temperatur = temperatur;
        //notifyObservers();
    }

    public double getLuftdruck() {
        return luftdruck;
    }

    public void setLuftdruck(double luftdruck) {
        this.luftdruck = luftdruck;
        //notifyObservers();
    }

    public double getLuftfeuchte() {
        return luftfeuchte;
    }

    public void setLuftfeuchte(double luftfeuchte) {
        this.luftfeuchte = luftfeuchte;
        //notifyObservers();
    }

    public void setWetterdaten(double temperaturN, double luftdruckN, double luftfeuchteN)
    {
        this.setTemperatur(temperaturN);
        this.setLuftdruck(luftdruckN);
        this.setLuftfeuchte(luftfeuchteN);
        notifyObservers();
    }
}
