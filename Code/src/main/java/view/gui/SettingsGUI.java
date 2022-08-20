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

                String[] selectedFontType = new String[] {fontTypeDropDown.getSelectedItem().toString()};
                String[] selectedFrameSize = new String[] {frameSizeDropDown.getSelectedItem().toString()};

                String[][] data = new String[][] {selectedFontType, selectedFrameSize};

                controller.write(data);

            }
        });

















        JLabel test = new JLabel("Einstellungen");
        JButton readButton = new JButton("read");
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //controller.read();
            }
        });

        String[] rawdata1 = {"69", "69", "69", "test.jpg", "69"};
        String[] rawdata2 = {"70", "70", "70", "test.jpg", "70"};
        String[][] data = new String[][]{rawdata1, rawdata2};

        JButton writeButton = new JButton("write");
        writeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //controller.write(data);
            }
        });

        gui.add(test);
        gui.add(readButton);
        gui.add(writeButton);
        gui.add(fontTypeDropDown);
        gui.add(frameSizeDropDown);
        gui.add(saveButton);
    }

    public JPanel getGui(){
        return gui;
    }
}
