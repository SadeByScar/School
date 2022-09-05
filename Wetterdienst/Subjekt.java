package Wetterdienst;

import java.util.ArrayList;

public abstract class Subjekt {
    private ArrayList<Observierer> observer;

    public void addObserver(Observierer observer)
    {
        this.observer.add(observer);

    }

    public void deleteObserver(Observierer observer)
    {
        this.observer.remove(observer);
    }

    public void notifyObservers()
    {
        for (Observierer o : observer)
        {
            o.update();
        }
    }
}
