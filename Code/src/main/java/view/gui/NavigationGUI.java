package view.gui;

import view.utils.GUIWindowComponent;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class NavigationGUI extends GUIWindowComponent {

    JFrame frame = new JFrame();

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    Color paleVioletRed = new Color(222,99,154);
    Color cadillacPink = new Color(227,136,177);
    Color pinkRose = new Color(215,166,179);
    Color pinkMercury = new Color(241, 226, 226);
    Color smokeyGrey = new Color(112,112,112);

    public NavigationGUI() throws IOException, FontFormatException {
        createFrame();
        createNavigationBar();
        createHeader();
        createMainComponent();
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

        JPanel header = new JPanel();

        header.setBackground(paleVioletRed);
        header.setSize(frame.getWidth(), (int) (frame.getHeight() * 0.1));

        JLabel headline = new JLabel("Carsharing Dödelhausen");
        headline.setFont(new Font("Serif", Font.BOLD, 50));

        JLabel logo = new JLabel();
        ImageIcon icon = new ImageIcon("logo.PNG");
        logo.setIcon(icon);

        header.add(headline, BorderLayout.CENTER);
        header.add(logo, BorderLayout.WEST);


        frame.add(header, BorderLayout.NORTH);
    }

    private void createMainComponent(){

        JPanel mainComponent = new JPanel();
        mainComponent.setBackground(pinkRose);
    }
}
