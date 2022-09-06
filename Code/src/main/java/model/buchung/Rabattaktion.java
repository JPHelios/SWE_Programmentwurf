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
    private String[] aktionsKlassenIDs;

    public Rabattaktion(){
        this.rabattaktionID = UUID.randomUUID().toString();
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.rabattaktionID, String.valueOf(this.preisnachlass), this.beschreibung, String.join(",", this.aktionsKlassenIDs)};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return rabattaktionID;
    }
}
