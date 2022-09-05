package Wetterdienst;

public class Wetterdaten extends Subjekt
{
    private double temperatur;
    private double luftdruck;
    private double luftfeuchte;

    public Wetterdaten(double temperatur, double luftdruck, double luftfeuchte)
    {
        this.setTemperatur(temperatur);
        this.setLuftdruck(luftdruck);
        this.setLuftfeuchte(luftfeuchte);
    }

    public double getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(double temperatur) {
        this.temperatur = temperatur;
    }

    public double getLuftdruck() {
        return luftdruck;
    }

    public void setLuftdruck(double luftdruck) {
        this.luftdruck = luftdruck;
    }

    public double getLuftfeuchte() {
        return luftfeuchte;
    }

    public void setLuftfeuchte(double luftfeuchte) {
        this.luftfeuchte = luftfeuchte;
    }

    public void addObserver(WetterPrognose observer) {
        observer.setConcreteSubject(this);
        super.addObserver(observer);
    }
}
