public class Flattern extends FlugVerhalten
{
    private int flatterFrequenz;

    public Flattern (int frequenz)
    {
        flatterFrequenz = frequenz;
    }

    @Override
    public void fliegen() {
        System.out.println("Flattere mit der Frequenz " + flatterFrequenz);
    }

    public int getFlatterFrequenz() {
        return flatterFrequenz;
    }

    public void setFlatterFrequenz(int flatterFrequenz) {
        this.flatterFrequenz = flatterFrequenz;
    }
}
