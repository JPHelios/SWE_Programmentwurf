package model.utils;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bild implements IPersistable {
    private int bildID;

    private String pfad;
    private String titel;

    public Bild(){

    }

    @Override
    public Object getPrimaryKey() {
        return bildID;
    }
}
