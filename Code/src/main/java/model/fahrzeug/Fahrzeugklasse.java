package model.fahrzeug;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fahrzeugklasse implements IPersistable {
    private int fahrzeugklasseID;

    private String name;
    private int preis;
    private String beschreibung;
    private String fuehrerschein;
    private Fahrzeug[] fahrzeuge;

    public Fahrzeugklasse(){

    }

    @Override
    public Object getPrimaryKey() {
        return fahrzeugklasseID;
    }
}
