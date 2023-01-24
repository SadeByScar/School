package Freundin.Freundin;

import Freundin.Zustaende.*;

public class Freundin {

    IZustand zustand = new FrohZustand();

    public Freundin()
    {}

    public void setZustand(IZustand zustand) {
        this.zustand = zustand;
    }

    public IZustand getZustand() {
        return zustand;
    }

    public void reden()
    {
        zustand.reden(this);
    }

    public void aergern()
    {
        zustand.aergern(this);
    }

    public void kuessen()
    {
        zustand.kuessen(this);
    }

    public void kichern()
    {
        System.out.println("hihi");
    }
}
