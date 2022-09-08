package view.controller;

import app.Carsharing;
import model.kunde.Kunde;
import model.standort.Mitarbeiter;
import view.gui.MitarbeiterGUI;
import view.utils.GUIController;

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
}
