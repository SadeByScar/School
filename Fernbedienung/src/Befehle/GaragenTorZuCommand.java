package Befehle;

import Geraete.GaragenTor;

public class GaragenTorZuCommand implements ICommand
{
    private GaragenTor garagenTor;

    public GaragenTorZuCommand(GaragenTor garagenTor)
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
        this.garagenTor.zumachen();
    }

    @Override
    public void undo() {
        this.garagenTor.aufmachen();
    }
}
