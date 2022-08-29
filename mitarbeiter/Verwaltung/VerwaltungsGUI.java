package Verwaltung;

import mitarbeiter.Mitarbeiter;

import javax.swing.*;

import java.awt.*;

public class VerwaltungsGUI {
    JComboBox menu;

    JButton neuVerwaltung;
    JButton deleteVerwaltung;
    JButton neuMitarbeiter;
    JButton deleteMitarbeiter;
    JButton verschiebeMitarbeiter;

    JTextField search;

    JList sideMenu;

    JLabel infoText;
    JLabel mitarbeiterText;
    JLabel nameVerwaltungText;
    JLabel nameLeiterText;
    JLabel kostenText;
    JLabel nameFirmaText;

    JTable mitarbeiterTabelle;

    JFrame frame;

    JPanel panelNorth;
    JPanel panelWest;
    JPanel panelRest;
    JPanel panelRestNorth;
    JPanel panelNorthEast;

    Unternehmensverwaltung verwaltung = new Unternehmensverwaltung();


    public static void main(String[] args)
    {
        VerwaltungsGUI gui = new VerwaltungsGUI();
        gui.init();
    }

    public void init()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] menuList = {"Mitarbeiter", "Verwaltung"};
        menu = new JComboBox(menuList);

        neuVerwaltung = new JButton("Neu");
        deleteVerwaltung = new JButton("Löschen");
        neuMitarbeiter = new JButton("Neu");
        deleteMitarbeiter = new JButton("Löschen");
        verschiebeMitarbeiter = new JButton("Verschieben");

        search = new JTextField("Suche", 1);

        sideMenu = new JList<JButton>();

        nameFirmaText = new JLabel("Aix-Car Mitarbeiterverwaltung");
        infoText = new JLabel("Informationen");
        mitarbeiterText = new JLabel("Mitarbeiter");
        nameVerwaltungText = new JLabel();
        nameLeiterText = new JLabel();
        kostenText = new JLabel();

        mitarbeiterTabelle = new JTable();

        panelNorth = new JPanel(new BorderLayout());
        panelWest = new JPanel();
        panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));
        panelRest = new JPanel(new BorderLayout());
        panelRestNorth = new JPanel(new BorderLayout());
        panelNorthEast = new JPanel(new BorderLayout());

        panelNorthEast.add(BorderLayout.WEST, neuVerwaltung);
        panelNorthEast.add(BorderLayout.EAST, deleteVerwaltung);

        panelNorth.add(BorderLayout.WEST, nameFirmaText);
        panelNorth.add(BorderLayout.EAST, panelNorthEast);
        panelNorth.add(menu);

        panelRestNorth.add(kostenText);
        panelRestNorth.add(nameLeiterText);
        panelRestNorth.add(nameVerwaltungText);
        panelRestNorth.add(infoText);
        panelRestNorth.add(mitarbeiterText);
        panelRestNorth.add(neuMitarbeiter);
        panelRestNorth.add(verschiebeMitarbeiter);
        panelRestNorth.add(deleteMitarbeiter);

        panelWest.add(search);
        panelWest.add(sideMenu);

        panelRest.add(BorderLayout.NORTH, panelRestNorth);
        panelRest.add(mitarbeiterTabelle);

        frame.getContentPane().add(panelRest);
        frame.getContentPane().add(BorderLayout.NORTH, panelNorth);
        frame.getContentPane().add(BorderLayout.WEST, panelWest);

        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
