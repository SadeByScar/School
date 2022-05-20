package Figuren.Figuren.Zweidimensionale;

public class Dreieck extends ZweidimensionaleFigur
{
    private double laenge1;
    private double laenge2;
    private double laenge3;

    public Dreieck(double laenge1, double laenge2, double laenge3)
    {
        this.laenge1 = laenge1;
        this.laenge2 = laenge2;
        this.laenge3 = laenge3;
    }

    public void setLaenge1(double laenge)
    {
        this.laenge1 = laenge;
    }

    public double getLaenge1()
    {
        return this.laenge1;
    }

    public void setLaenge2(double laenge)
    {
        this.laenge2 = laenge;
    }

    public double getLaenge2()
    {
        return this.laenge2;
    }

    public void setLaenge3(double laenge)
    {
        this.laenge3 = laenge;
    }

    public double getLaenge3()
    {
        return this.laenge3;
    }

    public double flaeche() {
        double s = (laenge1 + laenge2 + laenge3) / 2;
        return Math.sqrt(s * (s - laenge1) * (s - laenge2) * (s - laenge3));
    }

    public double umfang() {
        return this.laenge1 + this.laenge2 + this.laenge3;
    }
}
