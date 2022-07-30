package view.controller;

import view.gui.*;
import view.utils.GUIController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationController extends GUIController {

    NavigationGUI gui;

    public NavigationController(NavigationGUI gui){
        this.gui = gui;
    }

    public void navToGUI(JPanel comp){
        JPanel newComponent = comp;
        switchMainComponent(newComponent);
    }




    public void switchMainComponent(JPanel newComponent) {
        JFrame frame = gui.getFrame();
        frame.remove(gui.getMainComponent());
        gui.setMainComponent(newComponent);
        frame.add(newComponent, BorderLayout.CENTER);
        frame.revalidate();
    }

}