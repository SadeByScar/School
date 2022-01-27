package kfz;

import mitarbeiter.*;

import java.util.ArrayList;

import javax.swing.event.SwingPropertyChangeSupport;

import GPS.GPS;

public class PersonenTransportFahrzeug extends KFZNew
{
    private ArrayList<Mitarbeiter> passagiere = new ArrayList<Mitarbeiter>();
    private int sitze;

    public PersonenTransportFahrzeug(double maxTank, double nowTank, Fahrer fahrer, GPS aktuellePos, boolean motorAn, ArrayList<Mitarbeiter> passagiere, int sitze)
    {
        super(maxTank, nowTank, fahrer, aktuellePos, motorAn);
        this.setPassagiere(passagiere);
        this.setSitze(sitze);
    }

    public void setPassagiere(ArrayList<Mitarbeiter> passagiere)
    {
        this.passagiere = passagiere;
    }

    public ArrayList<Mitarbeiter> getPassagiere()
    {
        return this.passagiere;
    }

    public void setSitze(int sitze)
    {
        this.sitze = sitze;
    }

    public int getSitze()
    {
        return this.sitze;
    }

    public boolean einsteigenFahrer(Fahrer fahrer)
    {
        String fuehrerschein = fahrer.getFuehrerscheinKlasse();
        switch (fuehrerschein)
        {
            case "B":
            case "BE":
            case "B96":
            case "C":
            case "CE":
            case "D":
            case "DE":
                return true;
            default:
                return false;
        }
    }

    public boolean einsteigen(Mitarbeiter passagier)
    {
        if (this.getPassagiere().size() == this.getSitze())
        {
            return false;
        }
        else
        {
            this.passagiere.add(passagier);
            return true;
        }
    }

    public void parken()
    {
        super.parken();
        this.setPassagiere(new ArrayList<Mitarbeiter>());
    }

    public Mitarbeiter aussteigen(int vonPlatz)
    {
        Mitarbeiter rueck = this.getPassagiere().get(vonPlatz);
        this.getPassagiere().remove(vonPlatz);
        return rueck;
    }

    public double auslastung()
    {
        return this.getPassagiere().size() / this.getSitze();
    }

}