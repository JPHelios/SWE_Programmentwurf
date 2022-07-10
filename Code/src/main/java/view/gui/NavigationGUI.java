package view.gui;

import view.utils.GUIWindowComponent;

import javax.swing.*;

public class NavigationGUI extends GUIWindowComponent {

    JFrame frame = new JFrame();

    public NavigationGUI(){
        createFrame();
    }

    private void createFrame(){

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Carsharing Dödelhausen");
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setVisible(true);
        
    }
}
