package view.gui;

import view.utils.GUIWindowComponent;

import javax.swing.*;
import java.awt.*;

public class KundeGUI extends GUIWindowComponent {

    JPanel gui = new JPanel();

    Color paleVioletRed = new Color(222,99,154);
    Color cadillacPink = new Color(227,136,177);
    Color pinkRose = new Color(215,166,179);
    Color pinkMercury = new Color(241, 226, 226);
    Color smokeyGrey = new Color(112,112,112);

    public KundeGUI(JFrame frame){
        JLabel test = new JLabel("Kunden");
        gui.add(test);
    }

    public JPanel getGui(){
        return gui;
    }
}
