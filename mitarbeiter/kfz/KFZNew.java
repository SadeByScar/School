package kfz;

import mitarbeiter.*;
import GPS.GPS;

public abstract class KFZNew
{
    private double maxTank;
    private double nowTank;
    private Fahrer fahrer;
    private GPS aktuellePos;
    private boolean motorAn;

    public KFZNew(double maxTank, double nowTank, Fahrer fahrer, GPS aktuellePos, boolean motorAn)
    {
        this.setMaxTank(maxTank);
        this.setNowTank(nowTank);
        this.setFahrer(fahrer);
        this.setAktuellePos(aktuellePos);
        this.setMotorAn(motorAn);
    }

    private void setMaxTank(double maxTank)
    {
        this.maxTank = maxTank;
    }

    public double getMaxTank()
    {
        return maxTank;
    }

    public void setNowTank(double nowTank)
    {
        this.nowTank = nowTank;
    }

    public double getNowTank()
    {
        return nowTank;
    }

    public void setFahrer(Fahrer fahrer)
    {
        this.fahrer = fahrer;
    }

    public Fahrer getFahrer()
    {
        return fahrer;
    }

    public void setAktuellePos(GPS aktuellePos)
    {
        this.aktuellePos = aktuellePos;
    }

    public GPS getAktuellePos()
    {
        return aktuellePos;
    }

    public void setMotorAn(boolean motorAn)
    {
        this.motorAn = motorAn;
    }

    public boolean getMotorAn()
    {
        return motorAn;
    }

    public double tanken(double liter)
    {
        this.setNowTank(this.getNowTank() + liter);
        if (this.getNowTank() > this.getMaxTank())
        {
            this.setNowTank(this.getMaxTank());
            return this.getNowTank() - this.getMaxTank();
        }
        return 0;
    }

    public boolean fahrenZu(GPS ziel)
    {
        if (this.getAktuellePos() == ziel)
        {
            return false;
        }
        else
        {
            this.setAktuellePos(ziel);
            return true;
        }
    }

    public boolean einsteigenFahrer(Fahrer fahrer)
    {
        if (fahrer.getFuehrerscheinKlasse() != "")
        {
            setFahrer(fahrer);
            return true;
        }
        else
        {
            return false;
        }
    }

    public void parken()
    {
        this.setFahrer(null);
        this.setMotorAn(false);
    }

    public abstract double auslastung();

    public Mitarbeiter aussteigen()
    {
        Mitarbeiter rueck = this.getFahrer();
        setFahrer(null);
        return rueck;
    }
}
