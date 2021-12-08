package mitarbeiter;

public class Buerohengst extends Mitarbeiter
{
    private double festgehalt;

    public Buerohengst(int id, String name, double festgehalt)
    {
        super(id, name);
        this.setFestgehalt(festgehalt);
    }

    protected void setId(int id)
    {
        if (id > 4999 && id < 6000)
        {
            super.setId(id);
        }
    }

    public double getFestgehalt()
    {
        return this.festgehalt;
    }

    public void setFestgehalt(double festgehalt)
    {
        this.festgehalt = festgehalt;
    }

    public double einkommen()
    {
        return this.getFestgehalt();
    }

    public String toString()
    {
        String rueck = super.toString();
        rueck += "Der Bürohengst verdient " + this.getFestgehalt() + "€ fest.";
        return rueck;
    }
}
