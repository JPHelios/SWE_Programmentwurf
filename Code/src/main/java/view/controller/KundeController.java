package view.controller;

import app.Carsharing;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.gui.ButtonElement;
import model.kunde.Kunde;
import view.gui.KundeGUI;
import view.utils.GUIController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class KundeController extends GUIController {

    Kunde currentKunde;
    KundeGUI gui;

    public KundeController(KundeGUI gui){
        this.gui = gui;
    }

    public List<Kunde> loadData(){

        List<Object> test = Carsharing.em.getAllEl(Kunde.class);
        List<Kunde> kundeList = new ArrayList<>();

        for(Object el : test){
            kundeList.add((Kunde) el);
        }

        return kundeList;
    }

    @Override
    public void processGUIEvent(GUIEvent guiEvent) {
        if (guiEvent.getCmd() == ButtonElement.Commands.BUTTON_PRESSED) {
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Filter")){
                System.out.println("Es wurde Filter geklickt");

                List<Kunde> kunden = loadData();
                List<Kunde> filterKunden = new ArrayList<>();
                String searchField = gui.searchField.getText();

                for (Kunde k: kunden){
                    if(k.getNachname().equalsIgnoreCase(searchField)) filterKunden.add(k);
                }

                if(filterKunden.size() != 0 ){
                    gui.kundeList.removeAllListElements();
                    gui.kundeList.setListElements(filterKunden);
                } else {
                    gui.kundeList.setListElements(loadData());
                    JOptionPane.showMessageDialog(gui, "Es konnte leider kein übereinstimmender Eintrag gefunden werden");
                }
            }
        }
    }
}
