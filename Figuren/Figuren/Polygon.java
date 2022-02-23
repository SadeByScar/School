package Figuren;

public class Polygon extends ZweidimensionaleFigur
{
    private double seitenlaenge;
    private int ecken;

    public Polygon(double seitenlaenge, int ecken)
    {
        this.ecken = ecken;
        this.seitenlaenge = seitenlaenge;
    }

    public void setSeitenlaenge(double seitenlaenge) {
        this.seitenlaenge = seitenlaenge;
    }

    public double getSeitenlaenge() {
        return seitenlaenge;
    }

    public void setEcken(int ecken) {
        this.ecken = ecken;
    }

    public int getEcken() {
        return ecken;
    }

    public double flaeche()
    {
        return (new Dreieck(umKreisRadius(), umKreisRadius(), seitenlaenge).flaeche() * ecken);
    }

    public double umfang()
    {
        return this.ecken * seitenlaenge;
    }

    public  double inKreisRadius()
    {
        return seitenlaenge / (2* Math.tan(Math.PI / ecken));
    }

    public double umKreisRadius()
    {
        return seitenlaenge / (2* Math.sin(Math.PI / ecken));
    }
}
