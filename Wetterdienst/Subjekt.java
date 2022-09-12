package Wetterdienst;

import java.util.ArrayList;

public abstract class Subjekt {
    private ArrayList<Observierer> observerier = new ArrayList<>();

    public void addObserver(Observierer observerier)
    {
        this.observerier.add(observerier);

    }

    public void deleteObserver(Observierer observer)
    {
        this.observerier.remove(observer);
    }

    public void notifyObservers()
    {
        for (Observierer o : observerier)
        {
            o.update();
        }
    }
}
