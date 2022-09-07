package view.controller;

import app.Carsharing;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.SimpleListComponent;
import model.fahrzeug.Fahrzeug;
import model.fahrzeug.Fahrzeugklasse;
import util.FahrzeugBuilder;
import view.gui.FahrzeugGUI;
import view.utils.GUIController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FahrzeugController extends GUIController {

    Fahrzeug currentFahrzeug;
    FahrzeugGUI gui;
    ArrayList<String> ausruestungTmp = new ArrayList<String>();

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
                gui.clearListSelection(gui.fahrzeugList);

            } //Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Filter")){
                System.out.println("Es wurde Filter geklickt");

                List<Fahrzeug> fahrzeuge = loadData();
                List<Fahrzeug> foundFahrzeuge = new ArrayList<Fahrzeug>();

                String searchField = gui.searchField.getText();

                for (Fahrzeug fz : fahrzeuge){

                    if(fz.getHersteller().equalsIgnoreCase(searchField)) foundFahrzeuge.add(fz);
                    else if(fz.getFahrzeugklasseID().equalsIgnoreCase(searchField)) foundFahrzeuge.add(fz);

                }

                if(foundFahrzeuge.size() != 0 ){
                    gui.fahrzeugList.removeAllListElements();
                    gui.fahrzeugList.setListElements(foundFahrzeuge);
                } else {
                    gui.fahrzeugList.setListElements(loadData());
                    JOptionPane.showMessageDialog(gui, "Es konnte leider kein übereinstimmender Eintrag gefunden werden");
                }


            } //Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Create")){
                System.out.println("Es wurde Create geklickt");

                JPanel panel = gui.createRightSidePanel(1);
                gui.createRightSide(panel);
                gui.setRightSiteVisible(panel);
                gui.clearListSelection(gui.fahrzeugList);
            } //Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Save")){
                System.out.println("Es wurde Speichern geklickt");

                //Eingabeüberprüfung muss noch eingebaut werden!!!

                String kennzeichenInput = gui.kennzeichenInput.getText();
                //Standort standort = (Standort) gui.standortDropDown.getSelectedItem();
                String hersteller = gui.herstellerInput.getText();
                String model = gui.modellInput.getText();
                Fahrzeugklasse klasse = (Fahrzeugklasse) gui.klassenDropDown.getSelectedItem();
                String kennzeichen = gui.kennzeichenInput.getText().toUpperCase();

                try {
                    int baujahr = Integer.parseInt(gui.baujahrInput.getText());
                    int kilometer = Integer.parseInt(gui.kilometerInput.getText());

                    FahrzeugBuilder fahrzeugBuilder = new FahrzeugBuilder();

                    fahrzeugBuilder.hersteller(hersteller);
                    fahrzeugBuilder.modell(model);
                    fahrzeugBuilder.baujahr(baujahr);
                    fahrzeugBuilder.kilometerstand(kilometer);
                    fahrzeugBuilder.status(true);
                    fahrzeugBuilder.klasse(((Fahrzeugklasse) Objects.requireNonNull(gui.klassenDropDown.getSelectedItem())).getName());

                    fahrzeugBuilder.standort("69");
                    fahrzeugBuilder.ausruestung(new String[]{});
                    fahrzeugBuilder.bilder(new String[]{});
                    fahrzeugBuilder.kennzeichen(kennzeichen);

                    //persist newly created vehicle
                    Fahrzeug newFahrzeug = fahrzeugBuilder.build();
                    Carsharing.em.persistEl(Fahrzeug.class, newFahrzeug.toStringArray());

                    //refresh list
                    refreshList();


                } catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(gui, "Die Eingabe ist nicht korrekt oder unvollständig ! \n Überprüfen Sie die eingegebenen Daten.");
                }
            } //Referenzen zu anderen Objekten!
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Cancel")){
                System.out.println("Es wurde Abbrechen geklickt");

                JPanel panel = gui.createRightSidePanel(0);
                gui.createRightSide(panel);
                updateDetailLabelTexts();
                gui.setRightSiteVisible(panel);
            } //Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Edit")){
                System.out.println("Es wurde Bearbeiten geklickt");

                JPanel panel = gui.createRightSidePanel(2);
                gui.createRightSide(panel);
                updateEditLabelTexts();
                gui.setRightSiteVisible(panel);

                

            }//Noch einige Funktionen ausstehend
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
                            refreshList();
                        }
                    }
                }

            } //Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Ausruestung")){
                Object[] options = {"Speichern", "Abbrechen"};

                String[] stringArray = {"Dachbox: Klein", "Dachbox: Mittel", "Dachbox: Groß",
                    "Hundebox, 1 Hund", "Hundebox, 2 Hunde", "Fahrradträger: 2 Räder", "Fahrradträger: 4 Räder"};
                JCheckBox[] checkBoxArray = new JCheckBox[7];
                for (int i = 0; i < stringArray.length; i++){
                    checkBoxArray[i] = new JCheckBox(stringArray[i]);
                }

                int save = JOptionPane.showOptionDialog(
                        gui,
                        checkBoxArray,
                        "Ausrüstung auswählen",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);

                if (save == 0){
                    System.out.println("OK");
                    for (JCheckBox cb : checkBoxArray){
                        if (cb.isSelected()){
                            System.out.println(cb.getText());
                            ausruestungTmp.add(cb.getText());
                        }
                    }
                }
            } //Noch Objekte in Checkboxen einfügen
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Save-Edit")){
                System.out.println("Es wurde Speichern beim Bearbeiten geklickt");

                currentFahrzeug.setKennzeichen(gui.kennzeichenInput.getText().toUpperCase());
                //Standort hinzufügen
                currentFahrzeug.setHersteller(gui.herstellerInput.getText());
                currentFahrzeug.setModell(gui.modellInput.getText());
                currentFahrzeug.setFahrzeugklasse((Fahrzeugklasse) gui.klassenDropDown.getSelectedItem());
                currentFahrzeug.setBaujahr(Integer.parseInt(gui.baujahrInput.getText()));
                currentFahrzeug.setKilometerstand(Integer.parseInt(gui.kilometerInput.getText()));
                //Reifensatz hinzufügen
                //Ausrüstung hinzufügen

                Carsharing.em.modify(Fahrzeug.class, currentFahrzeug.toStringArray());
                refreshList();
            } //Noch einige Askepte ausstehend
        }
    }

    public void updateDetailLabelTexts(){

        gui.statusLabel.setText(String.valueOf(currentFahrzeug.isStatus()));
        gui.herstellerLabel.setText(currentFahrzeug.getHersteller());
        gui.modellLabel.setText(currentFahrzeug.getModell());
        gui.klasseLabel.setText(currentFahrzeug.getFahrzeugklasseID());
        gui.preisLabel.setText(String.valueOf(Fahrzeugklasse.valueOf(currentFahrzeug.getFahrzeugklasseID()).getPreis()));
        gui.baujahrLabel.setText(String.valueOf(currentFahrzeug.getBaujahr()));
        gui.kilometerLabel.setText(String.valueOf(currentFahrzeug.getKilometerstand()));

    }

    private void updateEditLabelTexts(){

        gui.kennzeichenInput.setText(currentFahrzeug.getKennzeichen());
        //gui.standortDropDown.
        gui.herstellerInput.setText(currentFahrzeug.getHersteller());
        gui.modellInput.setText(currentFahrzeug.getModell());
        gui.klassenDropDown.setSelectedIndex(currentFahrzeug.getFahrzeugklasse().ordinal());
        gui.preisLabel.setText(String.valueOf(currentFahrzeug.getFahrzeugklasse().getPreis()));
        gui.baujahrInput.setText(String.valueOf(currentFahrzeug.getBaujahr()));
        gui.kilometerInput.setText(String.valueOf(currentFahrzeug.getKilometerstand()));
    }

    private void refreshList(){
        gui.fahrzeugList.setListElements(this.loadData());
    }



}
