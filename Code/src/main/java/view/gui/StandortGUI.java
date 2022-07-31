package view.gui;

import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.SimpleListComponent;
import view.controller.StandortController;
import view.utils.GUIWindowComponent;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;

public class StandortGUI extends GUIWindowComponent {

    JPanel gui = new JPanel();

    StandortController controller = new StandortController();

    Color paleVioletRed = new Color(222,99,154);
    Color cadillacPink = new Color(227,136,177);
    Color pinkRose = new Color(215,166,179);
    Color pinkMercury = new Color(241, 226, 226);
    Color smokeyGrey = new Color(112,112,112);

    public StandortGUI(JFrame frame){
        gui.setBackground(pinkRose);
        gui.setLayout(new GridLayout(1,3));

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());

        JLabel mapLabel = new JLabel();

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
        filterButton.setSize((int) (buttonPanel.getWidth() * 0.3), (int) (buttonPanel.getHeight() * 0.8));

        ButtonElement createButton = ButtonElement.builder("BTN-CST")
                .buttonText("Create")
                .type(ButtonElement.Type.BUTTON)
                .build();

        JTextField searchField = new JTextField();
        searchField.setText("Search");
        searchField.setSize((int) (buttonPanel.getWidth() * 0.7), (int) (buttonPanel.getHeight() * 0.8));

        buttonFilterPanel.add(searchField);
        buttonFilterPanel.add(filterButton);

        buttonPanel.add(buttonFilterPanel, BorderLayout.WEST);
        buttonPanel.add(createButton, BorderLayout.EAST);

        createPanel.add(anlegenButton, BorderLayout.WEST);

        listPanel.add(buttonPanel, BorderLayout.NORTH);
        listPanel.add(standortList, BorderLayout.CENTER);
        listPanel.add(createPanel, BorderLayout.SOUTH);



        ImageIcon icon = new ImageIcon("src\\main\\resources\\map.PNG");
        icon = new ImageIcon(icon.getImage().getScaledInstance(600, 900, BufferedImage.SCALE_SMOOTH));

        mapLabel.setSize((int) (frame.getWidth() * 0.4), (int) (frame.getHeight() * 0.7));
        mapLabel.setIcon(icon);
        mapLabel.setHorizontalAlignment(JLabel.CENTER);
        mapLabel.setVerticalAlignment(JLabel.CENTER);

        gui.add(listPanel);
        gui.add(mapLabel);


    }

    public JPanel getGui(){
        return gui;
    }
}
