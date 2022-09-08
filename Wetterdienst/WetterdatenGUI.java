package Wetterdienst;

import javax.swing.*;
import java.awt.*;

public class WetterdatenGUI {

    private JLabel wetterdatenText;
    private JLabel druckText;
    private JLabel temperaturText;
    private JLabel feuchtText;
    private JLabel druckWert;
    private JLabel temperaturWert;
    private JLabel feuchtWert;

    private JPanel panel;
    private JPanel northPanel;
    private JPanel midPanel;
    private JPanel southPanel;

    private JFrame frame;

    Wetterdaten wd;

    public static void main(String[] args)
    {
        WetterdatenGUI gui = new WetterdatenGUI();
        gui.init();
    }

    public void init()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new BorderLayout());
        northPanel = new JPanel(new BorderLayout());
        midPanel = new JPanel(new BorderLayout());
        southPanel = new JPanel(new BorderLayout());

        wetterdatenText = new JLabel("Wetterdaten");
        druckText = new JLabel("Luftdruck: ");
        temperaturText = new JLabel("Temperatur: ");
        feuchtText = new JLabel("Luftfeuchte: ");

        wd = new Wetterdaten(30, 80, 50);
        druckWert = new JLabel(String.valueOf(wd.getLuftdruck()));
        temperaturWert = new JLabel(String.valueOf(wd.getTemperatur()));
        feuchtWert = new JLabel(String.valueOf(wd.getLuftfeuchte()));

        northPanel.add(wetterdatenText);
        midPanel.add(BorderLayout.WEST, temperaturText);
        midPanel.add(BorderLayout.CENTER, druckText);
        midPanel.add(BorderLayout.EAST, feuchtText);
        southPanel.add(BorderLayout.WEST, temperaturWert);
        southPanel.add(BorderLayout.CENTER, druckWert);
        southPanel.add(BorderLayout.EAST, feuchtWert);

        panel.add(BorderLayout.NORTH, northPanel);
        panel.add(BorderLayout.SOUTH, southPanel);
        panel.add(BorderLayout.CENTER, midPanel);
        frame.getContentPane().add(panel);

        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
