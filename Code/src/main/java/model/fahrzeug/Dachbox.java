package model.fahrzeug;

import app.Carsharing;
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

    public Dachbox(String[] props){
        this.dachboxID = props[0];
        this.volumen = Float.parseFloat(props[1]);
        this.hoehe = Float.parseFloat(props[2]);
        this.name = props[3];
        this.beschreibung = props[4];
        this.kompatibelIDs = props[5].split(",");
        this.fahrzeugID = props[6];

        /*this.kompatibel = new Fahrzeug[this.kompatibelIDs.length];
        for(int i = 0; i < this.kompatibelIDs.length; i++){
            this.kompatibel[i] = (Fahrzeug) Carsharing.em.find(Fahrzeug.class, this.kompatibelIDs[i]);
        }
        this.fahrzeug = (Fahrzeug) Carsharing.em.find(Fahrzeug.class, this.fahrzeugID);*/
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
