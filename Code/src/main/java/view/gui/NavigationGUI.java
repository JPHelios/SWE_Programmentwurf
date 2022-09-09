package view.gui;

import app.Carsharing;
import lombok.Getter;
import lombok.Setter;
import util.enums.Colors;
import view.controller.NavigationController;
import view.utils.GUIWindowComponent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class NavigationGUI extends GUIWindowComponent {
    @Getter
    JFrame frame = new JFrame();

    NavigationController controller;

    @Getter
    JButton standortButton;
    @Getter
    JButton fahrzeugeButton;
    @Getter
    JButton buchungenButton;
    @Getter
    JButton kundenButton;
    @Getter
    JButton mitarbeiterButton;
    @Getter
    JButton rechnungenButton;
    @Getter
    JButton settingsButton;

    Border noBorder = new EmptyBorder(10, 20, 10, 20);
    Font navigationFont = new Font(Carsharing.config.FONT, Font.PLAIN, (int) (Carsharing.config.FONT_SIZE_HEADLINE * 0.5));

    @Getter @Setter
    JPanel mainComponent = new JPanel();

    public NavigationGUI() throws IOException, FontFormatException {
        createNavigationBar();
        createHeader();
        createMainComponent();
        createFrame();

        controller = new NavigationController(this);
    }

    private void createFrame(){

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Carsharing Dödelhausen");
        frame.setSize(Carsharing.config.FRAME_SIZE.x(), Carsharing.config.FRAME_SIZE.y());
        frame.setResizable(false);
        frame.setVisible(true);
        
    }

    private void createNavigationBar(){

        JPanel navigationBar = new JPanel();
        navigationBar.setBackground(Colors.CADILLAC_PINK.getColor());
        navigationBar.setLayout(new BoxLayout(navigationBar, BoxLayout.PAGE_AXIS));
        navigationBar.setBorder(new EmptyBorder(28, 28, 28, 28));

        standortButton = new JButton("Standorte");
        standortButton.setBackground(Colors.CADILLAC_PINK.getColor());
        standortButton.setBorder(noBorder);
        standortButton.setFont(navigationFont);
        standortButton.setForeground(Colors.SMOKEY_GREY.getColor());
        standortButton.setSize((int) (frame.getWidth() * 0.2), (int) (frame.getHeight() * 0.125));
        standortButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                standortButton.setBackground(Colors.PALE_VIOLET_RED.getColor());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                standortButton.setBackground(Colors.CADILLAC_PINK.getColor());
            }
        });
        standortButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        navigationBar.add(standortButton);

        fahrzeugeButton = new JButton("Fahrzeuge");
        fahrzeugeButton.setBackground(Colors.CADILLAC_PINK.getColor());
        fahrzeugeButton.setBorder(noBorder);
        fahrzeugeButton.setFont(navigationFont);
        fahrzeugeButton.setForeground(Colors.SMOKEY_GREY.getColor());
        fahrzeugeButton.setSize((int) (frame.getWidth() * 0.2), (int) (frame.getHeight() * 0.125));
        fahrzeugeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fahrzeugeButton.setBackground(Colors.PALE_VIOLET_RED.getColor());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                fahrzeugeButton.setBackground(Colors.CADILLAC_PINK.getColor());
            }
        });
        fahrzeugeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        navigationBar.add(fahrzeugeButton);

        buchungenButton = new JButton("Buchungen");
        buchungenButton.setBackground(Colors.CADILLAC_PINK.getColor());
        buchungenButton.setBorder(noBorder);
        buchungenButton.setFont(navigationFont);
        buchungenButton.setForeground(Colors.SMOKEY_GREY.getColor());
        buchungenButton.setSize((int) (frame.getWidth() * 0.2), (int) (frame.getHeight() * 0.125));
        buchungenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buchungenButton.setBackground(Colors.PALE_VIOLET_RED.getColor());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                buchungenButton.setBackground(Colors.CADILLAC_PINK.getColor());
            }
        });
        buchungenButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        navigationBar.add(buchungenButton);

        kundenButton = new JButton("Kunden");
        kundenButton.setBackground(Colors.CADILLAC_PINK.getColor());
        kundenButton.setBorder(noBorder);
        kundenButton.setFont(navigationFont);
        kundenButton.setForeground(Colors.SMOKEY_GREY.getColor());
        kundenButton.setSize((int) (frame.getWidth() * 0.2), (int) (frame.getHeight() * 0.125));
        kundenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                kundenButton.setBackground(Colors.PALE_VIOLET_RED.getColor());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                kundenButton.setBackground(Colors.CADILLAC_PINK.getColor());
            }
        });
        kundenButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        navigationBar.add(kundenButton);

        mitarbeiterButton = new JButton("Mitarbeiter");
        mitarbeiterButton.setBackground(Colors.CADILLAC_PINK.getColor());
        mitarbeiterButton.setBorder(noBorder);
        mitarbeiterButton.setFont(navigationFont);
        mitarbeiterButton.setForeground(Colors.SMOKEY_GREY.getColor());
        mitarbeiterButton.setSize((int) (frame.getWidth() * 0.2), (int) (frame.getHeight() * 0.125));
        mitarbeiterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mitarbeiterButton.setBackground(Colors.PALE_VIOLET_RED.getColor());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                mitarbeiterButton.setBackground(Colors.CADILLAC_PINK.getColor());
            }
        });
        mitarbeiterButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        navigationBar.add(mitarbeiterButton);

        rechnungenButton = new JButton("Rechnungen");
        rechnungenButton.setBackground(Colors.CADILLAC_PINK.getColor());
        rechnungenButton.setBorder(noBorder);
        rechnungenButton.setFont(navigationFont);
        rechnungenButton.setForeground(Colors.SMOKEY_GREY.getColor());
        rechnungenButton.setSize((int) (frame.getWidth() * 0.2), (int) (frame.getHeight() * 0.125));
        rechnungenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rechnungenButton.setBackground(Colors.PALE_VIOLET_RED.getColor());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                rechnungenButton.setBackground(Colors.CADILLAC_PINK.getColor());
            }
        });
        rechnungenButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        navigationBar.add(rechnungenButton);

        settingsButton = new JButton("Einstellungen");
        settingsButton.setBackground(Colors.CADILLAC_PINK.getColor());
        settingsButton.setBorder(noBorder);
        settingsButton.setFont(navigationFont);
        settingsButton.setForeground(Colors.SMOKEY_GREY.getColor());
        settingsButton.setSize((int) (frame.getWidth() * 0.2), (int) (frame.getHeight() * 0.125));
        settingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsButton.setBackground(Colors.PALE_VIOLET_RED.getColor());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsButton.setBackground(Colors.CADILLAC_PINK.getColor());
            }
        });
        settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        navigationBar.add(settingsButton);

        standortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.navToGUI(new StandortGUI(frame).getGui());
            }
        });

        fahrzeugeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.navToGUI(new FahrzeugGUI(frame).getGui());
            }
        });

        buchungenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.navToGUI(new BuchungGUI(frame).getGui());
            }
        });

        kundenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.navToGUI(new KundeGUI(frame).getGui());
            }
        });

        mitarbeiterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.navToGUI(new MitarbeiterGUI(frame).getGui());
            }
        });

        rechnungenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.navToGUI(new RechnungGUI(frame).getGui());
            }
        });

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.navToGUI(new SettingsGUI(frame).getGui());
            }
        });

        frame.add(navigationBar, BorderLayout.WEST);
    }

    private void createHeader(){

        ImageIcon icon = new ImageIcon(Carsharing.dirPath + "\\logo.PNG");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, BufferedImage.SCALE_SMOOTH));

        JLabel headline_label = new JLabel("Carsharing Dödelhausen", SwingConstants.CENTER);
        headline_label.setFont(new Font("Serif", Font.BOLD, Carsharing.config.FONT_SIZE_HEADLINE));

        JLabel logo_label = new JLabel();
        logo_label.setSize(300,100);
        logo_label.setIcon(icon);

        JLabel placeholder_label = new JLabel(" ");

        JPanel header_panel = new JPanel();
        header_panel.setBackground(Colors.PALE_VIOLET_RED.getColor());
        header_panel.setSize(frame.getWidth(), (int) (frame.getHeight() * 0.1));
        header_panel.setLayout(new GridLayout(1,3));

        header_panel.add(logo_label);
        header_panel.add(headline_label);
        header_panel.add(placeholder_label);

        frame.add(header_panel, BorderLayout.NORTH);

    }

    private void createMainComponent(){

        mainComponent = new StandortGUI(frame).getGui();
        frame.add(mainComponent, BorderLayout.CENTER);

    }
}
