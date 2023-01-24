package Befehle;

import Geraete.Stereoanlage;

public class StereoAnlageSpieleCDCommand implements ICommand
{
    private Stereoanlage stereoanlage;

    public StereoAnlageSpieleCDCommand(Stereoanlage stereoanlage)
    {
        this.stereoanlage = stereoanlage;
    }

    public Stereoanlage getStereoanlage() {
        return stereoanlage;
    }

    public void setStereoanlage(Stereoanlage stereoanlage) {
        this.stereoanlage = stereoanlage;
    }

    @Override
    public void execute() {
        if (!this.stereoanlage.isStatus()) {
            this.stereoanlage.einschalten();
        }
        this.stereoanlage.spieleCD();
    }

    @Override
    public void undo() {
        this.stereoanlage.ausschalten();
    }
}
