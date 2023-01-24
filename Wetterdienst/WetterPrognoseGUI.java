package Wetterdienst;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class WetterPrognoseGUI implements Observierer{

    private JLabel wetterPrognoseText;
    private JLabel wetterPrognoseWert;

    public JFrame frame;

    private WetterPrognose concreteSubject;

    public WetterPrognoseGUI(WetterPrognose subject)
    {
        this.setConcreteSubject(subject);
        subject.addObserver(this);
        this.init();
    }

    public void setConcreteSubject(WetterPrognose concreteSubject) {
        this.concreteSubject = concreteSubject;
    }

    public WetterPrognose getConcreteSubject()
    {
        return this.concreteSubject;
    }

    public void init()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        wetterPrognoseText = new JLabel("Wetter Prognose");
        wetterPrognoseWert = new JLabel("bla");
        wetterPrognoseWert.setVisible(true);

/*
        panel = new JPanel(new BorderLayout());

*/
        frame.add(BorderLayout.NORTH, wetterPrognoseText);
        frame.add(BorderLayout.SOUTH, wetterPrognoseWert);

//        frame.getContentPane().add(panel);

        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void update()
    {
        this.wetterPrognoseWert.setText(concreteSubject.getBesserung());// = new JLabel(concreteSubject.getBesserung());
        this.wetterPrognoseWert.repaint();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e)
        {
            System.out.println("Fehler beim Sleep");
        }
    }
}
