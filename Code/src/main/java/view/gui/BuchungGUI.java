package view.gui;

import app.Carsharing;
import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.SimpleListComponent;
import model.fahrzeug.Fahrzeugklasse;
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
    public JLabel statusLabel = new JLabel();
    public JLabel buchungLabel = new JLabel();
    public JLabel herstellerLabel = new JLabel();
    public JLabel modellLabel = new JLabel();
    public JLabel klasseLabel = new JLabel();
    public JLabel preisLabel = new JLabel();
    public JLabel baujahrLabel = new JLabel();
    public JLabel kilometerLabel = new JLabel();

    //TextFields
    public JTextField kennzeichenInput = new JTextField();
    public JComboBox<Fahrzeugklasse> standortDropDown = new JComboBox<>();
    public JTextField herstellerInput = new JTextField();
    public JTextField modellInput = new JTextField();
    public JComboBox<Fahrzeugklasse> klassenDropDown = new JComboBox<>();
    public JTextField preisInput = new JTextField();
    public JTextField baujahrInput = new JTextField();
    public JTextField kilometerInput = new JTextField();

    //FileChooser
    public JFileChooser img_chooser = new JFileChooser();


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


        img_chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        img_chooser.setMultiSelectionEnabled(true);
        img_chooser.setDialogTitle("Bilder Öffnen");
        img_chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        JLabel bildLabel = new JLabel();

        ImageIcon icon = new ImageIcon("src\\main\\resources\\map.PNG");
        icon = new ImageIcon(icon.getImage().getScaledInstance(
                (int) (Carsharing.config.FRAME_SIZE.x() * 0.35),
                (int) (Carsharing.config.FRAME_SIZE.y() * 0.35),
                BufferedImage.SCALE_SMOOTH));

        bildLabel.setIcon(icon);
        bildLabel.setHorizontalAlignment(JLabel.CENTER);
        bildLabel.setVerticalAlignment(JLabel.CENTER);
        bildLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                img_chooser.setFileFilter(new FileFilter() {

                    public String getDescription() {
                        return "Bilder (*.jpg / *.png)";
                    }

                    public boolean accept(File f) {
                        if (f.isDirectory()) {
                            return true;
                        } else {
                            String filename = f.getName().toLowerCase();
                            return filename.endsWith(".jpg") || filename.endsWith(".jpeg") ;
                        }
                    }
                });
                img_chooser.setCurrentDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator")+ "Pictures"));
                int approval = img_chooser.showOpenDialog(null);

                if(approval == JFileChooser.APPROVE_OPTION){
                    File selectedFile = img_chooser.getSelectedFile();
                    System.out.println("we selected: " + selectedFile);
                    //Carsharing.ef.createBild("", img_chooser.getSelectedFile().getName());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

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
        JPanel reifenPanel = createPanel();
        JPanel ausruestungPanel = createPanel();

        JLabel statusTextLabel;
        JLabel buchungTextLabel;
        JLabel herstellerTextLabel;
        JLabel modellTextLabel;
        JLabel klasseTextLabel;
        JLabel preisTextLabel;
        JLabel baujahrTextLabel;
        JLabel kilometerTextLabel;
        JComboBox<String> reifenDropDown = new JComboBox<>(placeholderDropDown);
        ButtonElement ausruestungButton = ButtonElement.builder("Button-Ausruestung")
                .buttonText("Ausrüstung")
                .type(ButtonElement.Type.BUTTON)
                .build();

        ausruestungButton.addObserver(controller);

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

            statusTextLabel = createLabel("Kennzeichen",  Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            kennzeichenInput = new JTextField("", 10);
            buchungTextLabel = createLabel("Standort", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            standortDropDown = new JComboBox<>(Fahrzeugklasse.values());
            herstellerTextLabel = createLabel("Hersteller", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            herstellerInput = new JTextField("", 10);
            modellTextLabel = createLabel("Model", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            modellInput = new JTextField("", 10);
            klasseTextLabel = createLabel("Klasse", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            klassenDropDown = new JComboBox<>(Fahrzeugklasse.values());
            preisTextLabel = createLabel("Preis", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            preisInput = new JTextField("Automatically", 10);
            baujahrTextLabel = createLabel("Baujahr", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            baujahrInput = new JTextField("", 10);
            kilometerTextLabel = createLabel("Kilometer", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            kilometerInput = new JTextField("", 10);

            addComponents(statusTextLabel, kennzeichenInput, statusPanel);
            addComponents(buchungTextLabel, standortDropDown, buchungPanel);
            addComponents(herstellerTextLabel, herstellerInput, herstellerPanel);
            addComponents(modellTextLabel, modellInput, modellPanel);
            addComponents(klasseTextLabel, klassenDropDown, klassenPanel);
            addComponents(preisTextLabel, preisInput, preisPanel);
            addComponents(baujahrTextLabel, baujahrInput, baujahrPanel);
            addComponents(kilometerTextLabel, kilometerInput, kilometerPanel);

        } else if (task == 2){

            statusTextLabel = createLabel("Kennzeichen",  Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            kennzeichenInput = new JTextField("", 10);
            buchungTextLabel = createLabel("Buchung", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            standortDropDown = new JComboBox<>(Fahrzeugklasse.values());
            herstellerTextLabel = createLabel("Hersteller", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            herstellerInput = new JTextField("", 10);
            modellTextLabel = createLabel("Model", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            modellInput = new JTextField("", 10);
            klasseTextLabel = createLabel("Klasse", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            klassenDropDown = new JComboBox<>(Fahrzeugklasse.values());
            preisTextLabel = createLabel("Preis", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            preisLabel = createLabel("Placeholder", Carsharing.config.FONT, Font.BOLD, Carsharing.config.FONT_SIZE_MEDIUM);
            baujahrTextLabel = createLabel("Baujahr", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            baujahrInput = new JTextField("", 10);
            kilometerTextLabel = createLabel("Kilometerstand", Carsharing.config.FONT, Font.PLAIN, Carsharing.config.FONT_SIZE_SMALL);
            kilometerInput = new JTextField("", 10);

            addComponents(statusTextLabel, kennzeichenInput, statusPanel);
            addComponents(buchungTextLabel, standortDropDown, buchungPanel);
            addComponents(herstellerTextLabel, herstellerInput, herstellerPanel);
            addComponents(modellTextLabel, modellInput, modellPanel);
            addComponents(klasseTextLabel, klassenDropDown, klassenPanel);
            addComponents(preisTextLabel, preisLabel, preisPanel);
            addComponents(baujahrTextLabel, baujahrInput, baujahrPanel);
            addComponents(kilometerTextLabel, kilometerInput, kilometerPanel);

        }

        reifenPanel.add(reifenDropDown);
        ausruestungPanel.add(ausruestungButton);

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
