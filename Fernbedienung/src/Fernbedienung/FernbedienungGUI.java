package Fernbedienung;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FernbedienungGUI
{
    private JLabel einText;
    private JLabel ausText;

    private JProgressBar progressBar;

    private JButton einEinsButton;
    private JButton einZweiButton;
    private JButton einDreiButton;
    private JButton einVierButton;
    private JButton einFuenfButton;
    private JButton einSechsButton;
    private JButton einSiebenButton;

    private JButton ausEinsButton;
    private JButton ausZweiButton;
    private JButton ausDreiButton;
    private JButton ausVierButton;
    private JButton ausFuenfButton;
    private JButton ausSechsButton;
    private JButton ausSiebenButton;

    private JButton undoButton;
    private JButton redoButton;

    private JPanel gridPanel;
    private JPanel borderPanel;
    private JPanel flowPanel;

    private JFrame frame;

    private Fernbdienung fernbdienung;

    public FernbedienungGUI(Fernbdienung fernbdienung)
    {
        this.fernbdienung = fernbdienung;
        this.init();
    }

    private void init()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gridPanel = new JPanel(new GridLayout(8, 2));
        borderPanel = new JPanel(new BorderLayout());
        flowPanel = new JPanel(new FlowLayout());

        einText = new JLabel("An");
        einText.setHorizontalAlignment(SwingConstants.CENTER);
        ausText = new JLabel("Aus");
        ausText.setHorizontalAlignment(SwingConstants.CENTER);

        progressBar = new JProgressBar();

        einEinsButton = new JButton("1");
        einZweiButton = new JButton("2");
        einDreiButton = new JButton("3");
        einVierButton = new JButton("4");
        einFuenfButton = new JButton("5");
        einSechsButton = new JButton("6");
        einSiebenButton = new JButton("7");

        ausEinsButton = new JButton("1");
        ausZweiButton = new JButton("2");
        ausDreiButton = new JButton("3");
        ausVierButton = new JButton("4");
        ausFuenfButton = new JButton("5");
        ausSechsButton = new JButton("6");
        ausSiebenButton = new JButton("7");

        redoButton = new JButton("REDO");
        undoButton = new JButton("UNDO");

        gridPanel.add(einText, 0);
        gridPanel.add(ausText, 1);
        gridPanel.add(einEinsButton, 2);
        gridPanel.add(ausEinsButton, 3);
        gridPanel.add(einZweiButton, 4);
        gridPanel.add(ausZweiButton, 5);
        gridPanel.add(einDreiButton, 6);
        gridPanel.add(ausDreiButton, 7);
        gridPanel.add(einVierButton, 8);
        gridPanel.add(ausVierButton, 9);
        gridPanel.add(einFuenfButton, 10);
        gridPanel.add(ausFuenfButton, 11);
        gridPanel.add(einSechsButton, 12);
        gridPanel.add(ausSechsButton, 13);
        gridPanel.add(einSiebenButton, 14);
        gridPanel.add(ausSiebenButton, 15);

        flowPanel.add(undoButton);
        flowPanel.add(redoButton);

        borderPanel.add(BorderLayout.CENTER, gridPanel);
        borderPanel.add(BorderLayout.NORTH, progressBar);
        borderPanel.add(BorderLayout.SOUTH, flowPanel);
        //borderPanel.add(BorderLayout.NORTH, ladebalken);
        frame.getContentPane().add(borderPanel);

        einEinsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fernbdienung.commandAusfuehren(true, 0);
            }
        });
        einZweiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fernbdienung.commandAusfuehren(true, 1);
            }
        });
        einDreiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fernbdienung.commandAusfuehren(true, 2);
            }
        });
        einVierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fernbdienung.commandAusfuehren(true, 3);
            }
        });
        einFuenfButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fernbdienung.commandAusfuehren(true, 4);
            }
        });
        einSechsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fernbdienung.commandAusfuehren(true, 5);
            }
        });
        einSiebenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fernbdienung.commandAusfuehren(true, 6);
            }
        });

        ausEinsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fernbdienung.commandAusfuehren(false, 0);
            }
        });
        ausZweiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fernbdienung.commandAusfuehren(false, 1);
            }
        });
        ausDreiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fernbdienung.commandAusfuehren(false, 2);
            }
        });
        ausVierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fernbdienung.commandAusfuehren(false, 3);
            }
        });
        ausFuenfButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fernbdienung.commandAusfuehren(false, 4);
            }
        });
        ausSechsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fernbdienung.commandAusfuehren(false, 5);
            }
        });
        ausSiebenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fernbdienung.commandAusfuehren(false, 6);
            }
        });

        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
