package model.fahrzeug;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Hundetransportbox extends Ausruestung implements IPersistable {
    private String hundetransportboxID;
    private String[] hundekompatibilitaet;
    private int anzahlHunde;
    private String beschreibung;
    private String name;
    private String[] kompatibelIDs;
    private String fahrzeugID;
    private Fahrzeug[] kompatibel;
    private Fahrzeug fahrzeug;

    public Hundetransportbox(){
        this.hundetransportboxID = UUID.randomUUID().toString();
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.hundetransportboxID, String.join(",", this.hundekompatibilitaet), String.valueOf(this.anzahlHunde), this.beschreibung, this.name, String.join(",", this.kompatibelIDs), this.fahrzeugID};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return hundetransportboxID;
    }
}
