package abteilung;

import mitarbeiter.Manager;
import mitarbeiter.Mitarbeiter;

import java.util.ArrayList;

public class Abteilung
{
    private String name;
    private ArrayList mitarbeiter = new ArrayList();
    private Manager leiter;

    public Abteilung(String name, Manager leiter)
    {

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

    public void setMitarbeiter(ArrayList mitarbeiter)
    {
        this.mitarbeiter = mitarbeiter;
    }

    public ArrayList getMitarbeiter()
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
        for(Mitarbeiter m : mitarbeiter)
        {
            rueck += m.getName() + m.einkommen();
        }
        return rueck;
    }
}
