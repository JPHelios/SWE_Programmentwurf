package app;

import database.EntityManager;
import lombok.Data;
import lombok.SneakyThrows;
import model.standort.Mitarbeiter;
import util.EntityFactory;
import view.utils.Settings;
import view.gui.NavigationGUI;

@Data
public class Carsharing {

    public static Settings config;
    public static EntityManager em;
    public static EntityFactory ef;
    public static String dirPath;

    private Mitarbeiter angemeldeterMitarbeiter;
    private NavigationGUI gui;

    @SneakyThrows
    public Carsharing(){

        config = new Settings();
        em = new EntityManager();
        ef = new EntityFactory();
        gui = new NavigationGUI();

    }

    public static void main(String[] args){

        String argPath = "";

        try{

            if(args.length > 0) {
                if (args[0].equalsIgnoreCase("-d")) {
                    argPath = args[1];
                } else if (args[0].equalsIgnoreCase("-p")) {
                    System.out.println("Für das Setzten der Properties wurde eine CSV-Datei verwendet!");
                } else {
                    System.out.println("Dieser Parameter wird nicht unterstützt!");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(argPath.equals("")) {
            System.out.println("Zum Ausführen wird der Pfad zu den CSV-Dateien benötigt!");
            System.exit(0);
        } else {
            dirPath = argPath;
            new Carsharing();
        }

    }

    public void anmelden(Mitarbeiter mitarbeiter){

    }

    public boolean berechtigung(Object obj){
        return false;
    }


}
