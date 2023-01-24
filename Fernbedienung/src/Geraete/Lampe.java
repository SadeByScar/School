package Geraete;

public class Lampe
{
    private boolean status = false; //wenn eingeschaltet true

    public Lampe()
    {
        status = false;
    }

    public Lampe(boolean status)
    {
        this.status = status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void einschalten()
    {
        this.setStatus(true);
        System.out.println("Die Lampe ist jetzt an.");
    }

    public void ausschalten()
    {
        this.setStatus(false);
        System.out.println("Die Lampe ist jetzt aus.");
    }
}
