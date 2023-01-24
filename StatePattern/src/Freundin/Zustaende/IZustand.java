package Freundin.Zustaende;

import Freundin.Freundin.Freundin;

public interface IZustand {

    public static IZustand frohzustand = new FrohZustand();
    public static IZustand neutralzustand = new NeutralZustand();
    public static IZustand bockigzustand = new BockigZustand();

    public void reden(Freundin freundin);

    public void aergern(Freundin freundin);

    public void kuessen(Freundin freundin);
}
