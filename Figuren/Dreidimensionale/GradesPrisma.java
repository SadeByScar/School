package Dreidimensionale;

import Zweidimensionale.ZweidimensionaleFigur;

public class GradesPrisma<T extends ZweidimensionaleFigur> extends DreidimensionaleFigur
{
    private double hoehe;
    private T grundflaeche;

    public GradesPrisma(T grund, double hoehe)
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
        return this.grundflaeche.flaeche() * this.hoehe;
    }

    @Override
    public double oberflaeche() {
        return this.grundflaeche.flaeche() * 2 + this.grundflaeche.umfang() * this.hoehe;
    }
}
