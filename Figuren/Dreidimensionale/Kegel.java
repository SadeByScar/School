package Figuren.Dreidimensionale;

import Figuren.Figuren.Zweidimensionale.Kreis;

public class Kegel extends Pyramide
{
    public Kegel(Kreis grund, double hoehe)
    {
        super(grund, hoehe);
    }

    @Override
    public double mantelflaeche() {
        double mantellinie = Math.sqrt((this.getHoehe() * this.getHoehe() + this.getGrundflaeche().getRadius()));
        return Math.PI * this.getGrundflaeche().getRadius() * mantellinie;
    }
}
