package Wetterdienst;

import Verwaltung.VerwaltungsGUI;

import javax.swing.*;
import java.awt.*;

public class WetterPrognoseGUI {

    private JLabel wetterPrognoseText;
    private JLabel wetterPrognoseWert;

    private JPanel panel;

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
        wetterPrognoseWert = new JLabel();

        panel = new JPanel(new BorderLayout());

        panel.add(BorderLayout.NORTH, wetterPrognoseText);
        panel.add(BorderLayout.SOUTH, wetterPrognoseWert);

        frame.getContentPane().add(panel);

        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
