package view.controller;

import app.Carsharing;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.gui.ButtonElement;
import model.kunde.Kunde;
import model.standort.Mitarbeiter;
import view.gui.MitarbeiterGUI;
import view.utils.GUIController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MitarbeiterController extends GUIController {

    MitarbeiterGUI gui;
    Mitarbeiter currentMitarbeiter;

    public MitarbeiterController(MitarbeiterGUI gui){
        this.gui = gui;
    }

    public List<Mitarbeiter> loadData(){

        List<Object> test = Carsharing.em.getAllEl(Mitarbeiter.class);
        List<Mitarbeiter> mitarbeiterList = new ArrayList<>();

        for(Object el : test){
            mitarbeiterList.add((Mitarbeiter) el);
        }

        return mitarbeiterList;
    }

    @Override
    public void processGUIEvent(GUIEvent guiEvent) {
        if (guiEvent.getCmd() == ButtonElement.Commands.BUTTON_PRESSED) {
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Filter")){
                System.out.println("Es wurde Filter geklickt");

                List<Mitarbeiter> mitarbeiter = loadData();
                List<Mitarbeiter> filterMitarbeiter = new ArrayList<>();
                String searchField = gui.searchField.getText();

                for (Mitarbeiter m: mitarbeiter){
                    if(m.getNachname().equalsIgnoreCase(searchField)) filterMitarbeiter.add(m);
                }

                if(filterMitarbeiter.size() != 0 ){
                    gui.mitarbeiterList.removeAllListElements();
                    gui.mitarbeiterList.setListElements(filterMitarbeiter);
                } else {
                    gui.mitarbeiterList.setListElements(loadData());
                    JOptionPane.showMessageDialog(gui, "Es konnte leider kein übereinstimmender Eintrag gefunden werden");
                }
            }
        }
    }
}
