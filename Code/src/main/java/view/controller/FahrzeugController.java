package view.controller;

import app.Carsharing;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.SimpleListComponent;
import model.fahrzeug.Fahrzeug;
import model.fahrzeug.Fahrzeugklasse;
import model.fahrzeug.Kennzeichen;
import model.standort.Standort;
import util.FahrzeugBuilder;
import view.gui.FahrzeugGUI;
import view.utils.GUIController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static util.enums.Entities.Kennzeichen;

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
            } //Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Save")){
                System.out.println("Es wurde Speichern geklickt");

                //Eingabeüberprüfung muss noch eingebaut werden!!!

                String kennzeichenInput = gui.kennzeichenInput.getText();
                //Standort standort = (Standort) gui.standortDropDown.getSelectedItem();
                String hersteller = gui.herstellerInput.getText();
                String model = gui.modellInput.getText();
                Fahrzeugklasse klasse = (Fahrzeugklasse) gui.klassenDropDown.getSelectedItem();

                try {
                    int baujahr = Integer.parseInt(gui.baujahrInput.getText());
                    int kilometer = Integer.parseInt(gui.kilometerInput.getText());

                    Kennzeichen kennzeichen = new Kennzeichen(kennzeichenInput);

                    FahrzeugBuilder fahrzeugBuilder = new FahrzeugBuilder();

                    fahrzeugBuilder.hersteller(hersteller);
                    fahrzeugBuilder.modell(model);
                    fahrzeugBuilder.baujahr(baujahr);
                    fahrzeugBuilder.kilometerstand(kilometer);
                    fahrzeugBuilder.status(true);

                    fahrzeugBuilder.standort(null);
                    fahrzeugBuilder.ausruestung(null);
                    fahrzeugBuilder.bilder(null);
                    fahrzeugBuilder.kennzeichen(kennzeichen);

                    fahrzeugBuilder.build();


                } catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(gui, "Die Eingabe ist nicht korrekt oder unvollständig ! \n Überprüfen Sie die eingegebenen Daten.");
                }
            }
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Cancel")){
                System.out.println("Es wurde Abbrechen geklickt");

                JPanel panel = gui.createRightSidePanel(-1);
                gui.createRightSide(panel);
                gui.setRightSiteVisible(panel);
            } //Funktion done
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
                            gui.fahrzeugList.setListElements(this.loadData());
                        }
                    }
                }

            } //Funktion done
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
