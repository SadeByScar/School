package Freundin.Zustaende;


import Freundin.Freundin.Freundin;

public class BockigZustand implements IZustand{

    @Override
    public void reden(Freundin freundin) {
        System.out.println("ignoriert kevin");
    }

    @Override
    public void aergern(Freundin freundin) {

    }

    @Override
    public void kuessen(Freundin freundin) {
        System.out.println("laune bessert sich");
        freundin.setZustand(neutralzustand);
    }
}
