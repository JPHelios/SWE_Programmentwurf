package view.gui;

import de.dhbwka.swe.utils.gui.AttributeElement;
import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.SimpleListComponent;
import de.dhbwka.swe.utils.util.CSVReader;
import util.enums.Colors;
import view.utils.GUIWindowComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class KundeGUI extends GUIWindowComponent {

    JPanel gui = new JPanel();

    public KundeGUI(JFrame frame){
        gui.setBackground(Colors.PINK_ROSE.getColor());
        gui.setLayout(new GridLayout(1,3));

        JPanel leftComponentPanel = new JPanel();
        leftComponentPanel.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Colors.PINK_ROSE.getColor());
        buttonPanel.setLayout(new BorderLayout());

        JPanel buttonFilterPanel = new JPanel();
        buttonFilterPanel.setBackground(Colors.PINK_ROSE.getColor());
        buttonFilterPanel.setLayout(new GridLayout(1,2));

        JPanel createPanel = new JPanel();
        createPanel.setLayout(new BorderLayout());
        createPanel.setBackground(Colors.PINK_ROSE.getColor());

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

        //######################################################
        JPanel rightComponentPanel = new JPanel();



        gui.add(leftComponentPanel);
        gui.add(rightComponentPanel);
    }

    public JPanel getGui(){
        return gui;
    }
}
