package Dreidimensionale;

import Zweidimensionale.Kreis;

public class Kegel extends Pyramide<Kreis>
{
    public Kegel(Kreis grund, double hoehe)
    {
        super(grund, hoehe);
    }

    @Override
    public double mantelflaeche() {
        double mantellinie = Math.sqrt((this.getHoehe() * this.getHoehe()
                + this.getGrundflaeche().getRadius() * this.getGrundflaeche().getRadius()));
        return Math.PI * this.getGrundflaeche().getRadius() * mantellinie;
    }
}
