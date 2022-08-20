package view.gui;

import util.enums.FontType;
import util.enums.FrameSize;
import view.controller.SettingsController;
import view.utils.GUIWindowComponent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class SettingsGUI extends GUIWindowComponent {

    JPanel gui = new JPanel();
    SettingsController controller = new SettingsController();

    public SettingsGUI(JFrame frame){

        FontType[] fontTypes = FontType.values();
        JComboBox<FontType> fontTypeDropDown = new JComboBox<>(fontTypes);

        FrameSize[] frameSizes = FrameSize.values();
        JComboBox<FrameSize> frameSizeDropDown = new JComboBox<>(frameSizes);

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
