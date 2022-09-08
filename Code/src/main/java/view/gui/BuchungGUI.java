package view.gui;

import app.Carsharing;
import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.SimpleListComponent;
import model.buchung.Rabattaktion;
import model.fahrzeug.Fahrzeug;
import model.fahrzeug.Fahrzeugklasse;
import model.kunde.Kunde;
import model.standort.Mitarbeiter;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import util.enums.Colors;
import view.controller.BuchungController;
import view.controller.FahrzeugController;
import view.utils.GUIWindowComponent;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class BuchungGUI extends GUIWindowComponent {

    JPanel gui = new JPanel();

    public JTextField searchField;

    //Labels
    public JLabel fahrzeugLabel = new JLabel();

    public JLabel startLabel = new JLabel();
    public JLabel endLabel = new JLabel();
    public JLabel klasseLabel = new JLabel();
    public JLabel preisLabel = new JLabel();
    public JLabel kundeLabel = new JLabel();
    public JLabel mitarbeiterLabel = new JLabel();
    public JLabel rabattLabel = new JLabel();

    //TextFields
    public JComboBox<Fahrzeug> fahrzeugSelect = new JComboBox<>();
    UtilDateModel startTerminModel = new UtilDateModel();
    JDatePanelImpl startTerminPanel = new JDatePanelImpl(startTerminModel);
    public JDatePickerImpl startTerminPicker = new JDatePickerImpl(startTerminPanel);
    UtilDateModel endTerminModel = new UtilDateModel();
    JDatePanelImpl endTerminPanel = new JDatePanelImpl(endTerminModel);
    public JDatePickerImpl endTerminPicker = new JDatePickerImpl(endTerminPanel);
    public JComboBox<Kunde> kundeSelect = new JComboBox<>();
    public JComboBox<Mitarbeiter> mitarbeiterSelect = new JComboBox<>();
    public JComboBox<Rabattaktion> rabatteDropDown = new JComboBox<>();
    public ButtonElement mahnungButton;
    JTextField preisInput;
    JTextField klassenInput;



    BuchungController controller;
    Font buttonFont = new Font(Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);

    public SimpleListComponent buchungList;


    public BuchungGUI(JFrame frame){
        gui.setBackground(Colors.PINK_ROSE.getColor());
        gui.setLayout(new GridLayout(1,3));

        controller = new BuchungController(this);

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

        buchungList = SimpleListComponent.builder("BuchungListComp")
                .font(new Font(Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_MEDIUM))
                .selectionMode(ListSelectionModel.SINGLE_SELECTION)
                .build();

        buchungList.setListElements(controller.loadData());
        buchungList.addObserver(controller);


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
        leftComponentPanel.add(buchungList, BorderLayout.CENTER);
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

        JLabel bildLabel = new JLabel();

        ImageIcon icon = new ImageIcon(controller.getBild(task));
        icon = new ImageIcon(icon.getImage().getScaledInstance(
                (int) (Carsharing.config.FRAME_SIZE.x() * 0.35),
                (int) (Carsharing.config.FRAME_SIZE.y() * 0.35),
                BufferedImage.SCALE_SMOOTH));

        bildLabel.setIcon(icon);
        bildLabel.setHorizontalAlignment(JLabel.CENTER);
        bildLabel.setVerticalAlignment(JLabel.CENTER);

        returnPanel.add(bildLabel, BorderLayout.NORTH);


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
        JPanel rabattPanel = createPanel();
        JPanel mahnungenPanel = createPanel();

        JLabel herstellerTextLabel;
        JLabel modellTextLabel;
        JLabel startTextLabel;
        JLabel endTextLabel;
        JLabel klasseTextLabel;
        JLabel preisTextLabel;
        JLabel kundeTextLabel;
        JLabel mitarbeiterTextLabel;
        JLabel rabattTextLabel;

        if(task == 0){

            herstellerTextLabel = createLabel("Hersteller",  Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            fahrzeugLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            startTextLabel = createLabel("Starttermin", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            startLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            endTextLabel = createLabel("Endtermin", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            endLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            klasseTextLabel = createLabel("Klasse", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            klasseLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            preisTextLabel = createLabel("Preis", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            preisLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            kundeTextLabel = createLabel("Kunde", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            kundeLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            mitarbeiterTextLabel = createLabel("Mitarbeiter", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            mitarbeiterLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            rabattTextLabel = createLabel("Rabattaktion", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            rabattLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);

            mahnungButton = ButtonElement.builder("Button-Mahnung")
                    .buttonText("Mahnungen")
                    .type(ButtonElement.Type.BUTTON)
                    .build();

            mahnungButton.addObserver(controller);

            addComponents(herstellerTextLabel, fahrzeugLabel, statusPanel);
            addComponents(startTextLabel, startLabel, herstellerPanel);
            addComponents(endTextLabel, endLabel, modellPanel);
            addComponents(klasseTextLabel, klasseLabel, klassenPanel);
            addComponents(preisTextLabel, preisLabel, preisPanel);
            addComponents(kundeTextLabel, kundeLabel, baujahrPanel);
            addComponents(mitarbeiterTextLabel, mitarbeiterLabel, kilometerPanel);

            addComponents(rabattTextLabel, rabattLabel, rabattPanel);
            mahnungenPanel.add(mahnungButton);

        } else if (task == 1){

            herstellerTextLabel = createLabel("Fahrzeug",  Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            fahrzeugSelect = new JComboBox<>(controller.loadFahrzeugModel());
            modellTextLabel = createLabel("Standort", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            //standortDropDown = new JComboBox<>(Fahrzeugklasse.values());
            startTextLabel = createLabel("Starttermin", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);

            endTextLabel = createLabel("Endtermin", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);

            klasseTextLabel = createLabel("Klasse", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            klassenInput = new JTextField("Automatically", 10);
            preisTextLabel = createLabel("Preis", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            preisInput = new JTextField("Automatically", 10);
            kundeTextLabel = createLabel("Kunde", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            kundeSelect = new JComboBox<>(controller.loadKundeModel());
            mitarbeiterTextLabel = createLabel("Mitarbeiter", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            mitarbeiterSelect = new JComboBox<>(controller.loadMitarbeiterModel());
            rabattTextLabel = createLabel("Rabattaktion", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            rabatteDropDown = new JComboBox<>(controller.loadRabattModel());
            mahnungButton = ButtonElement.builder("Button-Mahnung")
                    .buttonText("Mahnungen")
                    .type(ButtonElement.Type.BUTTON)
                    .build();

            mahnungButton.addObserver(controller);

            addComponents(herstellerTextLabel, fahrzeugSelect, statusPanel);
            //addComponents(modellTextLabel, standortDropDown, buchungPanel);
            addComponents(startTextLabel, startTerminPicker, herstellerPanel);
            addComponents(endTextLabel, endTerminPicker, modellPanel);
            addComponents(klasseTextLabel, klassenInput, klassenPanel);
            addComponents(preisTextLabel, preisInput, preisPanel);
            addComponents(kundeTextLabel, kundeSelect, baujahrPanel);
            addComponents(mitarbeiterTextLabel, mitarbeiterSelect, kilometerPanel);

            addComponents(rabattTextLabel, rabatteDropDown, rabattPanel);
            mahnungenPanel.add(new JLabel());

        } else if (task == 2){

            herstellerTextLabel = createLabel("Fahrzeug",  Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            fahrzeugSelect = new JComboBox<>(controller.loadFahrzeugModel());
            modellTextLabel = createLabel("Standort", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            //standortDropDown = new JComboBox<>(Fahrzeugklasse.values());
            startTextLabel = createLabel("Starttermin", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);

            endTextLabel = createLabel("Endtermin", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);

            klasseTextLabel = createLabel("Klasse", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            klassenInput = new JTextField("Automatisch übernommen", 15);
            klassenInput.setEditable(false);
            preisTextLabel = createLabel("Preis", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            preisInput = new JTextField("Automatisch berechnet", 15);
            preisInput.setEditable(false);
            kundeTextLabel = createLabel("Kunde", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            kundeSelect = new JComboBox<>(controller.loadKundeModel());
            mitarbeiterTextLabel = createLabel("Mitarbeiter", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            mitarbeiterSelect = new JComboBox<>(controller.loadMitarbeiterModel());
            rabattTextLabel = createLabel("Rabattaktion", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            rabattLabel = createLabel(controller.loadRabattBeschreibung(), Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            mahnungButton = ButtonElement.builder("Button-Mahnung")
                    .buttonText("Mahnungen")
                    .type(ButtonElement.Type.BUTTON)
                    .build();

            mahnungButton.addObserver(controller);

            addComponents(herstellerTextLabel, fahrzeugSelect, statusPanel);
            //addComponents(modellTextLabel, standortDropDown, buchungPanel);
            addComponents(startTextLabel, startTerminPicker, herstellerPanel);
            addComponents(endTextLabel, endTerminPicker, modellPanel);
            addComponents(klasseTextLabel, klassenInput, klassenPanel);
            addComponents(preisTextLabel, preisInput, preisPanel);
            addComponents(kundeTextLabel, kundeSelect, baujahrPanel);
            addComponents(mitarbeiterTextLabel, mitarbeiterSelect, kilometerPanel);

            addComponents(rabattTextLabel, rabattLabel, rabattPanel);
            mahnungenPanel.add(new JLabel());

        }

        JPanel layoutPanel1 = createPanel(statusPanel, BorderLayout.EAST);
        JPanel layoutPanel2 = createPanel(buchungPanel, BorderLayout.WEST);
        JPanel layoutPanel3 = createPanel(herstellerPanel, BorderLayout.EAST);
        JPanel layoutPanel4 = createPanel(modellPanel, BorderLayout.WEST);
        JPanel layoutPanel5 = createPanel(klassenPanel, BorderLayout.EAST);
        JPanel layoutPanel6 = createPanel(preisPanel, BorderLayout.WEST);
        JPanel layoutPanel7 = createPanel(baujahrPanel, BorderLayout.EAST);
        JPanel layoutPanel8 = createPanel(kilometerPanel, BorderLayout.WEST);
        JPanel layoutPanel9 = createPanel(rabattPanel, BorderLayout.EAST);
        JPanel layoutPanel10 = createPanel(mahnungenPanel, BorderLayout.WEST);

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

    public JPanel getGui(){
        return gui;
    }
}
