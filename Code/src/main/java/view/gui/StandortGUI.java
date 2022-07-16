package view.gui;

import view.controller.StandortController;
import view.utils.GUIWindowComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class StandortGUI extends GUIWindowComponent {

    JPanel gui = new JPanel();

    StandortController controller = new StandortController();

    Color paleVioletRed = new Color(222,99,154);
    Color cadillacPink = new Color(227,136,177);
    Color pinkRose = new Color(215,166,179);
    Color pinkMercury = new Color(241, 226, 226);
    Color smokeyGrey = new Color(112,112,112);

    public StandortGUI(JFrame frame){
        gui.setBackground(pinkRose);
        gui.setLayout(new FlowLayout());

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());

        DefaultListModel list_data = controller.getListData();

        JList standortListe = new JList(list_data);
        JScrollPane listPane = new JScrollPane(standortListe,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollBar listBar = listPane.getVerticalScrollBar();
        listBar.setSize((int) (frame.getWidth() * 0.4), (int) (frame.getHeight() * 0.7));

        JButton createButton = new JButton("Anlegen");


        ImageIcon icon = new ImageIcon("src\\main\\resources\\map.PNG");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, BufferedImage.SCALE_SMOOTH));

        JLabel map = new JLabel();
        map.setSize((int) (frame.getWidth() * 0.4), (int) (frame.getHeight() * 0.7));
        map.setIcon(icon);


        listPanel.add(searchPanel);
        listPanel.add(listBar);
        listPanel.add(createButton);

        gui.add(listPanel);
        gui.add(map);


    }

    public JPanel getGui(){
        return gui;
    }
}
