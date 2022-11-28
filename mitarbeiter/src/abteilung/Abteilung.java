package src.abteilung;

import src.IAbteilungsTeil;
import src.mitarbeiter.Manager;
import src.mitarbeiter.Mitarbeiter;

import java.util.ArrayList;

public class Abteilung implements IAbteilungsTeil
{
    private String name;
    private ArrayList<IAbteilungsTeil> abteilungsTeile = new ArrayList<IAbteilungsTeil>();
    private Manager leiter;

    public Abteilung(String name, Manager leiter)
    {
        this.setName(name);
        this.setLeiter(leiter);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setLeiter(Manager leiter)
    {
        this.leiter.setAbteilung(null);
        this.leiter = leiter;
    }

    public Manager getLeiter()
    {
        return this.leiter;
    }

    public void setAbteilungsTeile(ArrayList<IAbteilungsTeil> abteilungsTeile)
    {
        this.abteilungsTeile = abteilungsTeile;
    }

    public ArrayList<IAbteilungsTeil> getAbteilungsTeile()
    {
        return abteilungsTeile;
    }

    public void add(IAbteilungsTeil neuer)
    {
        abteilungsTeile.add(neuer);
    }

    public void remove(IAbteilungsTeil welcher)
    {
        abteilungsTeile.remove(welcher);
    }

    public Manager changeLeiter(Manager neuer)
    {
        this.setLeiter(neuer);
        return this.getLeiter();
    }

    public String gehaltsliste()
    {
        String rueck = "";
        for(int i = 0; i < abteilungsTeile.size(); i++)
        {
            rueck += abteilungsTeile.get(i).getName() + abteilungsTeile.get(i).einkommen();
        }
        return rueck;
    }

    @Override
    public double einkommen() {
        double rueck = 0;
        for(int i = 0; i < abteilungsTeile.size(); i++)
        {
            rueck += abteilungsTeile.get(i).einkommen();
        }
        return rueck;
    }

    public String toString()
    {
        String rueck = "In der Abteilung " + this.getName() + " sind folgende Teile: ";
        for (IAbteilungsTeil teil: this.getAbteilungsTeile())
        {
            teil.toString();
        }
        return rueck;
    }

    public int zaehlen()
    {
        int rueck = 0;
        for (IAbteilungsTeil teil: this.getAbteilungsTeile())
        {
            rueck += teil.zaehlen();
        }
        return rueck;
    }
}
