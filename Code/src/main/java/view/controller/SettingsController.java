package view.controller;

import app.Carsharing;
import de.dhbwka.swe.utils.util.CSVReader;
import de.dhbwka.swe.utils.util.CSVWriter;
import view.utils.GUIController;
import view.utils.Settings;

import java.io.IOException;
import java.util.Arrays;

public class SettingsController extends GUIController {

    CSVWriter writer;

    public SettingsController(){

    }

    public void write(Object[][] args){
        writer = new CSVWriter(Carsharing.dirPath + "database\\settings.csv", true);
        try {

            System.out.println(Arrays.toString(args[0]));

            writer.writeDataToFile(args, new String[] {"FontType", "FrameSize"});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
