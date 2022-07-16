package view.gui;

import view.utils.GUIWindowComponent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

public class NavigationGUI extends GUIWindowComponent {

    JFrame frame = new JFrame();

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    Color paleVioletRed = new Color(222,99,154);
    Color cadillacPink = new Color(227,136,177);
    Color pinkRose = new Color(215,166,179);
    Color pinkMercury = new Color(241, 226, 226);
    Color smokeyGrey = new Color(112,112,112);

    Border noBorder = new EmptyBorder(10, 20, 10, 20);
    Font navigationFont = new Font("Arial", Font.PLAIN, 25);

    JPanel mainComponent = new JPanel();

    public NavigationGUI() throws IOException, FontFormatException {
        createNavigationBar();
        createHeader();
        createMainComponent();

        createFrame();
    }

    private void createFrame(){

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Carsharing Dödelhausen");
        frame.setSize(screenSize.width, screenSize.height);
        frame.setResizable(false);
        frame.setVisible(true);
        
    }

    private void createNavigationBar(){

        JPanel navigationBar = new JPanel();
        navigationBar.setBackground(cadillacPink);
        navigationBar.setLayout(new BoxLayout(navigationBar, BoxLayout.PAGE_AXIS));
        navigationBar.setBorder(new EmptyBorder(28, 28, 28, 28));



        JButton standortButton = new JButton("Standorte");
        standortButton.setBackground(cadillacPink);
        standortButton.setBorder(noBorder);
        standortButton.setFont(navigationFont);
        standortButton.setForeground(smokeyGrey);
        standortButton.setSize((int) (frame.getWidth() * 0.2), (int) (frame.getHeight() * 0.125));
        standortButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                standortButton.setBackground(paleVioletRed);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                standortButton.setBackground(cadillacPink);
            }
        });
        standortButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        navigationBar.add(standortButton);

        JButton fahrzeugeButton = new JButton("Fahrzeuge");
        fahrzeugeButton.setBackground(cadillacPink);
        fahrzeugeButton.setBorder(noBorder);
        fahrzeugeButton.setFont(navigationFont);
        fahrzeugeButton.setForeground(smokeyGrey);
        fahrzeugeButton.setSize((int) (frame.getWidth() * 0.2), (int) (frame.getHeight() * 0.125));
        fahrzeugeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fahrzeugeButton.setBackground(paleVioletRed);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                fahrzeugeButton.setBackground(cadillacPink);
            }
        });
        fahrzeugeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        navigationBar.add(fahrzeugeButton);


        JButton buchungenButton = new JButton("Buchungen");
        buchungenButton.setBackground(cadillacPink);
        buchungenButton.setBorder(noBorder);
        buchungenButton.setFont(navigationFont);
        buchungenButton.setForeground(smokeyGrey);
        buchungenButton.setSize((int) (frame.getWidth() * 0.2), (int) (frame.getHeight() * 0.125));
        buchungenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buchungenButton.setBackground(paleVioletRed);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                buchungenButton.setBackground(cadillacPink);
            }
        });
        buchungenButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        navigationBar.add(buchungenButton);


        JButton kundenButton = new JButton("Kunden");
        kundenButton.setBackground(cadillacPink);
        kundenButton.setBorder(noBorder);
        kundenButton.setFont(navigationFont);
        kundenButton.setForeground(smokeyGrey);
        kundenButton.setSize((int) (frame.getWidth() * 0.2), (int) (frame.getHeight() * 0.125));
        kundenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                kundenButton.setBackground(paleVioletRed);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                kundenButton.setBackground(cadillacPink);
            }
        });
        kundenButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        navigationBar.add(kundenButton);


        JButton mitarbeiterButton = new JButton("Mitarbeiter");
        mitarbeiterButton.setBackground(cadillacPink);
        mitarbeiterButton.setBorder(noBorder);
        mitarbeiterButton.setFont(navigationFont);
        mitarbeiterButton.setForeground(smokeyGrey);
        mitarbeiterButton.setSize((int) (frame.getWidth() * 0.2), (int) (frame.getHeight() * 0.125));
        mitarbeiterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mitarbeiterButton.setBackground(paleVioletRed);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                mitarbeiterButton.setBackground(cadillacPink);
            }
        });
        mitarbeiterButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        navigationBar.add(mitarbeiterButton);


        JButton rechnungenButton = new JButton("Rechnungen");
        rechnungenButton.setBackground(cadillacPink);
        rechnungenButton.setBorder(noBorder);
        rechnungenButton.setFont(navigationFont);
        rechnungenButton.setForeground(smokeyGrey);
        rechnungenButton.setSize((int) (frame.getWidth() * 0.2), (int) (frame.getHeight() * 0.125));
        rechnungenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rechnungenButton.setBackground(paleVioletRed);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                rechnungenButton.setBackground(cadillacPink);
            }
        });
        rechnungenButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        navigationBar.add(rechnungenButton);


        JButton settingsButton = new JButton("Einstellungen");
        settingsButton.setBackground(cadillacPink);
        settingsButton.setBorder(noBorder);
        settingsButton.setFont(navigationFont);
        settingsButton.setForeground(smokeyGrey);
        settingsButton.setSize((int) (frame.getWidth() * 0.2), (int) (frame.getHeight() * 0.125));
        settingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsButton.setBackground(paleVioletRed);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsButton.setBackground(cadillacPink);
            }
        });
        settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        navigationBar.add(settingsButton);




        frame.add(navigationBar, BorderLayout.WEST);
    }

    private void createHeader(){

        ImageIcon icon = new ImageIcon("src\\main\\resources\\logo.PNG");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, BufferedImage.SCALE_SMOOTH));

        JLabel headline_label = new JLabel("Carsharing Dödelhausen", SwingConstants.CENTER);
        headline_label.setFont(new Font("Serif", Font.BOLD, 50));

        JLabel logo_label = new JLabel();
        logo_label.setSize(300,100);
        logo_label.setIcon(icon);

        JLabel placeholder_label = new JLabel(" ");

        JPanel header_panel = new JPanel();
        header_panel.setBackground(paleVioletRed);
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

    private void switchMainComponent(JPanel newComponent){
        frame.remove(mainComponent);
        mainComponent = newComponent;
        frame.add(mainComponent, BorderLayout.CENTER);
    }
}
