package view.controller;

import app.Carsharing;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.SimpleListComponent;
import model.fahrzeug.Fahrzeug;
import view.gui.FahrzeugGUI;
import view.utils.GUIController;

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
                gui.setRightSiteVisible();
                updateDetailLabelTexts();
            }
        }

        if (guiEvent.getCmd() == ButtonElement.Commands.BUTTON_PRESSED) {
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Anlegen")){
                gui.setRightSiteVisible();
            }
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Filter")){
                System.out.println("Button-Filter selected");
            }
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Create")){
                System.out.println("Button-Create selected");
            }
        }

        //if (){

        //}
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
