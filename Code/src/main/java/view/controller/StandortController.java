package view.controller;

import app.Carsharing;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.SimpleListComponent;
import de.dhbwka.swe.utils.util.CSVReader;
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
                //updateDetailLabelTexts();
                gui.setRightSiteVisible(panel);

            }
        }

        if (guiEvent.getCmd() == ButtonElement.Commands.BUTTON_PRESSED) {
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Anlegen")){
                System.out.println("Es wurde Anlegen geklickt");
            }
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Filter")){
                System.out.println("Es wurde Filter geklickt");
            }
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Create")){
                System.out.println("Es wurde Create geklickt ");
            }

        }

    }

}
