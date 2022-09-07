package view.controller;

import app.Carsharing;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.SimpleListComponent;
import model.fahrzeug.Fahrzeug;
import model.standort.Standort;
import view.gui.StandortGUI;
import view.utils.GUIController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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
            }
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
            }
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Create")){
                System.out.println("Es wurde Create geklickt ");
            }
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Edit")){
                System.out.println("Es wurde Bearbeiten gewählt");
            }
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Loeschen")){
                System.out.println("Es wurde Löschen gewählt");
            }
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Save")){
                System.out.println("Es wurde Speichern gewählt");
            }
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Save-Edit")){
                System.out.println("Es wurde Speichern gewählt");
            }

        }

    }

    public void updateDetailLabelTexts(){

        gui.adresseLabel.setText(currentStandort.getAdresse().getStrasse() + ", " + currentStandort.getAdresse().getHausnummer());
        gui.plzLabel.setText(currentStandort.getAdresse().getPlz());
        gui.ortLabel.setText(currentStandort.getAdresse().getOrt());
        gui.plaetzeLabel.setText(String.valueOf(currentStandort.getAnzahlPlaetze()));
        gui.saeulenLabel.setText(String.valueOf(currentStandort.getAnzahlSaeulen()));

        if(currentStandort.existFiliale()){
            gui.filialeLabel.setText("Ja");
            gui.zeitenLabel.setText(String.valueOf(currentStandort.getFiliale().getOeffnungszeiten()));
        } else {
            gui.filialeLabel.setText("Nein");
            gui.zeitenLabel.setText("keine Zeiten");
        }

    }

}
