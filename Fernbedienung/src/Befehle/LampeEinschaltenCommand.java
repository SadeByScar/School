package Befehle;

import Geraete.Lampe;

public class LampeEinschaltenCommand implements ICommand
{
    private Lampe lampe;

    public LampeEinschaltenCommand(Lampe lampe)
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
        lampe.einschalten();
    }

    @Override
    public void undo() {
        lampe.ausschalten();
    }
}
