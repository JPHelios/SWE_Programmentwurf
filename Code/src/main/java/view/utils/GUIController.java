package view.utils;

import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.event.IGUIEventListener;
import de.dhbwka.swe.utils.event.IUpdateEventSender;

import java.util.EventListener;
import java.util.List;

public class GUIController implements IGUIEventListener, IUpdateEventSender {

    private List<EventListener> observers;

    @Override
    public void processGUIEvent(GUIEvent guiEvent) {

    }

    @Override
    public boolean addObserver(EventListener eventListener) {
        return false;
    }

    @Override
    public boolean removeObserver(EventListener eventListener) {
        return false;
    }
}
