package Befehle;

import Geraete.Stereoanlage;

public class StereoAnlageAusschaltenCommand implements ICommand
{
    private Stereoanlage stereoanlage;

    public StereoAnlageAusschaltenCommand(Stereoanlage stereoanlage)
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
        this.stereoanlage.ausschalten();
    }

    @Override
    public void undo() {
        this.stereoanlage.einschalten();
    }
}
