package Wasserpistole.Wasserpistole;

import Wasserpistole.Zustaende.*;

public class Wasserpistole {

    private int fuellstand;
    private IZustand zustand;

    public Wasserpistole(int fuellstand)
    {
        this.setZustand(IZustand.leerzustand);
        this.setFuellstand(fuellstand);
    }

    public int getFuellstand() {
        return fuellstand;
    }

    public void setFuellstand(int fuellstand) {
        if (fuellstand <= 500) {
            this.fuellstand = fuellstand;
        }
        else
        {
            System.out.println("Ne");
        }
    }

    public IZustand getZustand() {
        return zustand;
    }

    public void setZustand(IZustand zustand) {
        this.zustand = zustand;
    }

    public void schiessen()
    {
        zustand.schiessen(this);
    }

    public void fuellen(int fuellmenge)
    {
        zustand.befuellen(this, fuellmenge);
    }
}
