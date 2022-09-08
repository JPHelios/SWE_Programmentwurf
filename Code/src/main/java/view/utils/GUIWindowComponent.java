package view.utils;

import de.dhbwka.swe.utils.event.IGUIEventSender;
import de.dhbwka.swe.utils.event.IUpdateEventListener;
import de.dhbwka.swe.utils.event.UpdateEvent;
import de.dhbwka.swe.utils.gui.SimpleListComponent;
import de.dhbwka.swe.utils.model.IDepictable;
import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import util.enums.Colors;

import javax.swing.*;
import java.awt.*;
import java.util.EventListener;
import java.util.List;

public abstract class GUIWindowComponent extends JComponent implements IGUIEventSender, IUpdateEventListener {

    private List<EventListener> observers;

    @Override
    public boolean addObserver(EventListener eventListener) {
        return false;
    }

    @Override
    public boolean removeObserver(EventListener eventListener) {
        return false;
    }

    @Override
    public void processUpdateEvent(UpdateEvent updateEvent) {

    }

    protected JPanel createPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(Colors.PINK_ROSE.getColor());
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        return panel;
    }

    protected JPanel createPanel(JPanel panel2Add, String orientation){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Colors.PINK_ROSE.getColor());
        panel.add(panel2Add, orientation);

        return panel;
    }

    protected JLabel createLabel(String text, String font, int fontType, int size){

        JLabel label = new JLabel(text);
        label.setFont(new Font(font, fontType, size));

        return label;
    }

    protected void addComponents(JLabel label1, JLabel label2, JPanel panel){
        panel.add(label1);
        panel.add(label2);
    }

    protected void addComponents(JLabel label, JTextField textField, JPanel panel){
        panel.add(label);
        panel.add(textField);
    }

    protected void addComponents(JLabel label, JComboBox comboBox, JPanel panel){
        panel.add(label);
        panel.add(comboBox);
    }

    protected void addComponents(JLabel label, JDatePickerImpl comboBox, JPanel panel){
        panel.add(label);
        panel.add(comboBox);
    }

    public void setRightSiteVisible(JPanel panel){
        panel.setVisible(true);
    }

    public void setRightSiteInvisible(JPanel panel){
        panel.setVisible(false);
    }

    public void clearListSelection(SimpleListComponent list){
        list.clearSelection();
    }

}
