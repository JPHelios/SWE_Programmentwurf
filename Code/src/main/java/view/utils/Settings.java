package view.utils;

import de.dhbwka.swe.utils.util.CSVReader;
import util.enums.FontType;
import util.enums.FrameSize;
import util.enums.TextSize;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Settings {

    String filePath = "src\\main\\resources\\database\\settings.csv";

    public String FONT = FontType.ARIAL.toString();
    public int FONT_SIZE_SMALL = TextSize.TEXT_SIZE_XLARGE.label();
    public int FONT_SIZE_MEDIUM = TextSize.TEXT_SIZE_XLARGE.text();
    public FrameSize FRAME_SIZE = FrameSize.WINDOW_XLARGE;

    public Settings(){
        boolean fileExists = checkExistingSettings();

        if(fileExists){
            loadExistingSettings();
        }
    }

    private void loadExistingSettings() {

        ArrayList<String> existingSettings = new ArrayList<>();

        CSVReader reader = new CSVReader("src\\main\\resources\\database\\settings.csv");
        try {
            List<String[]> data = reader.readData();

            Collections.addAll(existingSettings, data.get(0));
            
            System.out.println(existingSettings);

            FONT = existingSettings.get(0);
            FRAME_SIZE = FrameSize.valueOf(existingSettings.get(1));
            calculateFontSize();
            


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void calculateFontSize() {

        switch (FRAME_SIZE) {
            case WINDOW_SMALL:
                FONT_SIZE_SMALL = TextSize.TEXT_SIZE_SMALL.label();
                FONT_SIZE_MEDIUM = TextSize.TEXT_SIZE_SMALL.text();
                break;
            case WINDOW_MEDIUM:
                FONT_SIZE_SMALL = TextSize.TEXT_SIZE_MEDIUM.label();
                FONT_SIZE_MEDIUM = TextSize.TEXT_SIZE_MEDIUM.text();
                break;
            case WINDOW_LARGE:
                FONT_SIZE_SMALL = TextSize.TEXT_SIZE_LARGE.label();
                FONT_SIZE_MEDIUM = TextSize.TEXT_SIZE_LARGE.text();
                break;
            case WINDOW_XLARGE:
                FONT_SIZE_SMALL = TextSize.TEXT_SIZE_XLARGE.label();
                FONT_SIZE_MEDIUM = TextSize.TEXT_SIZE_XLARGE.text();
                break;

        }

    }

    private boolean checkExistingSettings() {
        File file = new File(filePath);

        return file.exists();
    }
}
