package Befehle;

import Geraete.Lampe;

public class LampeAusschaltenCommand implements ICommand{
    private Lampe lampe;

    public LampeAusschaltenCommand(Lampe lampe)
    {
        this.lampe = lampe;
    }

    public void setLampe(Lampe lampe) {
        this.lampe = lampe;
    }

    public Lampe getLampe() {
        return lampe;
    }

    @Override
    public void execute() {
        lampe.ausschalten();
    }

    @Override
    public void undo() {
        lampe.einschalten();
    }
}
