package app;

import database.EntityManager;
import lombok.Data;
import lombok.SneakyThrows;
import model.standort.Mitarbeiter;
import view.utils.Settings;
import view.gui.NavigationGUI;

@Data
public class Carsharing {

    public static Settings config;
    public static EntityManager em;

    private Mitarbeiter angemeldeterMitarbeiter;
    private NavigationGUI gui;

    @SneakyThrows
    public Carsharing(){

        config = new Settings();
        em = new EntityManager();
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
