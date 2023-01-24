package Wetterdienst;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class WetterdatenGUI implements Observierer{

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

    public JFrame frame;

    Wetterdaten concreteSubject;

    public WetterdatenGUI (Wetterdaten subject)
    {
        this.setConcreteSubject(subject);
        subject.addObserver(this);
        this.init();
    }

/*    public static void main(String[] args)
    {
        WetterdatenGUI gui = new WetterdatenGUI();
        gui.init();
    }*/

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

        //concreteSubject = new Wetterdaten(30, 80, 50);
        druckWert = new JLabel(String.valueOf(concreteSubject.getLuftdruck()));
        temperaturWert = new JLabel(String.valueOf(concreteSubject.getTemperatur()));
        feuchtWert = new JLabel(String.valueOf(concreteSubject.getLuftfeuchte()));

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

    public void setConcreteSubject(Wetterdaten concreteSubject) {
        this.concreteSubject = concreteSubject;
    }

    @Override
    public void update() {
        this.temperaturWert.setText(String.valueOf(concreteSubject.getTemperatur()));
        this.temperaturWert.repaint();
        this.druckWert.setText(String.valueOf(concreteSubject.getLuftdruck()));
        this.druckWert.repaint();
        this.feuchtWert.setText(String.valueOf(concreteSubject.getLuftfeuchte()));
        this.feuchtWert.repaint();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e)
        {
            System.out.println("Fehler beim Sleep");
        }
    }
}
