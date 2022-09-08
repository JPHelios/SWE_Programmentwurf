package view.gui;

import app.Carsharing;
import database.EntityManager;
import model.standort.Standort;
import util.enums.FontType;
import util.enums.FrameSize;
import view.controller.SettingsController;
import view.utils.GUIWindowComponent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class SettingsGUI extends GUIWindowComponent {

    JPanel gui = new JPanel();
    SettingsController controller = new SettingsController();
    EntityManager em = new EntityManager();

        public SettingsGUI(JFrame frame){

        List<FontType> fontTypes = Arrays.asList(FontType.values());
        JComboBox<FontType> fontTypeDropDown = new JComboBox<>(FontType.values());

        int index = 0;
        for(FontType ft : fontTypes){
            if(ft.toString().equals(Carsharing.config.FONT)){
                index = fontTypes.indexOf(ft);
            }
        }

        fontTypeDropDown.setSelectedIndex(index);

        List<FrameSize> frameSizes = Arrays.asList(FrameSize.values());
        JComboBox<FrameSize> frameSizeDropDown = new JComboBox<>(FrameSize.values());

        index = 0;
        for(FrameSize fs : frameSizes){
            if(fs.size().equals(Carsharing.config.FRAME_SIZE.size())){
                index = frameSizes.indexOf(fs);
            }
        }

        frameSizeDropDown.setSelectedIndex(index);

        JButton saveButton = new JButton("Speichern");

        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedFontType = fontTypeDropDown.getSelectedItem().toString();
                String selectedFrameSize = frameSizeDropDown.getSelectedItem().toString();

                String[] settings = new String[] {selectedFontType, selectedFrameSize};
                String[][] data = new String[][] {settings};

                controller.write(data);

                Object[] options = {"Restart Now", "Load Later"};

                int dialog = JOptionPane.showOptionDialog(
                        gui,
                        "App needs to be restarted to apply changes",
                        "Reload Required",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);

                switch (dialog){
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        break;
                }
            }
        });


        

        gui.add(fontTypeDropDown);
        gui.add(frameSizeDropDown);
        gui.add(saveButton);
    }

    public JPanel getGui(){
        return gui;
    }
}
