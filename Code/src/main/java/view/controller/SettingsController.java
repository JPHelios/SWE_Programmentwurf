package view.controller;

import de.dhbwka.swe.utils.util.CSVReader;
import de.dhbwka.swe.utils.util.CSVWriter;
import view.utils.GUIController;

import java.io.IOException;
import java.util.List;

public class SettingsController extends GUIController {

    CSVReader reader;
    CSVWriter writer;

    public SettingsController(){

    }

    public void read(){
        reader = new CSVReader("src\\main\\resources\\database\\standort.csv");
        try {
            List<String[]> data = reader.readData();
            for (String[] x: data) {
                for(String y: x){
                    System.out.println(y);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //1, 12, 4, "s1.jpg", 1
    //2, 100, 25, "s2.jpg", 2
    public void write(Object[][] args){
        writer = new CSVWriter("src\\main\\resources\\database\\standort.csv", false);
        try {
            writer.writeDataToFile(args, new String[]{"Standort-ID", "Anzahl Stellplätze", "Anzahl E-Säulen", "Bild-ID", "Adress-ID"});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
