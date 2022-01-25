package kfz;

public class LKW extends KFZNew
{
    private double ladeFlaeche;
    private double ladung;    

    public LKW(double maxTank, double nowTank, Fahrer fahrer, GPS aktuellePos, boolean motorAn, double ladeFlaeche, double ladung)
    {
        super(maxTank, nowTank, fahrer, aktuellePos, motorAn);
        this.setLadeFlaeche(ladeFlaeche);
        this.setLadung(ladung);
    }

    public void setLadeFlaeche(double ladeFlaeche)
    {
        this.ladeFlaeche = ladeFlaeche;
    }

    public double getLadeFlaeche()
    {
        return this.ladeFlaeche;
    }

    public void setLadung(double ladung)
    {
        this.ladung = ladung;
    }

    public double getLadung()
    {
        return this.ladung;
    }

    public boolean beladen(double menge)
    {
        if ((this.getLadung() + menge) <= this.getLadeFlaeche())
        {
            this.setLadung(this.getLadung() + menge);
            return true;
        }
        else 
        {
            return false;
        }

    }

    public void entladen(double menge)
    {
        if ((this.getLadung() - menge) > 0)
        {
            this.setLadung(this.getLadung() - menge);
        }
        else
        {
            this.setLadung(0);
        }
    }

    public boolean einsteigenFahrer(Fahrer fahrer)
    {
        String fuehrerschein = fahrer.getFuehrerscheinKlasse();
        switch (fuehrerschein)
        {
            case "C":
            case "CE":
                return true;
                break;
            default:
                return false;
                break;
        }
    }
}

