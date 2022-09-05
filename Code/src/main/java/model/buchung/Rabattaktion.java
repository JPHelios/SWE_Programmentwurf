package model.buchung;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;
import model.fahrzeug.Fahrzeugklasse;

import java.util.UUID;

@Getter
@Setter
public class Rabattaktion implements IPersistable {
    private String rabattaktionID;

    private int preisnachlass;
    private String beschreibung;
    private Fahrzeugklasse[] aktionsKlassen;

    public Rabattaktion(){
        this.rabattaktionID = UUID.randomUUID().toString();
    }

    public String[] toStringArray(){
        String arr[] = new String[]{};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return rabattaktionID;
    }
}
