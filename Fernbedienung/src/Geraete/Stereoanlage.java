package Geraete;

public class Stereoanlage
{
    private String cd = "";
    private int lautstaerke = 0;
    private boolean status = false;//true wenn eingeschaltet

    public Stereoanlage()
    {

    }

    public Stereoanlage(String cd, int lautstaerke, boolean status)
    {
        this.cd = cd;
        this.lautstaerke = lautstaerke;
        this.status = status;
    }

    public int getLautstaerke() {
        return lautstaerke;
    }

    public void setLautstaerke(int lautstaerke) {
        this.lautstaerke = lautstaerke;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void einschalten()
    {
        this.setStatus(true);
        System.out.println("Die Anlage ist jetzt an.");
    }

    public void ausschalten()
    {
        this.setStatus(false);
        System.out.println("Die Anlage ist jetzt aus.");
    }

    public void spieleCD()
    {
        System.out.println("Die CD " + this.getCd() + " spielt in einer Lautstärke von " + this.getLautstaerke());
    }
}
