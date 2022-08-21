package view.gui;

import app.Carsharing;
import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.SimpleListComponent;
import util.enums.Colors;
import view.controller.FahrzeugController;
import view.utils.GUIWindowComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FahrzeugGUI extends GUIWindowComponent {

    JPanel gui = new JPanel();

    JPanel leftComponentPanel = new JPanel();
    JPanel rightComponentPanel = new JPanel();

    FahrzeugController controller;

    Font buttonFont = new Font(Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);

    public JLabel statusLabel = new JLabel();
    public JLabel buchungLabel = new JLabel();
    public JLabel herstellerLabel = new JLabel();
    public JLabel modellLabel = new JLabel();
    public JLabel klasseLabel = new JLabel();
    public JLabel preisLabel = new JLabel();
    public JLabel baujahrLabel = new JLabel();
    public JLabel kilometerLabel = new JLabel();

    public FahrzeugGUI(JFrame frame){
        gui.setBackground(Colors.PINK_ROSE.getColor());
        gui.setLayout(new GridLayout(1,3));

        controller = new FahrzeugController(this);


        createListComponent();
        createDetailComponent();
    }

    private void createListComponent() {

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

        SimpleListComponent fahrzeugList = SimpleListComponent.builder("FahrzeugListComp")
                .font(new Font(Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_MEDIUM))
                .selectionMode(ListSelectionModel.SINGLE_SELECTION)
                .build();

        fahrzeugList.setListElements(controller.loadData());
        fahrzeugList.addObserver(controller);


        ButtonElement anlegenButton = ButtonElement.builder("BTN-AST")
                .buttonText("Anlegen")
                .type(ButtonElement.Type.BUTTON)
                .font(buttonFont)
                .build();

        anlegenButton.addObserver(controller);

        ButtonElement filterButton = ButtonElement.builder("BTN-FST")
                .buttonText("Filter")
                .type(ButtonElement.Type.BUTTON)
                .font(buttonFont)
                .build();

        ButtonElement createButton = ButtonElement.builder("BTN-CST")
                .buttonText("Create")
                .type(ButtonElement.Type.BUTTON)
                .font(buttonFont)
                .build();

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

    private void createDetailComponent(){

        String[] placeholderDropDown = {"Placeholder 1" , "Placeholder 2", "Placeholder 3"};

        rightComponentPanel.setBackground(Colors.PINK_ROSE.getColor());
        rightComponentPanel.setLayout(new BorderLayout());
        rightComponentPanel.setVisible(false);

        JLabel mapLabel = new JLabel();

        ImageIcon icon = new ImageIcon("src\\main\\resources\\map.PNG");
        icon = new ImageIcon(icon.getImage().getScaledInstance(
                (int) (Carsharing.config.FRAME_SIZE.x() * 0.35),
                (int) (Carsharing.config.FRAME_SIZE.y() * 0.35),
                BufferedImage.SCALE_SMOOTH));

        mapLabel.setIcon(icon);
        mapLabel.setHorizontalAlignment(JLabel.CENTER);
        mapLabel.setVerticalAlignment(JLabel.CENTER);

        rightComponentPanel.add(mapLabel, BorderLayout.NORTH);

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

        JLabel statusTextLabel = createLabel("Status",  Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
        statusLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
        JLabel buchungTextLabel = createLabel("Buchung", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
        buchungLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
        JLabel herstellerTextLabel = createLabel("Hersteller", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
        herstellerLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
        JLabel modellTextLabel = createLabel("Model", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
        modellLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
        JLabel klasseTextLabel = createLabel("Klasse", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
        klasseLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
        JLabel preisTextLabel = createLabel("Preis", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
        preisLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
        JLabel baujahrTextLabel = createLabel("Baujahr", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
        baujahrLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
        JLabel kilometerTextLabel = createLabel("Kilometerstand", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
        kilometerLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
        JComboBox<String> reifenDropDown = new JComboBox<>(placeholderDropDown);
        JComboBox<String> ausruestungDropDown = new JComboBox<>(placeholderDropDown);

        addLabels(statusTextLabel, statusLabel, statusPanel);
        addLabels(buchungTextLabel, buchungLabel, buchungPanel);
        addLabels(herstellerTextLabel, herstellerLabel, herstellerPanel);
        addLabels(modellTextLabel, modellLabel, modellPanel);
        addLabels(klasseTextLabel, klasseLabel, klassenPanel);
        addLabels(preisTextLabel, preisLabel, preisPanel);
        addLabels(baujahrTextLabel, baujahrLabel, baujahrPanel);
        addLabels(kilometerTextLabel, kilometerLabel, kilometerPanel);
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

        rightComponentPanel.add(panelPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Colors.PINK_ROSE.getColor());
        buttonPanel.setLayout(new GridLayout(1,7));

        JLabel fillLabel1 = new JLabel(" ");
        JLabel fillLabel2 = new JLabel(" ");
        JLabel fillLabel3 = new JLabel(" ");
        JLabel fillLabel4 = new JLabel(" ");
        JLabel fillLabel5 = new JLabel(" ");

        ButtonElement bearbeitenButton = ButtonElement.builder("BTN-BAR")
                .buttonText("Bearbeiten")
                .type(ButtonElement.Type.BUTTON)
                .build();

        ButtonElement loeschenButton = ButtonElement.builder("BTN-DEL")
                .buttonText("Löschen")
                .type(ButtonElement.Type.BUTTON)
                .build();

        buttonPanel.add(fillLabel1);
        buttonPanel.add(bearbeitenButton);
        buttonPanel.add(fillLabel2);
        buttonPanel.add(fillLabel3);
        buttonPanel.add(fillLabel4);
        buttonPanel.add(loeschenButton);
        buttonPanel.add(fillLabel5);

        rightComponentPanel.add(buttonPanel, BorderLayout.SOUTH);

        gui.add(rightComponentPanel);
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

    private void addLabels(JLabel label1, JLabel label2, JPanel panel){
        panel.add(label1);
        panel.add(label2);
    }

    public void setRightSiteVisible(){
        rightComponentPanel.setVisible(true);
    }

    public void setRightSiteInvisible(){
        rightComponentPanel.setVisible(false);
    }

    public void render(){
        //to-do
    }




}
