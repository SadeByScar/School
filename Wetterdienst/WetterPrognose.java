package Wetterdienst;

public class WetterPrognose extends Subjekt implements Observierer {

    private Wetterdaten concreteSubject;
    private String besserung;
    private double alterDruck;

    public WetterPrognose(Wetterdaten subject)
    {
        this.setConcreteSubject(subject);
        subject.addObserver(this);
        alterDruck = concreteSubject.getLuftdruck();
    }

    public Wetterdaten getConcreteSubject() {
        return concreteSubject;
    }

    public void setConcreteSubject(Wetterdaten concreteSubject) {
        this.concreteSubject = concreteSubject;
    }

    public String getBesserung() {
        return besserung;
    }

    public void setBesserung(String besserung) {
        this.besserung = besserung;
        notifyObservers();
    }

    @Override
    public void update() {

        double aktuellerDruck = concreteSubject.getLuftdruck();
        if (alterDruck > aktuellerDruck)
        {
            this.setBesserung("Das Wetter wird schlechter!");
        }
        else if (alterDruck < aktuellerDruck)
        {
            this.setBesserung("Das Wetter wird besser!");
        }
        else if (alterDruck == aktuellerDruck)
        {
            this.setBesserung("Das Wetter bleibt gleich!");
        }
        alterDruck = aktuellerDruck;
        //this.notifyObservers();
    }
}
