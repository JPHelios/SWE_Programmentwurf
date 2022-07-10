package view.utils;

import de.dhbwka.swe.utils.event.IGUIEventSender;
import de.dhbwka.swe.utils.event.IUpdateEventListener;
import de.dhbwka.swe.utils.event.UpdateEvent;

import javax.swing.*;
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
}
