package Wasserpistole.Zustaende;

import Wasserpistole.Wasserpistole.Wasserpistole;

public interface IZustand {
    public static IZustand vollzustand = new VollZustand();
    public static IZustand leerzustand = new LeerZustand();
    public static IZustand halbvollzustand = new HalbvollZustand();

    public void schiessen(Wasserpistole pistole);
    public void befuellen(Wasserpistole pistole, int fuellmenge);
}
