package mitarbeiter;

public class Malocher extends Mitarbeiter
{
    private double stundenSatz;
    private int anzahlStunden = 0;

    public Malocher(int id, String name, double stundenSatz)
    {
        super(id, name);
        this.setStundenSatz(stundenSatz);
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
        return this.anzahlStunden * this.stundenSatz;
    }

    public String toString()
    {
        String rueck = super.toString();
        rueck += "Der Mitarbeiter hat einen Stundensatz von " + this.stundenSatz + " und arbeitet " + this.anzahlStunden + " Stunden.";
        return rueck;
    }
}
