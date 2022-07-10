package model.standort;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Filiale implements IPersistable {
    private int filialeID;

    private String[] oeffnungszeiten = new String[7];
    private Mitarbeiter[] mitarbeiter;
    private Standort standort;

    public Filiale(){

    }

    @Override
    public Object getPrimaryKey() {
        return filialeID;
    }
}
