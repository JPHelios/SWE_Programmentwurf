package view.controller;

import app.Carsharing;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.SimpleListComponent;
import model.standort.Filiale;
import model.standort.Standort;
import model.utils.Adresse;
import util.StandortBuilder;
import view.gui.StandortGUI;
import view.utils.GUIController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StandortController extends GUIController {

    Standort currentStandort;
    StandortGUI gui;

    public StandortController(StandortGUI gui){
        this.gui = gui;
    }

    public List<Standort> loadData(){

        List<Object> test = Carsharing.em.getAllEl(Standort.class);
        List<Standort> standortList = new ArrayList<>();

        for(Object el : test){
            standortList.add((Standort) el);
        }

        return standortList;
    }

    public Filiale[] loadFiliale(){
        List<Object> test = Carsharing.em.getAllEl(Filiale.class);
        Filiale[] filialeList = new Filiale[test.size()];

        for(int i = 0; i < test.size(); i++){
            filialeList[i] = (Filiale) test.get(i);
        }

        return filialeList;
    }

    @Override
    public void processGUIEvent(GUIEvent guiEvent) {

        if (guiEvent.getCmd() == SimpleListComponent.Commands.ELEMENT_SELECTED){
            if (guiEvent.getData() instanceof Standort) {
                System.out.println("Es wurde ein Item ausgewählt");
                currentStandort = (Standort) guiEvent.getData();

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
                gui.clearListSelection(gui.standortList);
            }//Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Filter")){
                System.out.println("Es wurde Filter geklickt");

                List<Standort> standorte = loadData();
                List<Standort> foundStandorte = new ArrayList<Standort>();

                String searchField = gui.searchField.getText();

                for (Standort st : standorte){

                    if(st.getAdresse().getPlz().equalsIgnoreCase(searchField)) foundStandorte.add(st);
                    else if(st.getAdresse().getOrt().equalsIgnoreCase(searchField)) foundStandorte.add(st);

                }

                if(foundStandorte.size() != 0 ){
                    gui.standortList.removeAllListElements();
                    gui.standortList.setListElements(foundStandorte);
                } else {
                    gui.standortList.setListElements(loadData());
                    JOptionPane.showMessageDialog(gui, "Es konnte leider kein übereinstimmender Eintrag gefunden werden");
                }
            } //Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Create")){
                System.out.println("Es wurde Create geklickt ");

                JPanel panel = gui.createRightSidePanel(-1);
                gui.createRightSide(panel);
                gui.setRightSiteVisible(panel);
                gui.clearListSelection(gui.standortList);
            }//Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Edit")){
                System.out.println("Es wurde Bearbeiten gewählt");

                JPanel panel = gui.createRightSidePanel(2);

                gui.createRightSide(panel);
                updateEditLabelTexts();
                gui.setRightSiteVisible(panel);
            } //Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Loeschen")){
                System.out.println("Es wurde Löschen gewählt");

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
                            Carsharing.em.removeEl(currentStandort);
                            refreshList();
                        }
                    }
                }

            } //Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Save")){
                System.out.println("Es wurde Speichern gewählt");

                //Eingabeüberprüfung muss noch eingebaut werden
                String strasse = gui.adressInput.getText().split(" ")[0];
                String hausnummer = gui.adressInput.getText().split(" ")[1];
                String plz = gui.plzInput.getText();
                String ort = gui.ortInput.getText();

                Adresse newAdresse = Carsharing.ef.createAdresse(new String[]{strasse, hausnummer, plz, ort, null});
                //Eig. müsste das in einen Try-Catch... entweder klappt alles oder nichts
                Carsharing.em.persistEl(Adresse.class, newAdresse.toStringArray());

                int plaetze = Integer.parseInt(gui.plaetzeInput.getText());
                int saeulen = Integer.parseInt(gui.saeulenInput.getText());
                Filiale filiale = (Filiale) gui.filialeDropDown.getSelectedItem();

                StandortBuilder standortBuilder = new StandortBuilder();

                standortBuilder.adresse(newAdresse.getAdresseID());
                standortBuilder.filiale(filiale);
                standortBuilder.ladesaeulen(saeulen);
                standortBuilder.stellplaetze(plaetze);
                standortBuilder.bild("1");

                Standort newStandort = standortBuilder.build();
                Carsharing.em.persistEl(Standort.class, newStandort.toStringArray());

                refreshList();

                JPanel panel = gui.createRightSidePanel(-1);
                gui.createRightSide(panel);
                gui.setRightSiteVisible(panel);
                gui.clearListSelection(gui.standortList);


            }//Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Save-Edit")){
                System.out.println("Es wurde Speichern gewählt");

                currentStandort.setAnzahlPlaetze(Integer.parseInt(gui.plaetzeInput.getText()));
                currentStandort.setAnzahlSaeulen(Integer.parseInt(gui.saeulenInput.getText()));

                currentStandort.setFiliale((Filiale) gui.filialeDropDown.getSelectedItem());
                currentStandort.setFilialeID(((Filiale) Objects.requireNonNull(gui.filialeDropDown.getSelectedItem())).getFilialeID());

                Carsharing.em.modify(Standort.class, currentStandort.toStringArray());
                refreshList();

                JPanel panel = gui.createRightSidePanel(0);
                gui.createRightSide(panel);
                updateDetailLabelTexts();
                gui.setRightSiteVisible(panel);

            } //Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Cancel")){
                System.out.println("Es wurde Abbrechen geklickt");


                JPanel panel = gui.createRightSidePanel(-1);
                gui.createRightSide(panel);
                gui.setRightSiteVisible(panel);
                gui.clearListSelection(gui.standortList);
            }//Funktion done

        }

    }

    public void updateDetailLabelTexts(){

        gui.adresseLabel.setText(currentStandort.getAdresse().getStrasse() + ", " + currentStandort.getAdresse().getHausnummer());
        gui.plzLabel.setText(currentStandort.getAdresse().getPlz());
        gui.ortLabel.setText(currentStandort.getAdresse().getOrt());
        gui.plaetzeLabel.setText(String.valueOf(currentStandort.getAnzahlPlaetze()));
        gui.saeulenLabel.setText(String.valueOf(currentStandort.getAnzahlSaeulen()));

        if (currentStandort.getFiliale().getStandortID().equals("0")){
            gui.filialeLabel.setText("Nicht Vorhanden");
            gui.zeitenLabel.setText("Keine Zeiten");
        } else {
            gui.filialeLabel.setText("Vorhanden");
            gui.zeitenLabel.setText(String.valueOf(currentStandort.getFiliale().getOeffnungszeiten()));
        }
    }

    private void updateEditLabelTexts(){
        gui.adresseLabel.setText(currentStandort.getAdresse().getStrasse() + ", " + currentStandort.getAdresse().getHausnummer());
        gui.plzLabel.setText(currentStandort.getAdresse().getPlz());
        gui.ortLabel.setText(currentStandort.getAdresse().getOrt());
        gui.plaetzeInput.setText(String.valueOf(currentStandort.getAnzahlPlaetze()));
        gui.saeulenInput.setText(String.valueOf(currentStandort.getAnzahlSaeulen()));

        //dirty solution, da setSelectedItem kömischerweise keine Funktion hier zeigt
        int index = 0;
        Filiale[] listTmp = this.loadFiliale();
        for(int i = 0; i < listTmp.length; i++){
            if(listTmp[i].getFilialeID().equals(currentStandort.getFiliale().getFilialeID())){
                index = i;
            }
        }

        gui.filialeDropDown.setSelectedIndex(index);
        gui.zeitenLabel.setText("lade Zeiten...");

    }

    private void refreshList(){
        gui.standortList.setListElements(this.loadData());
    }
}
