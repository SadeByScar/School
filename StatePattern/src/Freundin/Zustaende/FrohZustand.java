package Freundin.Zustaende;

import Freundin.Freundin.Freundin;

public class FrohZustand implements IZustand{

    @Override
    public void reden(Freundin freundin) {
        freundin.kichern();
        System.out.println("sie redet");
    }

    @Override
    public void aergern(Freundin freundin) {
        System.out.println("sie ist jetzt verärgert");
        freundin.setZustand(bockigzustand);
    }

    @Override
    public void kuessen(Freundin freundin) {
        System.out.println("n kuss");
    }
}
