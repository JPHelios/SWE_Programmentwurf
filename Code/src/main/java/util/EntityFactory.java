package util;

import model.utils.Bild;

public class EntityFactory {

    public Bild createBild(String pfad, String titel) {
        return new Bild(pfad, titel);
    }
}
