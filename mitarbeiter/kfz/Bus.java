package kfz;

import java.util.ArrayList;

import GPS.GPS;
import mitarbeiter.*;

public class Bus extends PersonenTransportFahrzeug
{
    public Bus(double maxTank, double nowTank, Fahrer fahrer, GPS aktuellePos, boolean motorAn, ArrayList<Mitarbeiter> passagiere, int sitze)
    {
        super(maxTank, nowTank, fahrer, aktuellePos, motorAn, passagiere, sitze);
    }

    public boolean einsteigenFahrer(Fahrer fahrer)
    {
        String fuehrerschein = fahrer.getFuehrerscheinKlasse();
        switch (fuehrerschein)
        {
            case "D":
            case "DE":
                super.einsteigenFahrer(fahrer);
                return true;
            default:
                return false;
        }
    }
}
