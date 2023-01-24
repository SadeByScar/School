package Aufgabe2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AbbuchCommand implements Runnable
{
    Konto konto;
    double menge;

    public AbbuchCommand(Konto konto, double menge)
    {
            this.konto = konto;
            this.menge = menge;
    }

    @Override
    public void run()
    {
        konto.lock.lock();
        System.out.println(this);
        konto.abbuchen(menge);
        konto.lock.unlock();
    }
}
