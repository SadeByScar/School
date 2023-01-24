package Wasserpistole.Zustaende;

import Wasserpistole.Wasserpistole.Wasserpistole;

public class HalbvollZustand implements IZustand {

    @Override
    public void schiessen(Wasserpistole pistole) {
        if (pistole.getFuellstand() > 50)
        {
            System.out.println("50ml verschossen");
            pistole.setFuellstand(pistole.getFuellstand() - 50);
        }
        else
        {
            System.out.println(pistole.getFuellstand() +  "ml verschossen");
            pistole.setFuellstand(0);
            pistole.setZustand(leerzustand);
        }
    }

    @Override
    public void befuellen(Wasserpistole pistole, int fuellmenge) {
        if (pistole.getFuellstand() + fuellmenge >= 500)
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
            pistole.setFuellstand(pistole.getFuellstand() + fuellmenge);
        }

    }
}
