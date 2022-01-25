package mitarbeiter;

public class Malocher extends Mitarbeiter
{
    private double stundenSatz;
    private int anzahlStunden = 0;

    public Malocher(int id, String name, double stundenSatz)
    {
        super(id, name);
        this.setId(id);
        this.setStundenSatz(stundenSatz);
    }

    public Malocher(Malocher original)
    {
        super(original);
        this.setId(original.getId());
        this.setStundenSatz(original.getStundenSatz());
    }

    protected void setId(int id) throws IllegalArgumentException
    {
        if (id > 2999 && id < 4000)
        {
            super.setId(id);
        }
        else
        {
            throw new IllegalArgumentException("Invalide ID");
        }
    }

    public void setAnzahlStunden(int anzahlStunden)
    {
        this.anzahlStunden = anzahlStunden;
    }

    public int getAnzahlStunden()
    {
        return this.anzahlStunden;
    }

    public void setStundenSatz(double stundenSatz)
    {
        this.stundenSatz = stundenSatz;
    }

    public double getStundenSatz()
    {
        return this.stundenSatz;
    }

    public double einkommen()
    {
        return this.anzahlStunden * this.getStundenSatz();
    }

    public String toString()
    {
        String rueck = super.toString();
        rueck += "Der Mitarbeiter hat einen Stundensatz von " + this.getStundenSatz() + " und arbeitet " + this.getAnzahlStunden() + " Stunden.";
        return rueck;
    }
}
