package Wetterdienst;

import Verwaltung.VerwaltungsGUI;

import javax.swing.*;

public class WetterPrognoseGUI {

    private JLabel wetterPrognoseText;
    private JFrame frame;

    public static void main(String[] args)
    {
        WetterPrognoseGUI gui = new WetterPrognoseGUI();
        gui.init();
    }

    public void init()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        wetterPrognoseText = new JLabel("Wetter Prognose");
    }
}
