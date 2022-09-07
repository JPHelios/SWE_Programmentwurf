package view.gui;

import app.Carsharing;
import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.SimpleListComponent;
import model.fahrzeug.Fahrzeugklasse;
import util.enums.Colors;
import view.controller.StandortController;
import view.utils.GUIWindowComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class StandortGUI extends GUIWindowComponent {
    JPanel gui = new JPanel();

    StandortController controller;

    public SimpleListComponent standortList;
    public JTextField searchField;

    //Labels
    public JLabel adresseLabel = new JLabel();
    public JLabel buchungLabel = new JLabel();
    public JLabel plzLabel = new JLabel();
    public JLabel ortLabel = new JLabel();
    public JLabel plaetzeLabel = new JLabel();
    public JLabel saeulenLabel = new JLabel();
    public JLabel filialeLabel = new JLabel();
    public JLabel zeitenLabel = new JLabel();

    //TextFields

    public JTextField plaetzeInput = new JTextField();
    public JTextField saeulenInput = new JTextField();

    public JTextField kennzeichenInput = new JTextField();
    public JComboBox<Fahrzeugklasse> standortDropDown = new JComboBox<>();
    public JTextField herstellerInput = new JTextField();
    public JTextField modellInput = new JTextField();
    public JComboBox<Fahrzeugklasse> klassenDropDown = new JComboBox<>();
    public JTextField preisInput = new JTextField();
    public JTextField baujahrInput = new JTextField();
    public JTextField kilometerInput = new JTextField();

    Font buttonFont = new Font(Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);

    public StandortGUI(JFrame frame) {

        gui.setBackground(Colors.PINK_ROSE.getColor());
        gui.setLayout(new GridLayout(1, 3));

        controller = new StandortController(this);

        createLeftSide();
        createRightSide();

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

        standortList = SimpleListComponent.builder("StandortListComp")
                .font(new Font(Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_MEDIUM))
                .selectionMode(ListSelectionModel.SINGLE_SELECTION)
                .build();

        standortList.setListElements(controller.loadData());
        standortList.addObserver(controller);


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

        searchField = new JTextField("", 7);

        buttonFilterPanel.add(searchField);
        buttonFilterPanel.add(filterButton);

        buttonPanel.add(buttonFilterPanel, BorderLayout.WEST);
        buttonPanel.add(createButton, BorderLayout.EAST);

        createPanel.add(anlegenButton, BorderLayout.WEST);

        leftComponentPanel.add(buttonPanel, BorderLayout.NORTH);
        leftComponentPanel.add(standortList, BorderLayout.CENTER);
        leftComponentPanel.add(createPanel, BorderLayout.SOUTH);

        gui.add(leftComponentPanel);
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
        JPanel bottomPlaceholderPanel1 = createPanel();
        JPanel bottomPlaceholderPanel2 = createPanel();

        JLabel adresseTextLabel;
        JLabel buchungTextLabel;
        JLabel plzTextLabel;
        JLabel ortTextLabel;
        JLabel plaetzeTextLabel;
        JLabel ladesaeulenTextLabel;
        JLabel filialeTextLabel;
        JLabel zeitenTextLabel;
        JComboBox<String> reifenDropDown = new JComboBox<>(placeholderDropDown);
        ButtonElement ausruestungButton = ButtonElement.builder("Button-Ausruestung")
                .buttonText("Ausrüstung")
                .type(ButtonElement.Type.BUTTON)
                .build();

        ausruestungButton.addObserver(controller);

        if(task == 0){

            adresseTextLabel = createLabel("Straße, Nr.",  Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            adresseLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            buchungTextLabel = createLabel("", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            buchungLabel = createLabel("", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            plzTextLabel = createLabel("Postleitzahl", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            plzLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            ortTextLabel = createLabel("Ort", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            ortLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            plaetzeTextLabel = createLabel("Plätze", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            plaetzeLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            ladesaeulenTextLabel = createLabel("Ladesäulen", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            saeulenLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            filialeTextLabel = createLabel("Niederlassung", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            filialeLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            zeitenTextLabel = createLabel("Öffnungszeiten", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            zeitenLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);

            addComponents(adresseTextLabel, adresseLabel, statusPanel);
            addComponents(buchungTextLabel, buchungLabel, buchungPanel);
            addComponents(plzTextLabel, plzLabel, herstellerPanel);
            addComponents(ortTextLabel, ortLabel, modellPanel);
            addComponents(plaetzeTextLabel, plaetzeLabel, klassenPanel);
            addComponents(ladesaeulenTextLabel, saeulenLabel, preisPanel);
            addComponents(filialeTextLabel, filialeLabel, baujahrPanel);
            addComponents(zeitenTextLabel, zeitenLabel, kilometerPanel);

        } else if (task == 1){

            adresseTextLabel = createLabel("Kennzeichen",  Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            kennzeichenInput = new JTextField("", 10);
            buchungTextLabel = createLabel("Standort", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            standortDropDown = new JComboBox<>(Fahrzeugklasse.values());
            plzTextLabel = createLabel("Hersteller", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            herstellerInput = new JTextField("", 10);
            ortTextLabel = createLabel("Model", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            modellInput = new JTextField("", 10);
            plaetzeTextLabel = createLabel("Klasse", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            klassenDropDown = new JComboBox<>(Fahrzeugklasse.values());
            ladesaeulenTextLabel = createLabel("Preis", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            preisInput = new JTextField("Automatically", 10);
            filialeTextLabel = createLabel("Baujahr", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            baujahrInput = new JTextField("", 10);
            zeitenTextLabel = createLabel("Kilometer", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            kilometerInput = new JTextField("", 10);

            addComponents(adresseTextLabel, kennzeichenInput, statusPanel);
            addComponents(buchungTextLabel, standortDropDown, buchungPanel);
            addComponents(plzTextLabel, herstellerInput, herstellerPanel);
            addComponents(ortTextLabel, modellInput, modellPanel);
            addComponents(plaetzeTextLabel, klassenDropDown, klassenPanel);
            addComponents(ladesaeulenTextLabel, preisInput, preisPanel);
            addComponents(filialeTextLabel, baujahrInput, baujahrPanel);
            addComponents(zeitenTextLabel, kilometerInput, kilometerPanel);

        } else if (task == 2){

            adresseTextLabel = createLabel("Straße, Nr.",  Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            adresseLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            buchungTextLabel = createLabel("", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            buchungLabel = createLabel("", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            plzTextLabel = createLabel("Postleitzahl", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            plzLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            ortTextLabel = createLabel("Ort", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            ortLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            plaetzeTextLabel = createLabel("Plätze", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            plaetzeInput = new JTextField("", 10);
            ladesaeulenTextLabel = createLabel("Ladesäulen", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            saeulenInput = new JTextField("", 10);
            filialeTextLabel = createLabel("Niederlassung", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            filialeLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            zeitenTextLabel = createLabel("Öffnungszeiten", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            zeitenLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);

            addComponents(adresseTextLabel, adresseLabel, statusPanel);
            addComponents(buchungTextLabel, buchungLabel, buchungPanel);
            addComponents(plzTextLabel, plzLabel, herstellerPanel);
            addComponents(ortTextLabel, ortLabel, modellPanel);
            addComponents(plaetzeTextLabel, plaetzeInput, klassenPanel);
            addComponents(ladesaeulenTextLabel, saeulenInput, preisPanel);
            addComponents(filialeTextLabel, filialeLabel, baujahrPanel);
            addComponents(zeitenTextLabel, zeitenLabel, kilometerPanel);

        }

        bottomPlaceholderPanel1.add(new JLabel());
        bottomPlaceholderPanel2.add(new JLabel());

        JPanel layoutPanel1 = createPanel(statusPanel, BorderLayout.EAST);
        JPanel layoutPanel2 = createPanel(buchungPanel, BorderLayout.WEST);
        JPanel layoutPanel3 = createPanel(herstellerPanel, BorderLayout.EAST);
        JPanel layoutPanel4 = createPanel(modellPanel, BorderLayout.WEST);
        JPanel layoutPanel5 = createPanel(klassenPanel, BorderLayout.EAST);
        JPanel layoutPanel6 = createPanel(preisPanel, BorderLayout.WEST);
        JPanel layoutPanel7 = createPanel(baujahrPanel, BorderLayout.EAST);
        JPanel layoutPanel8 = createPanel(kilometerPanel, BorderLayout.WEST);
        JPanel layoutPanel9 = createPanel(bottomPlaceholderPanel1, BorderLayout.EAST);
        JPanel layoutPanel10 = createPanel(bottomPlaceholderPanel2, BorderLayout.WEST);

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

        if(task == 0){
            button1 = ButtonElement.builder("Button-Edit")
                    .buttonText("Bearbeiten")
                    .type(ButtonElement.Type.BUTTON)
                    .build();

            button1.addObserver(controller);

            button2 = ButtonElement.builder("Button-Loeschen")
                    .buttonText("Löschen")
                    .type(ButtonElement.Type.BUTTON)
                    .build();

            button2.addObserver(controller);

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
        } else if (task == 2){
            button1 = ButtonElement.builder("Button-Save-Edit")
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

    /*public void test(){


        ImageIcon icon = new ImageIcon("src\\main\\resources\\map.PNG");
        icon = new ImageIcon(icon.getImage().getScaledInstance(
                (int) (Carsharing.config.FRAME_SIZE.x() * 0.23),
                (int) (Carsharing.config.FRAME_SIZE.y() * 0.63),
                BufferedImage.SCALE_SMOOTH));

        mapLabel.setSize((int) (frame.getWidth() * 0.4), (int) (frame.getHeight() * 0.7));
        mapLabel.setIcon(icon);
        mapLabel.setHorizontalAlignment(JLabel.CENTER);
        mapLabel.setVerticalAlignment(JLabel.CENTER);

        gui.add(listPanel);
        gui.add(mapLabel);
    }*/

    public JPanel getGui(){
        return gui;
    }
}
