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
        JFrame frame = gui.getFrame();


        gui.getStandortButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navToGUI(new StandortGUI(frame).getGui());
            }
        });

        gui.getFahrzeugeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navToGUI(new FahrzeugGUI(frame).getGui());
            }
        });

        gui.getBuchungenButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navToGUI(new BuchungGUI(frame).getGui());
            }
        });

        gui.getKundenButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navToGUI(new KundeGUI(frame).getGui());
            }
        });

        gui.getMitarbeiterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navToGUI(new MitarbeiterGUI(frame).getGui());
            }
        });

        gui.getRechnungenButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navToGUI(new RechnungGUI(frame).getGui());
            }
        });

        gui.getSettingsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navToGUI(new SettingsGUI(frame).getGui());
            }
        });

    }

    private void navToGUI(JPanel comp){
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