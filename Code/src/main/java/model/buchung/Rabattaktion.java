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

    public Rabattaktion(String[] props){
        this.rabattaktionID = props[0];
        this.preisnachlass = Integer.parseInt(props[1]);
        this.beschreibung = props[2];
        this.aktionsKlassenIDs = props[3].split(",");

        /*this.aktionsKlassen = new Fahrzeugklasse[this.aktionsKlassenIDs.length];
        for(int i = 0; i< this.aktionsKlassenIDs.length; i++){
            this.aktionsKlassen[i] = Fahrzeugklasse.valueOf(this.aktionsKlassenIDs[i]);
        }*/
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
