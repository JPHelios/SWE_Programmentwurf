package model.fahrzeug;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Dachbox extends Ausruestung implements IPersistable {
    private String dachboxID;
    private float volumen;
    private float hoehe;
    private String name;
    private String beschreibung;
    private Fahrzeug[] kompatibel;
    private String[] kompatibelIDs;
    private Fahrzeug fahrzeug;
    private String fahrzeugID;

    public Dachbox(){
        this.dachboxID = UUID.randomUUID().toString();
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.dachboxID, String.valueOf(this.volumen), String.valueOf(this.hoehe), this.name, this.beschreibung, String.join(",", this.kompatibelIDs), this.fahrzeugID};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return dachboxID;
    }
}
