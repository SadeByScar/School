package src.abteilung;

import src.mitarbeiter.Manager;
import src.mitarbeiter.Mitarbeiter;

import java.util.ArrayList;

public class Abteilung
{
    private String name;
    private ArrayList<Mitarbeiter> mitarbeiter = new ArrayList<Mitarbeiter>();
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
        this.leiter = leiter;
    }

    public Manager getLeiter()
    {
        return this.leiter;
    }

    public void setMitarbeiter(ArrayList<Mitarbeiter> mitarbeiter)
    {
        this.mitarbeiter = mitarbeiter;
    }

    public ArrayList<Mitarbeiter> getMitarbeiter()
    {
        return mitarbeiter;
    }

    public void add(Mitarbeiter neuer)
    {
        mitarbeiter.add(neuer);
    }

    public void remove(Mitarbeiter welcher)
    {
        mitarbeiter.remove(welcher);
    }

    public Manager changeLeiter(Manager neuer)
    {
        this.setLeiter(neuer);
        return this.getLeiter();
    }

    public String gehaltsliste()
    {
        String rueck = "";
        for(int i = 0; i < mitarbeiter.size(); i++)
        {
            rueck += mitarbeiter.get(i).getName() + mitarbeiter.get(i).einkommen();
        }
        return rueck;
    }
}
