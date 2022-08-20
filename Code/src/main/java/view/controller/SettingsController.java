package view.controller;

import de.dhbwka.swe.utils.util.CSVReader;
import de.dhbwka.swe.utils.util.CSVWriter;
import view.utils.GUIController;

import java.io.IOException;

public class SettingsController extends GUIController {

    CSVWriter writer;

    public SettingsController(){

    }

    public void write(Object[][] args){
        writer = new CSVWriter("src\\main\\resources\\database\\settings.csv", true);
        try {
            writer.writeDataToFile(args, new String[] {"FontType", "FrameSize"});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
