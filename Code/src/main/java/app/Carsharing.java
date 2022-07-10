package app;

import lombok.Data;
import lombok.SneakyThrows;
import model.standort.Mitarbeiter;
import view.gui.NavigationGUI;

@Data
public class Carsharing {

    private Mitarbeiter angemeldeterMitarbeiter;
    private NavigationGUI gui;

    @SneakyThrows
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
