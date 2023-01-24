public class main
{
    public static void main(String[] args)
    {
        Ente angela = new Gummiente(new Quiecken(), new NichtFlieger());
        FlugVerhalten flattern = new Flattern(1);
        Ente eberhart = new Stockente(new NormalesQuacken(), flattern);
        angela.quacken();
        eberhart.fliegen();
        eberhart.setFlugVerhalten(new Gleiten());
        eberhart.fliegen();
    }
}
