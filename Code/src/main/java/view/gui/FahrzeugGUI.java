package view.gui;

import app.Carsharing;
import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.SimpleListComponent;
import model.fahrzeug.Fahrzeugklasse;
import util.enums.Colors;
import view.controller.FahrzeugController;
import view.utils.GUIWindowComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FahrzeugGUI extends GUIWindowComponent {

    JPanel gui = new JPanel();

    public JPanel leftComponentPanel = new JPanel();
    public JPanel rightComponentPanelDetails = new JPanel();
    public JPanel rightComponentPanelInput = new JPanel();


    public JLabel statusLabel = new JLabel();
    public JLabel buchungLabel = new JLabel();
    public JLabel herstellerLabel = new JLabel();
    public JLabel modellLabel = new JLabel();
    public JLabel klasseLabel = new JLabel();
    public JLabel preisLabel = new JLabel();
    public JLabel baujahrLabel = new JLabel();
    public JLabel kilometerLabel = new JLabel();

    FahrzeugController controller;
    Font buttonFont = new Font(Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);

    SimpleListComponent fahrzeugList;


    public FahrzeugGUI(JFrame frame){
        gui.setBackground(Colors.PINK_ROSE.getColor());
        gui.setLayout(new GridLayout(1,3));

        controller = new FahrzeugController(this);

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

        fahrzeugList = SimpleListComponent.builder("FahrzeugListComp")
                .font(new Font(Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_MEDIUM))
                .selectionMode(ListSelectionModel.SINGLE_SELECTION)
                .build();

        fahrzeugList.setListElements(controller.loadData());
        fahrzeugList.addObserver(controller);


        ButtonElement anlegenButton = ButtonElement.builder("Button-Anlegen")
                .buttonText("Anlegen")
                .type(ButtonElement.Type.BUTTON)
                .font(buttonFont)
                .build();

        anlegenButton.addObserver(controller);

        ButtonElement filterButton = ButtonElement.builder("Button-Filter")
                .buttonText("Filter")
                .type(ButtonElement.Type.BUTTON)
                .font(buttonFont)
                .build();

        filterButton.addObserver(controller);

        ButtonElement createButton = ButtonElement.builder("Button-Create")
                .buttonText("Create")
                .type(ButtonElement.Type.BUTTON)
                .font(buttonFont)
                .build();

        createButton.addObserver(controller);

        JTextField searchField = new JTextField();
        searchField.setText("Search");

        buttonFilterPanel.add(searchField);
        buttonFilterPanel.add(filterButton);

        buttonPanel.add(buttonFilterPanel, BorderLayout.WEST);
        buttonPanel.add(createButton, BorderLayout.EAST);

        createPanel.add(anlegenButton, BorderLayout.WEST);

        leftComponentPanel.add(buttonPanel, BorderLayout.NORTH);
        leftComponentPanel.add(fahrzeugList, BorderLayout.CENTER);
        leftComponentPanel.add(createPanel, BorderLayout.SOUTH);

        gui.add(leftComponentPanel);
    }

    public JPanel createRightSidePanel(int task){

        if(task == -1){

            JPanel clearPanel = new JPanel();
            clearPanel.setBackground(Colors.PINK_ROSE.getColor());
            clearPanel.setVisible(false);
            return clearPanel;

        }

        String[] placeholderDropDown = {"Placeholder 1" , "Placeholder 2", "Placeholder 3"};

        JPanel returnPanel = new JPanel();
        returnPanel.setBackground(Colors.PINK_ROSE.getColor());
        returnPanel.setLayout(new BorderLayout());
        returnPanel.setVisible(false);

        JLabel mapLabel = new JLabel();

        ImageIcon icon = new ImageIcon("src\\main\\resources\\map.PNG");
        icon = new ImageIcon(icon.getImage().getScaledInstance(
                (int) (Carsharing.config.FRAME_SIZE.x() * 0.35),
                (int) (Carsharing.config.FRAME_SIZE.y() * 0.35),
                BufferedImage.SCALE_SMOOTH));

        mapLabel.setIcon(icon);
        mapLabel.setHorizontalAlignment(JLabel.CENTER);
        mapLabel.setVerticalAlignment(JLabel.CENTER);

        returnPanel.add(mapLabel, BorderLayout.NORTH);

        JPanel panelPanel = new JPanel();
        panelPanel.setLayout(new GridLayout(5,2, 200,50));
        panelPanel.setBackground(Colors.PINK_ROSE.getColor());

        JPanel statusPanel = new JPanel();
        statusPanel.setBackground(Colors.PINK_ROSE.getColor());
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.Y_AXIS));

        JPanel buchungPanel = createPanel();
        JPanel herstellerPanel = createPanel();
        JPanel modellPanel = createPanel();
        JPanel klassenPanel = createPanel();
        JPanel preisPanel = createPanel();
        JPanel baujahrPanel = createPanel();
        JPanel kilometerPanel = createPanel();
        JPanel reifenPanel = createPanel();
        JPanel ausruestungPanel = createPanel();

        JLabel statusTextLabel = new JLabel();
        JLabel buchungTextLabel = new JLabel();
        JLabel herstellerTextLabel = new JLabel();
        JLabel modellTextLabel = new JLabel();
        JLabel klasseTextLabel = new JLabel();
        JLabel preisTextLabel = new JLabel();
        JLabel baujahrTextLabel = new JLabel();
        JLabel kilometerTextLabel = new JLabel();
        JComboBox<String> reifenDropDown = new JComboBox<>(placeholderDropDown);
        JComboBox<String> ausruestungDropDown = new JComboBox<>(placeholderDropDown);

        if(task == 0){

            statusTextLabel = createLabel("Status",  Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            statusLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            buchungTextLabel = createLabel("Buchung", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            buchungLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            herstellerTextLabel = createLabel("Hersteller", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            herstellerLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            modellTextLabel = createLabel("Model", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            modellLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            klasseTextLabel = createLabel("Klasse", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            klasseLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            preisTextLabel = createLabel("Preis", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            preisLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            baujahrTextLabel = createLabel("Baujahr", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            baujahrLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            kilometerTextLabel = createLabel("Kilometerstand", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            kilometerLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);

            addComponents(statusTextLabel, statusLabel, statusPanel);
            addComponents(buchungTextLabel, buchungLabel, buchungPanel);
            addComponents(herstellerTextLabel, herstellerLabel, herstellerPanel);
            addComponents(modellTextLabel, modellLabel, modellPanel);
            addComponents(klasseTextLabel, klasseLabel, klassenPanel);
            addComponents(preisTextLabel, preisLabel, preisPanel);
            addComponents(baujahrTextLabel, baujahrLabel, baujahrPanel);
            addComponents(kilometerTextLabel, kilometerLabel, kilometerPanel);

        } else if (task == 1){

            statusTextLabel = createLabel("Status",  Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            JTextField statusInput = new JTextField("Unbekannt", 10);
            statusInput.setEditable(false);
            buchungTextLabel = createLabel("Buchung", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            JTextField buchungInput = new JTextField("Unbekannt", 10);
            buchungInput.setEditable(false);
            herstellerTextLabel = createLabel("Hersteller", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            JTextField herstellerInput = new JTextField("", 10);
            modellTextLabel = createLabel("Model", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            JTextField modellInput = new JTextField("", 10);
            klasseTextLabel = createLabel("Klasse", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            JComboBox<Fahrzeugklasse> klassenDropDown = new JComboBox<>(Fahrzeugklasse.values());
            preisTextLabel = createLabel("Preis", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            JTextField preisInput = new JTextField("Automatically", 10);
            preisInput.setEditable(false);
            baujahrTextLabel = createLabel("Baujahr", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            JTextField bauhjahrInput = new JTextField("", 10);
            kilometerTextLabel = createLabel("Kilometer", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            JTextField kilometerInput = new JTextField("", 10);

            addComponents(statusTextLabel, statusInput, statusPanel);
            addComponents(buchungTextLabel, buchungInput, buchungPanel);
            addComponents(herstellerTextLabel, herstellerInput, herstellerPanel);
            addComponents(modellTextLabel, modellInput, modellPanel);
            addComponents(klasseTextLabel, klassenDropDown, klassenPanel);
            addComponents(preisTextLabel, preisInput, preisPanel);
            addComponents(baujahrTextLabel, bauhjahrInput, baujahrPanel);
            addComponents(kilometerTextLabel, kilometerInput, kilometerPanel);

        }

        reifenPanel.add(reifenDropDown);
        ausruestungPanel.add(ausruestungDropDown);

        JPanel layoutPanel1 = createPanel(statusPanel, BorderLayout.EAST);
        JPanel layoutPanel2 = createPanel(buchungPanel, BorderLayout.WEST);
        JPanel layoutPanel3 = createPanel(herstellerPanel, BorderLayout.EAST);
        JPanel layoutPanel4 = createPanel(modellPanel, BorderLayout.WEST);
        JPanel layoutPanel5 = createPanel(klassenPanel, BorderLayout.EAST);
        JPanel layoutPanel6 = createPanel(preisPanel, BorderLayout.WEST);
        JPanel layoutPanel7 = createPanel(baujahrPanel, BorderLayout.EAST);
        JPanel layoutPanel8 = createPanel(kilometerPanel, BorderLayout.WEST);
        JPanel layoutPanel9 = createPanel(reifenPanel, BorderLayout.EAST);
        JPanel layoutPanel10 = createPanel(ausruestungPanel, BorderLayout.WEST);

        panelPanel.add(layoutPanel1);
        panelPanel.add(layoutPanel2);
        panelPanel.add(layoutPanel3);
        panelPanel.add(layoutPanel4);
        panelPanel.add(layoutPanel5);
        panelPanel.add(layoutPanel6);
        panelPanel.add(layoutPanel7);
        panelPanel.add(layoutPanel8);
        panelPanel.add(layoutPanel9);
        panelPanel.add(layoutPanel10);

        returnPanel.add(panelPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Colors.PINK_ROSE.getColor());
        buttonPanel.setLayout(new GridLayout(1,7));

        JLabel fillLabel1 = new JLabel(" ");
        JLabel fillLabel2 = new JLabel(" ");
        JLabel fillLabel3 = new JLabel(" ");
        JLabel fillLabel4 = new JLabel(" ");
        JLabel fillLabel5 = new JLabel(" ");

        ButtonElement button1 = null;
        ButtonElement button2 = null;

        if(task == 0 ){
            button1 = ButtonElement.builder("BTN-BAR")
                    .buttonText("Bearbeiten")
                    .type(ButtonElement.Type.BUTTON)
                    .build();

            button2 = ButtonElement.builder("BTN-DEL")
                    .buttonText("Löschen")
                    .type(ButtonElement.Type.BUTTON)
                    .build();

        } else if (task == 1){
            button1 = ButtonElement.builder("Button-Save")
                    .buttonText("Speichern")
                    .type(ButtonElement.Type.BUTTON)
                    .build();

            button1.addObserver(controller);

            button2 = ButtonElement.builder("Button-Cancel")
                    .buttonText("Abbrechen")
                    .type(ButtonElement.Type.BUTTON)
                    .build();

            button2.addObserver(controller);
        }

        buttonPanel.add(fillLabel1);
        buttonPanel.add(button1);
        buttonPanel.add(fillLabel2);
        buttonPanel.add(fillLabel3);
        buttonPanel.add(fillLabel4);
        buttonPanel.add(button2);
        buttonPanel.add(fillLabel5);

        returnPanel.add(buttonPanel, BorderLayout.SOUTH);

        return returnPanel;
    }

    public JPanel getGui(){
        return gui;
    }

    private JPanel createPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(Colors.PINK_ROSE.getColor());
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        return panel;
    }

    private JPanel createPanel(JPanel panel2Add, String orientation){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Colors.PINK_ROSE.getColor());
        panel.add(panel2Add, orientation);

        return panel;
    }

    private JLabel createLabel(String text, String font, int fontType , int size){

        JLabel label = new JLabel(text);
        label.setFont(new Font(font, fontType, size));

        return label;
    }

    private void addComponents(JLabel label1, JLabel label2, JPanel panel){
        panel.add(label1);
        panel.add(label2);
    }

    private void addComponents(JLabel label, JTextField textField, JPanel panel){
        panel.add(label);
        panel.add(textField);
    }

    private void addComponents(JLabel label, JComboBox comboBox, JPanel panel){
        panel.add(label);
        panel.add(comboBox);
    }

    public void setRightSiteVisible(JPanel panel){
        panel.setVisible(true);
    }

    public void setRightSiteInvisible(JPanel panel){
        panel.setVisible(false);
    }

    public void clearListSelection(){
        fahrzeugList.clearSelection();
    }

}
