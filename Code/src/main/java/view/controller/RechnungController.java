package view.controller;

import app.Carsharing;
import model.buchung.Rechnung;
import model.kunde.Kunde;
import view.gui.RechnungGUI;
import view.utils.GUIController;

import java.util.ArrayList;
import java.util.List;

public class RechnungController extends GUIController {

    RechnungGUI gui;
    Rechnung currentRechnung;

    public RechnungController(RechnungGUI gui){
        this.gui = gui;
    }

    public List<Rechnung> loadData(){

        List<Object> test = Carsharing.em.getAllEl(Rechnung.class);
        List<Rechnung> rechnungList = new ArrayList<>();

        for(Object el : test){
            rechnungList.add((Rechnung) el);
        }

        return rechnungList;
    }
}
