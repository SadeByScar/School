package Befehle;

import Geraete.Stereoanlage;

public class StereoAnlageCDSetzenCommand implements ICommand
{
    private Stereoanlage stereoanlage;
    private String cdName;

    public StereoAnlageCDSetzenCommand(Stereoanlage stereoanlage, String cdName)
    {
        this.stereoanlage = stereoanlage;
        this.cdName = cdName;
    }

    public void setStereoanlage(Stereoanlage stereoanlage) {
        this.stereoanlage = stereoanlage;
    }

    public Stereoanlage getStereoanlage() {
        return stereoanlage;
    }

    public void setCdName(String cdName) {
        this.cdName = cdName;
    }

    public String getCdName() {
        return cdName;
    }

    @Override
    public void execute() {
        String temp = this.stereoanlage.getCd();
        this.stereoanlage.setCd(this.cdName);
        this.setCdName(temp);
    }

    @Override
    public void undo() {
        String temp = this.stereoanlage.getCd();
        this.stereoanlage.setCd(this.cdName);
        this.setCdName(temp);
    }
}
