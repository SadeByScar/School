package Wasserpistole.Zustaende;

import Wasserpistole.Wasserpistole.Wasserpistole;

public class LeerZustand implements IZustand {

    @Override
    public void schiessen(Wasserpistole pistole) {
        System.out.println("Nicht möglich weil kein Wasser");
    }

    @Override
    public void befuellen(Wasserpistole pistole, int fuellmenge) {
        if (fuellmenge >= 500)
        {
            if (pistole.getFuellstand() + fuellmenge > 500)
            {
                System.out.println("Nicht möglich so viel einzufüllen. Nur bis 500ml gefüllt");
            }
            else
            {
                System.out.println("Pistole ist jetzt voll");
            }
            pistole.setFuellstand(500);
            pistole.setZustand(vollzustand);
        }
        else
        {
            System.out.println("Pistole wurde um " + fuellmenge + "ml aufgefuellt");
            pistole.setFuellstand(fuellmenge);
            pistole.setZustand(halbvollzustand);
        }

    }
}
