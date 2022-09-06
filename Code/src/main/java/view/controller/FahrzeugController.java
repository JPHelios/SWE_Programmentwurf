package view.controller;

import app.Carsharing;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.SimpleListComponent;
import model.fahrzeug.Fahrzeug;
import view.gui.FahrzeugGUI;
import view.utils.GUIController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FahrzeugController extends GUIController {

    Fahrzeug currentFahrzeug;
    FahrzeugGUI gui;

    public FahrzeugController(FahrzeugGUI gui){
        this.gui = gui;
    }

    public List<Fahrzeug> loadData(){

        List<Object> test = Carsharing.em.getAllEl(Fahrzeug.class);
        List<Fahrzeug> fahrzeugList = new ArrayList<>();

        for(Object el : test){
            fahrzeugList.add((Fahrzeug) el);
        }

        return fahrzeugList;
    }

    @Override
    public void processGUIEvent(GUIEvent guiEvent) {

        if (guiEvent.getCmd() == SimpleListComponent.Commands.ELEMENT_SELECTED){
            if (guiEvent.getData() instanceof Fahrzeug) {
                currentFahrzeug = (Fahrzeug) guiEvent.getData();

                JPanel panel = gui.createRightSidePanel(0);
                gui.createRightSide(panel);
                updateDetailLabelTexts();
                gui.setRightSiteVisible(panel);
            }
        }

        if (guiEvent.getCmd() == ButtonElement.Commands.BUTTON_PRESSED) {
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Anlegen")){
                System.out.println("Es wurde Anlegen geklickt");
                JPanel panel = gui.createRightSidePanel(1);
                gui.createRightSide(panel);
                gui.setRightSiteVisible(panel);
                gui.clearListSelection();

            }
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Filter")){
                System.out.println("Es wurde Filter geklickt");

                gui.clearListSelection();

            }
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Create")){
                System.out.println("Es wurde Create geklickt");

                JPanel panel = gui.createRightSidePanel(1);
                gui.createRightSide(panel);
                gui.setRightSiteVisible(panel);
                gui.clearListSelection();
            }
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Save")){
                System.out.println("Es wurde Speichern geklickt");

            }
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Cancel")){
                System.out.println("Es wurde Abbrechen geklickt");

                JPanel panel = gui.createRightSidePanel(-1);
                gui.createRightSide(panel);
                gui.setRightSiteVisible(panel);
            }
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Edit")){
                System.out.println("Es wurde Bearbeiten geklickt");

            }
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Loeschen")){
                System.out.println("Es wurde Löschen geklickt");

                Object[] options = {"Ja", "Nein"};

                int value1 = JOptionPane.showOptionDialog(
                        gui,
                        "Wollen Sie den Datensatz löschen?",
                        "Eintrag Löschen",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);

                if (value1 == 0){
                    int value2 = JOptionPane.showOptionDialog(
                            gui,
                            "Sind Sie sich sicher, dass Sie den Eintrag löschen wollen?",
                            "Eintrag Löschen",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0]);

                    if (value2 == 0){
                        int value3 = JOptionPane.showOptionDialog(
                                gui,
                                "Sind Sie sich ganz sicher, dass Sie den Eintrag löschen wollen?",
                                "Eintrag Löschen",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[0]);

                        if(value3 == 0){
                            //Delete-Routine
                            Carsharing.em.removeEl(currentFahrzeug);
                        }
                    }
                }

            }
        }


    }

    public void updateDetailLabelTexts(){

        gui.herstellerLabel.setText(currentFahrzeug.getHersteller());
        gui.modellLabel.setText(currentFahrzeug.getModell());
        gui.klasseLabel.setText("Well, fck");
        gui.preisLabel.setText("Well, fck");
        gui.baujahrLabel.setText(String.valueOf(currentFahrzeug.getBaujahr()));
        gui.kilometerLabel.setText(String.valueOf(currentFahrzeug.getKilometerstand()));

    }



}
