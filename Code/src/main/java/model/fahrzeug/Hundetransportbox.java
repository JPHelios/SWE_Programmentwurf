package model.fahrzeug;

import app.Carsharing;
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

    public Hundetransportbox(String[] props){
        this.hundetransportboxID = props[0];
        this.hundekompatibilitaet = props[1].split(",");
        this.anzahlHunde = Integer.parseInt(props[2]);
        this.beschreibung = props[3];
        this.name = props[4];
        this.kompatibelIDs = props[5].split(",");
        this.fahrzeugID = props[6];

        /*this.kompatibel = new Fahrzeug[this.kompatibelIDs.length];
        for(int i = 0; i < this.kompatibelIDs.length; i++){
            this.kompatibel[i] = (Fahrzeug) Carsharing.em.find(Fahrzeug.class, this.kompatibelIDs[i]);
        }
        this.fahrzeug = (Fahrzeug) Carsharing.em.find(Fahrzeug.class, this.fahrzeugID);*/
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
