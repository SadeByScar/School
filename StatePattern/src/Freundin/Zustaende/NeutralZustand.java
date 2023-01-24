package Freundin.Zustaende;

import Freundin.Freundin.Freundin;

public class NeutralZustand implements IZustand{

    @Override
    public void reden(Freundin freundin) {
        System.out.println("sachliche reaktion");
    }

    @Override
    public void aergern(Freundin freundin) {
        System.out.println("sie ist jetzt verärgert");
        freundin.setZustand(bockigzustand);
    }

    @Override
    public void kuessen(Freundin freundin) {
        System.out.println("sie ist wieder froh");
        freundin.setZustand(frohzustand);
    }
}
