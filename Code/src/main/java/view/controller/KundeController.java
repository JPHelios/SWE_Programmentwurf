package view.controller;

import app.Carsharing;
import model.fahrzeug.Fahrzeug;
import model.kunde.Kunde;
import view.gui.KundeGUI;
import view.utils.GUIController;

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
}
