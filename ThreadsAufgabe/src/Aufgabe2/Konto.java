package Aufgabe2;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Konto
{
    public Lock lock = new ReentrantLock();
    private String name;
    private double kontostand;

    public Konto(String name, double kontostand)
    {
        this.name = name;
        this.kontostand = kontostand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getKontostand() {
        return kontostand;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    public void abbuchen(double menge)
    {
   /*     if (lock.tryLock()) {
            lock.lock();*/
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (kontostand - menge < 0)
            {
                System.out.println("Nicht genug Geld auf " + this.getName());
                return;
            }
            this.setKontostand(kontostand - menge);
            System.out.println("Nach der Abbuchung von " + menge + " Euro sind noch " + this.getKontostand() + " Euro auf " + this.getName());
            //lock.unlock();
        //}
    }
}
