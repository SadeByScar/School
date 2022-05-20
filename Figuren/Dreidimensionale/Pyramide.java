package Figuren.Dreidimensionale;

import Figuren.Figuren.Zweidimensionale.ZweidimensionaleFigur;

public abstract class Pyramide<T extends ZweidimensionaleFigur> extends DreidimensionaleFigur
{
    private double hoehe;
    private T grundflaeche;

    public Pyramide(T grund, double hoehe)
    {
        this.grundflaeche = grund;
        this.hoehe = hoehe;
    }

    public void setHoehe(double hoehe) {
        this.hoehe = hoehe;
    }

    public double getHoehe() {
        return hoehe;
    }

    public void setGrundflaeche(T grundflaeche) {
        this.grundflaeche = grundflaeche;
    }

    public T getGrundflaeche() {
        return grundflaeche;
    }

    @Override
    public double volumen() {
        return this.grundflaeche.flaeche() * this.hoehe * (1.0/3.0);
    }

    @Override
    public double oberflaeche() {
        return mantelflaeche() + this.grundflaeche.flaeche();
    }

    public abstract double mantelflaeche();
}
