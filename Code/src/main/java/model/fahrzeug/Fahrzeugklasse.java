package model.fahrzeug;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Fahrzeugklasse implements IPersistable {
    private String fahrzeugklasseID;

    private String name;
    private int preis;
    private String beschreibung;
    private String fuehrerschein;
    private Fahrzeug[] fahrzeuge;

    public Fahrzeugklasse(){
        this.fahrzeugklasseID = UUID.randomUUID().toString();
    }

    public String[] toStringArray(){
        String arr[] = new String[]{};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return fahrzeugklasseID;
    }
}
