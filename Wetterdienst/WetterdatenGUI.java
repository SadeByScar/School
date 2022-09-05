package Wetterdienst;

import javax.swing.*;

public class WetterdatenGUI {

    private JLabel wetterdatenText;

    private JFrame frame;

    public static void main(String[] args)
    {
        WetterdatenGUI gui = new WetterdatenGUI();
        gui.init();
    }

    public void init()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        wetterdatenText = new JLabel("Wetterdaten");
    }
}
