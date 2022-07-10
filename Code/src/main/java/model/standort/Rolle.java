package model.standort;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rolle implements IPersistable {
    private int rolleID;

    private String bezeichnung;
    private Object[] berechtigt;

    public Rolle(){

    }

    @Override
    public Object getPrimaryKey() {
        return rolleID;
    }
}
