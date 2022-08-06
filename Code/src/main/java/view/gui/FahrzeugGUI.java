package view.gui;

import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.SimpleListComponent;
import model.fahrzeug.Ausruestung;
import model.fahrzeug.Reifen;
import util.Colors;
import view.utils.GUIWindowComponent;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FahrzeugGUI extends GUIWindowComponent {

    JPanel gui = new JPanel();

    public FahrzeugGUI(JFrame frame){
        gui.setBackground(Colors.PINK_ROSE.getColor());
        gui.setLayout(new GridLayout(1,3));

        createListComponent();
        createDetailComponent();
    }

    private void createListComponent() {

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

        gui.add(leftComponentPanel);
    }

    private void createDetailComponent(){

        String[] placeholderDropDown = {"Placeholder 1" , "Placeholder 2", "Placeholder 3"};

        JPanel rightComponentPanel = new JPanel();
        rightComponentPanel.setBackground(Colors.PINK_ROSE.getColor());
        rightComponentPanel.setLayout(new BorderLayout());

        JLabel mapLabel = new JLabel();

        ImageIcon icon = new ImageIcon("src\\main\\resources\\map.PNG");
        icon = new ImageIcon(icon.getImage().getScaledInstance(900, 500, BufferedImage.SCALE_SMOOTH));

        mapLabel.setIcon(icon);
        mapLabel.setHorizontalAlignment(JLabel.CENTER);
        mapLabel.setVerticalAlignment(JLabel.CENTER);

        rightComponentPanel.add(mapLabel, BorderLayout.NORTH);

//      #######################
        JPanel panelPanel = new JPanel();
        panelPanel.setLayout(new GridLayout(5,2, 200,50));
        panelPanel.setBackground(Colors.PINK_ROSE.getColor());

        JPanel statusPanel = new JPanel();
        statusPanel.setBackground(Colors.PINK_ROSE.getColor());
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.Y_AXIS));

        JPanel buchungPanel = new JPanel();
        buchungPanel.setBackground(Colors.PINK_ROSE.getColor());
        buchungPanel.setLayout(new BoxLayout(buchungPanel, BoxLayout.Y_AXIS));

        JPanel herstellerPanel = new JPanel();
        herstellerPanel.setBackground(Colors.PINK_ROSE.getColor());
        herstellerPanel.setLayout(new BoxLayout(herstellerPanel, BoxLayout.Y_AXIS));

        JPanel modellPanel = new JPanel();
        modellPanel.setBackground(Colors.PINK_ROSE.getColor());
        modellPanel.setLayout(new BoxLayout(modellPanel, BoxLayout.Y_AXIS));

        JPanel klassenPanel = new JPanel();
        klassenPanel.setBackground(Colors.PINK_ROSE.getColor());
        klassenPanel.setLayout(new BoxLayout(klassenPanel, BoxLayout.Y_AXIS));

        JPanel preisPanel = new JPanel();
        preisPanel.setBackground(Colors.PINK_ROSE.getColor());
        preisPanel.setLayout(new BoxLayout(preisPanel, BoxLayout.Y_AXIS));

        JPanel baujahrPanel = new JPanel();
        baujahrPanel.setBackground(Colors.PINK_ROSE.getColor());
        baujahrPanel.setLayout(new BoxLayout(baujahrPanel, BoxLayout.Y_AXIS));

        JPanel kilometerPanel = new JPanel();
        kilometerPanel.setBackground(Colors.PINK_ROSE.getColor());
        kilometerPanel.setLayout(new BoxLayout(kilometerPanel, BoxLayout.Y_AXIS));

        JPanel reifenPanel = new JPanel();
        reifenPanel.setBackground(Colors.PINK_ROSE.getColor());
        reifenPanel.setLayout(new BoxLayout(reifenPanel, BoxLayout.Y_AXIS));

        JPanel ausruestungPanel = new JPanel();
        ausruestungPanel.setBackground(Colors.PINK_ROSE.getColor());
        ausruestungPanel.setLayout(new BoxLayout(ausruestungPanel, BoxLayout.Y_AXIS));

        //----------------

        JLabel statusTextLabel = new JLabel("Status");
        statusTextLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JLabel statusLabel = new JLabel("Placeholder");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 20));

        statusPanel.add(statusTextLabel);
        statusPanel.add(statusLabel);

        //----------------

        JLabel buchungLabel = new JLabel("Buchung");
        buchungLabel.setFont(new Font("Arial", Font.ITALIC, 20));

        buchungPanel.add(buchungLabel);

        //----------------

        JLabel herstellerTextLabel = new JLabel("Hersteller");
        herstellerTextLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JLabel herstellerLabel = new JLabel("Placeholder");
        herstellerLabel.setFont(new Font("Arial", Font.BOLD, 20));

        herstellerPanel.add(herstellerTextLabel);
        herstellerPanel.add(herstellerLabel);

        //----------------

        JLabel modellTextLabel = new JLabel("Hersteller");
        modellTextLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JLabel modellLabel = new JLabel("Placeholder");
        modellLabel.setFont(new Font("Arial", Font.BOLD, 20));

        modellPanel.add(modellTextLabel);
        modellPanel.add(modellLabel);

        //----------------

        JLabel klasseTextLabel = new JLabel("Klasse");
        klasseTextLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JLabel klasseLabel = new JLabel("Placeholder");
        klasseLabel.setFont(new Font("Arial", Font.BOLD, 20));

        klassenPanel.add(klasseTextLabel);
        klassenPanel.add(klasseLabel);

        //----------------

        JLabel preisTextLabel = new JLabel("Preis");
        preisTextLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JLabel preisLabel = new JLabel("Placeholder");
        preisLabel.setFont(new Font("Arial", Font.BOLD, 20));

        preisPanel.add(preisTextLabel);
        preisPanel.add(preisLabel);

        //----------------

        JLabel baujahrTextLabel = new JLabel("Baujahr");
        baujahrTextLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JLabel baujahrLabel = new JLabel("Placeholder");
        baujahrLabel.setFont(new Font("Arial", Font.BOLD, 20));

        baujahrPanel.add(baujahrTextLabel);
        baujahrPanel.add(baujahrLabel);

        //----------------

        JLabel kilometerTextLabel = new JLabel("Kilometerstand");
        kilometerTextLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JLabel kilometerLabel = new JLabel("Placeholder");
        kilometerLabel.setFont(new Font("Arial", Font.BOLD, 20));

        kilometerPanel.add(kilometerTextLabel);
        kilometerPanel.add(kilometerLabel);

        //----------------

        JComboBox<String> reifenDropDown = new JComboBox<>(placeholderDropDown);

        reifenPanel.add(reifenDropDown);

        //----------------

        JComboBox<String> ausruestungDropDown = new JComboBox<>(placeholderDropDown);

        ausruestungPanel.add(ausruestungDropDown);

        //----------------

        JPanel layoutPanel1 = new JPanel();
        layoutPanel1.setLayout(new BorderLayout());
        layoutPanel1.add(statusPanel, BorderLayout.EAST);
        layoutPanel1.setBackground(Colors.PINK_ROSE.getColor());

        JPanel layoutPanel2 = new JPanel();
        layoutPanel2.setLayout(new BorderLayout());
        layoutPanel2.add(buchungPanel, BorderLayout.WEST);
        layoutPanel2.setBackground(Colors.PINK_ROSE.getColor());

        JPanel layoutPanel3 = new JPanel();
        layoutPanel3.setLayout(new BorderLayout());
        layoutPanel3.add(herstellerPanel, BorderLayout.EAST);
        layoutPanel3.setBackground(Colors.PINK_ROSE.getColor());

        JPanel layoutPanel4 = new JPanel();
        layoutPanel4.setLayout(new BorderLayout());
        layoutPanel4.add(modellPanel, BorderLayout.WEST);
        layoutPanel4.setBackground(Colors.PINK_ROSE.getColor());

        JPanel layoutPanel5 = new JPanel();
        layoutPanel5.setLayout(new BorderLayout());
        layoutPanel5.add(klassenPanel, BorderLayout.EAST);
        layoutPanel5.setBackground(Colors.PINK_ROSE.getColor());

        JPanel layoutPanel6 = new JPanel();
        layoutPanel6.setLayout(new BorderLayout());
        layoutPanel6.add(preisPanel, BorderLayout.WEST);
        layoutPanel6.setBackground(Colors.PINK_ROSE.getColor());

        JPanel layoutPanel7 = new JPanel();
        layoutPanel7.setLayout(new BorderLayout());
        layoutPanel7.add(baujahrPanel, BorderLayout.EAST);
        layoutPanel7.setBackground(Colors.PINK_ROSE.getColor());

        JPanel layoutPanel8 = new JPanel();
        layoutPanel8.setLayout(new BorderLayout());
        layoutPanel8.add(kilometerPanel, BorderLayout.WEST);
        layoutPanel8.setBackground(Colors.PINK_ROSE.getColor());

        JPanel layoutPanel9 = new JPanel();
        layoutPanel9.setLayout(new BorderLayout());
        layoutPanel9.add(reifenPanel, BorderLayout.EAST);
        layoutPanel9.setBackground(Colors.PINK_ROSE.getColor());

        JPanel layoutPanel10 = new JPanel();
        layoutPanel10.setLayout(new BorderLayout());
        layoutPanel10.add(ausruestungPanel, BorderLayout.WEST);
        layoutPanel10.setBackground(Colors.PINK_ROSE.getColor());

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

        //########################

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
}
