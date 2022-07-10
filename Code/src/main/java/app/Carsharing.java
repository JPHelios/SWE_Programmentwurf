package app;

import lombok.Data;
import model.standort.Mitarbeiter;
import view.gui.NavigationGUI;

@Data
public class Carsharing {

    private Mitarbeiter angemeldeterMitarbeiter;
    private NavigationGUI gui;

    public Carsharing(){

        gui = new NavigationGUI();

    }

    public static void main(String[] args){
        Carsharing app = new Carsharing();
    }

    public void anmelden(Mitarbeiter mitarbeiter){

    }

    public boolean berechtigung(Object obj){
        return false;
    }


}
