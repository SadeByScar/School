package Wasserpistole.Zustaende;

import Wasserpistole.Wasserpistole.Wasserpistole;

public class VollZustand implements IZustand {

    @Override
    public void schiessen(Wasserpistole pistole) {
        pistole.setFuellstand(400);
        System.out.println("100ml verschossen");
        pistole.setZustand(halbvollzustand);
    }

    @Override
    public void befuellen(Wasserpistole pistole, int fuellmenge) {
        System.out.println("Pistole bereits voll");
    }
}
