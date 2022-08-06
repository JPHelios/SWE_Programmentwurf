package view.gui;

import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.SimpleListComponent;
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
        gui.setBackground(pinkRose);
        gui.setLayout(new GridLayout(1,3));

        JPanel leftComponentPanel = new JPanel();
        leftComponentPanel.setLayout(new BorderLayout());

        JLabel rightComponentLabel = new JLabel("Placeholder");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(pinkRose);
        buttonPanel.setLayout(new BorderLayout());

        JPanel buttonFilterPanel = new JPanel();
        buttonFilterPanel.setBackground(pinkRose);
        buttonFilterPanel.setLayout(new GridLayout(1,2));

        JPanel createPanel = new JPanel();
        createPanel.setLayout(new BorderLayout());
        createPanel.setBackground(pinkRose);

        SimpleListComponent standortList = SimpleListComponent.builder("STLC")
                .font(new Font("Arial", Font.PLAIN, 25))
                .selectionMode(ListSelectionModel.SINGLE_SELECTION)
                .build();

        ButtonElement anlegenButton = ButtonElement.builder("BTN-AST")
                .buttonText("Anlegen")
                .type(ButtonElement.Type.BUTTON)
                .build();

        ButtonElement filterButton = ButtonElement.builder("BTN-FST")
                .buttonText("Filter")
                .type(ButtonElement.Type.BUTTON)
                .build();

        ButtonElement createButton = ButtonElement.builder("BTN-CST")
                .buttonText("Create")
                .type(ButtonElement.Type.BUTTON)
                .build();

        JTextField searchField = new JTextField();
        searchField.setText("Search");

        buttonFilterPanel.add(searchField);
        buttonFilterPanel.add(filterButton);

        buttonPanel.add(buttonFilterPanel, BorderLayout.WEST);
        buttonPanel.add(createButton, BorderLayout.EAST);

        createPanel.add(anlegenButton, BorderLayout.WEST);

        leftComponentPanel.add(buttonPanel, BorderLayout.NORTH);
        leftComponentPanel.add(standortList, BorderLayout.CENTER);
        leftComponentPanel.add(createPanel, BorderLayout.SOUTH);

        rightComponentLabel.setHorizontalAlignment(JLabel.CENTER);
        rightComponentLabel.setVerticalAlignment(JLabel.CENTER);

        gui.add(leftComponentPanel);
        gui.add(rightComponentLabel);
    }

    public JPanel getGui(){
        return gui;
    }
}
