package view.gui;

import de.dhbwka.swe.utils.gui.SimpleListComponent;
import view.utils.GUIWindowComponent;

import javax.swing.*;
import java.awt.*;

public class FahrzeugGUI extends GUIWindowComponent {

    JPanel gui = new JPanel();

    Color paleVioletRed = new Color(222,99,154);
    Color cadillacPink = new Color(227,136,177);
    Color pinkRose = new Color(215,166,179);
    Color pinkMercury = new Color(241, 226, 226);
    Color smokeyGrey = new Color(112,112,112);

    public FahrzeugGUI(JFrame frame){
        JLabel test = new JLabel("Fahrzeuge");

        JPanel listComponent = new JPanel();
        JPanel detailComponent = new JPanel();

        SimpleListComponent listComp = SimpleListComponent.builder("SLC")
                .font(new Font("Arial", Font.PLAIN, 25))
                .selectionMode(ListSelectionModel.SINGLE_SELECTION)
                .build();


        gui.add(test);

        gui.add(listComp);
    }

    public JPanel getGui(){
        return gui;
    }
}
