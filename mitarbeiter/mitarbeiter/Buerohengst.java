package mitarbeiter;

public class Buerohengst extends Mitarbeiter
{
    private double festgehalt;

    public Buerohengst(int id, String name, double festgehalt)
    {
        super(id, name);
        this.setId(id);
        this.setFestgehalt(festgehalt);
    }

    public Buerohengst(Buerohengst original)
    {
        this.setId(original.getId());
        this.setFestgehalt(original.getFestgehalt());
        this.setName(original.getName());
    }

    protected void setId(int id) throws IllegalArgumentException
    {
        if (id > 4999 && id < 6000)
        {
            super.setId(id);
        }
        else
        {
            throw new IllegalArgumentException("Invalide ID");
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
