package src.mitarbeiter;

import src.IAbteilungsTeil;
import src.abteilung.Abteilung;

public class Manager extends Buerohengst
{
    private double bonusSatz;
    private Abteilung abteilung;

    public Manager(int id, String name, double festgehalt, double bonusSatz)
    {
        super(id, name, festgehalt);
        this.setId(id);
        this.setBonusSatz(bonusSatz);
    }

    public Manager(int id, String name, double festgehalt, double bonusSatz, Abteilung abteilung)
    {
        this(id, name, festgehalt, bonusSatz);
        this.setAbteilung(abteilung);
    }

    protected void setId(int id) throws IllegalArgumentException
    {
        if (id > 4999 && id < 5100)
        {
            super.setId(id);
        }
        else
        {
            throw new IllegalArgumentException("Invalide ID");
        }
    }

    public double getBonusSatz()
    {
        return this.bonusSatz;
    }

    public void setBonusSatz(double bonusSatz)
    {
        if (bonusSatz <= 0)
        {
            throw  new IllegalArgumentException("Bonussatz kann nicht kleiner gleich 0 sein.");
        }
        else
        {
            this.bonusSatz = bonusSatz;
        }
    }

    public Abteilung getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(Abteilung abteilung) {
        if (abteilung == null)
        {
            this.abteilung = null;
        }
        else {
            this.abteilung = abteilung;
        }
    }

    public double einkommen()
    {
        return this.getFestgehalt() + this.berechneBonus();
    }

    public double berechneBonus()
    {
        return this.getFestgehalt() * (this.getBonusSatz() / 100);
    }

    public String toString()
    {
        String rueck = "Der Manager " + this.getName() + " bekommt " + this.einkommen() + "€\n";
/*        for (IAbteilungsTeil teil: abteilung.getAbteilungsTeile())
        {
            rueck += teil.toString();
        }*/
        //abteilung.toString();
        return rueck;
    }

    public String mitarbeiterZaehlen()
    {
        return "Der Manager hat " + this.getAbteilung().zaehlen() + " Mitarbeiter unter sich.";
    }
}
