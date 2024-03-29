package Dreidimensionale;

import Zweidimensionale.Polygon;

public class GleichseitigePyramide extends Pyramide<Polygon>
{
    public GleichseitigePyramide(Polygon grund, double hoehe)
    {
        super(grund, hoehe);
    }

    @Override
    public double mantelflaeche() {
        double dreieckshoehe = Math.sqrt((this.getHoehe() * this.getHoehe())
                + ((this.getGrundflaeche().getSeitenlaenge() / 2.0) * this.getGrundflaeche().getSeitenlaenge() / 2.0));
        return 2 * this.getGrundflaeche().getSeitenlaenge() * dreieckshoehe;
    }
}
