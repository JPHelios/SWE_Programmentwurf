package view.gui;

import app.Carsharing;
import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.SimpleListComponent;
import util.enums.Colors;
import view.controller.KundeController;
import view.utils.GUIWindowComponent;

import javax.swing.*;
import java.awt.*;

public class KundeGUI extends GUIWindowComponent {

    JPanel gui = new JPanel();
    KundeController controller;
    Font buttonFont = new Font(Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);

    public JTextField searchField;
    public SimpleListComponent kundeList;


    public KundeGUI(JFrame frame){
        gui.setBackground(Colors.PINK_ROSE.getColor());
        gui.setLayout(new GridLayout(1,3));

        controller = new KundeController(this);

        createLeftSide();
        createRightSide();
    }

    public void createRightSide(JPanel panel){
        gui.remove(1);
        gui.add(panel);
    }

    public void createRightSide(){
        JPanel placeholder = new JPanel();
        placeholder.setBackground(Colors.PINK_ROSE.getColor());

        gui.add(placeholder);
    }

    private void createLeftSide() {

        JPanel leftComponentPanel = new JPanel();
        leftComponentPanel.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Colors.PINK_ROSE.getColor());
        buttonPanel.setLayout(new BorderLayout());

        JPanel buttonFilterPanel = new JPanel();
        buttonFilterPanel.setBackground(Colors.PINK_ROSE.getColor());
        buttonFilterPanel.setLayout(new GridLayout(1, 2));

        JPanel createPanel = new JPanel();
        createPanel.setLayout(new BorderLayout());
        createPanel.setBackground(Colors.PINK_ROSE.getColor());

        kundeList = SimpleListComponent.builder("KundeListComp")
                .font(new Font(Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_MEDIUM))
                .selectionMode(ListSelectionModel.SINGLE_SELECTION)
                .build();

        kundeList.setListElements(controller.loadData());
        kundeList.addObserver(controller);

        ButtonElement filterButton = ButtonElement.builder("Button-Filter")
                .buttonText("Filter")
                .type(ButtonElement.Type.BUTTON)
                .font(buttonFont)
                .build();

        filterButton.addObserver(controller);

        searchField = new JTextField("", 7);

        buttonFilterPanel.add(searchField);
        buttonFilterPanel.add(filterButton);

        buttonPanel.add(buttonFilterPanel, BorderLayout.WEST);
        buttonPanel.add(new JLabel(" "), BorderLayout.EAST);

        createPanel.add(new JLabel(" "), BorderLayout.WEST);

        leftComponentPanel.add(buttonPanel, BorderLayout.NORTH);
        leftComponentPanel.add(kundeList, BorderLayout.CENTER);
        leftComponentPanel.add(createPanel, BorderLayout.SOUTH);

        gui.add(leftComponentPanel);
    }

    public JPanel getGui(){
        return gui;
    }
}
