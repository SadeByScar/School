package mitarbeiter;

public class Manager extends Buerohengst
{
    private double bonusSatz;

    public Manager(int id, String name, double festgehalt, double bonusSatz)
    {
        super(id, name, festgehalt);
        this.setBonusSatz(bonusSatz);
    }

    protected void setId(int id)
    {
        if (id > 4999 && id < 5100)
        {
            super.setId(id);
        }
    }

    public double getBonusSatz()
    {
        return this.bonusSatz;
    }

    public void setBonusSatz(double bonusSatz)
    {
        this.bonusSatz = bonusSatz;
    }

    public double einkommen()
    {
        return this.getFestgehalt() + this.berechneBonus();
    }

    public double berechneBonus()
    {
        return this.getFestgehalt() * (this.getBonusSatz() / 100);
    }
}
