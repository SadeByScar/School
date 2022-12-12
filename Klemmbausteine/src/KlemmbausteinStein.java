package Klemmbausteine.src;

public class KlemmbausteinStein implements KlemmbausteinTeil
{
    private String farbe;
    private int laenge;
    private int breite;
    private int hoehe;
    private double preis;

    public KlemmbausteinStein(String farbe, int laenge, int breite, int hoehe, double preis)
    {
        this.farbe = farbe;
        this.laenge = laenge;
        this.breite = breite;
        this.hoehe = hoehe;
        this.preis = preis;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public int getLaenge() {
        return laenge;
    }

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    public int getBreite() {
        return breite;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

    public int getHoehe() {
        return hoehe;
    }

    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    @Override
    public double preis() {
        return this.getPreis();
    }
}
