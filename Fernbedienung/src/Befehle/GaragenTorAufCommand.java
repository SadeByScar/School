package Befehle;

import Geraete.GaragenTor;

public class GaragenTorAufCommand implements ICommand
{
    private GaragenTor garagenTor;

    public GaragenTorAufCommand(GaragenTor garagenTor)
    {
        this.garagenTor = garagenTor;
    }

    public GaragenTor getGaragenTor() {
        return garagenTor;
    }

    public void setGaragenTor(GaragenTor garagenTor) {
        this.garagenTor = garagenTor;
    }

    @Override
    public void execute() {
        this.garagenTor.aufmachen();
    }

    @Override
    public void undo() {
        this.garagenTor.zumachen();
    }
}
