package view.controller;

import app.Carsharing;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.SimpleListComponent;
import model.buchung.Buchung;
import model.fahrzeug.Fahrzeug;
import model.fahrzeug.Fahrzeugklasse;
import model.kunde.Kunde;
import model.standort.Filiale;
import model.standort.Mitarbeiter;
import util.FahrzeugBuilder;
import view.gui.BuchungGUI;
import view.gui.FahrzeugGUI;
import view.utils.GUIController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BuchungController extends GUIController {

    Buchung currentBuchung;
    BuchungGUI gui;
    ArrayList<String> ausruestungTmp = new ArrayList<String>();

    public BuchungController(BuchungGUI gui){
        this.gui = gui;
    }
    public List<Buchung> loadData(){

        List<Object> test = Carsharing.em.getAllEl(Buchung.class);
        List<Buchung> buchungList = new ArrayList<>();

        for(Object el : test){
            buchungList.add((Buchung) el);
        }

        return buchungList;
    }

    @Override
    public void processGUIEvent(GUIEvent guiEvent) {

        if (guiEvent.getCmd() == SimpleListComponent.Commands.ELEMENT_SELECTED){
            if (guiEvent.getData() instanceof Buchung) {
                currentBuchung = (Buchung) guiEvent.getData();

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
                gui.clearListSelection(gui.buchungList);

            } //Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Filter")){
                System.out.println("Es wurde Filter geklickt");

                List<Buchung> buchungen = loadData();

                String searchField = gui.searchField.getText();



                if(buchungen.size() != 0 ){
                    gui.buchungList.removeAllListElements();
                    gui.buchungList.setListElements(buchungen);
                } else {
                    gui.buchungList.setListElements(loadData());
                    JOptionPane.showMessageDialog(gui, "Es konnte leider kein übereinstimmender Eintrag gefunden werden");
                }


            } //Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Create")){
                System.out.println("Es wurde Create geklickt");

                JPanel panel = gui.createRightSidePanel(1);
                gui.createRightSide(panel);
                gui.setRightSiteVisible(panel);
                gui.clearListSelection(gui.buchungList);
            } //Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Save")){
                System.out.println("Es wurde Speichern geklickt");

                //Eingabeüberprüfung muss noch eingebaut werden!!!

                Object fahrzeugInput = gui.fahrzeugSelect.getSelectedItem();
                //Standort standort = (Standort) gui.standortDropDown.getSelectedItem();
                //String hersteller = gui.herstellerInput.getText();
                //String model = gui.modellInput.getText();
                //Fahrzeugklasse klasse = (Fahrzeugklasse) gui.klassenDropDown.getSelectedItem();
                //String kennzeichen = gui.kennzeichenInput.getText().toUpperCase();
                /*
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

                 */
            } //Referenzen zu anderen Objekten!
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Cancel")){
                System.out.println("Es wurde Abbrechen geklickt");

                JPanel panel = gui.createRightSidePanel(-1);
                gui.createRightSide(panel);
                gui.setRightSiteVisible(panel);
                gui.clearListSelection(gui.buchungList);
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
                            Carsharing.em.removeEl(currentBuchung);
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
                /*
                currentBuchung.setKennzeichen(gui.kennzeichenInput.getText().toUpperCase());
                //Standort hinzufügen
                currentBuchung.setHersteller(gui.herstellerInput.getText());
                currentBuchung.setModell(gui.modellInput.getText());
                currentBuchung.setFahrzeugklasse((Fahrzeugklasse) gui.klassenDropDown.getSelectedItem());
                currentBuchung.setBaujahr(Integer.parseInt(gui.baujahrInput.getText()));
                currentBuchung.setKilometerstand(Integer.parseInt(gui.kilometerInput.getText()));
                //Reifensatz hinzufügen
                //Ausrüstung hinzufügen

                Carsharing.em.modify(Fahrzeug.class, currentBuchung.toStringArray());
                 */
                refreshList();
            } //Noch einige Askepte ausstehend
        }
    }

    public void updateDetailLabelTexts(){

        gui.fahrzeugLabel.setText(currentBuchung.getFahrzeug().getHersteller() + " " + currentBuchung.getFahrzeug().getModell());
        gui.startLabel.setText(currentBuchung.getStarttermin().toString());
        gui.endLabel.setText(currentBuchung.getEndtermin().toString());
        gui.preisLabel.setText(String.valueOf(currentBuchung.getFahrzeug().getFahrzeugklasse().getPreis()) + "€ pro Tag");
        gui.kundeLabel.setText(currentBuchung.getKunde().getNachname() + ", " + currentBuchung.getKunde().getVorname());
        gui.mitarbeiterLabel.setText(currentBuchung.getMitarbeiter().getNachname() + ", " + currentBuchung.getMitarbeiter().getVorname());

    }

    private void updateEditLabelTexts(){
        /*
        gui.kennzeichenInput.setText(currentBuchung.getKennzeichen());
        //gui.standortDropDown.
        gui.herstellerInput.setText(currentBuchung.getHersteller());
        gui.modellInput.setText(currentBuchung.getModell());
        gui.klassenDropDown.setSelectedIndex(currentBuchung.getFahrzeugklasse().ordinal());
        gui.preisLabel.setText(String.valueOf(currentBuchung.getFahrzeugklasse().getPreis()));
        gui.baujahrInput.setText(String.valueOf(currentBuchung.getBaujahr()));
        gui.kilometerInput.setText(String.valueOf(currentBuchung.getKilometerstand()));
         */
    }

    public Fahrzeug[] loadFahrzeugModel(){
        List<Object> data = Carsharing.em.getAllEl(Fahrzeug.class);
        Fahrzeug[] fahrzeugList = new Fahrzeug[data.size()];

        for(int i = 0; i < data.size(); i++){
            fahrzeugList[i] = (Fahrzeug) data.get(i);
        }

        return fahrzeugList;
    }

    public Kunde[] loadKundeModel(){
        List<Object> data = Carsharing.em.getAllEl(Kunde.class);
        Kunde[] kundeList = new Kunde[data.size()];

        for(int i = 0; i < data.size(); i++){
            kundeList[i] = (Kunde) data.get(i);
        }

        return kundeList;
    }

    public Mitarbeiter[] loadMitarbeiterModel(){
        List<Object> data = Carsharing.em.getAllEl(Mitarbeiter.class);
        Mitarbeiter[] mitarbeiterList = new Mitarbeiter[data.size()];

        for(int i = 0; i < data.size(); i++){
            mitarbeiterList[i] = (Mitarbeiter) data.get(i);
        }

        return mitarbeiterList;
    }

    private void refreshList(){
        gui.buchungList.setListElements(this.loadData());
    }


}
