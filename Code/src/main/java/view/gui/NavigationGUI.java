package view.gui;

import view.utils.GUIWindowComponent;

import javax.swing.*;
import java.awt.*;
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

        JPanel mainComponent = new JPanel();
        mainComponent.setBackground(pinkRose);
    }
}
