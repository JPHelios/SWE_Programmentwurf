package model.fahrzeug;

import app.Carsharing;
import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Fahrradtraeger extends Ausruestung implements IPersistable {
    private String fahrradtraegerID;
    private int anzahlFahrraeder;
    private String montierung;
    private int maximalGewicht;
    private String name;
    private String beschreibung;
    private Fahrzeug[] kompatibel;
    private String[] kompatibelIDs;
    private Fahrzeug fahrzeug;
    private String fahrzeugID;

    public Fahrradtraeger(){
        this.fahrradtraegerID = UUID.randomUUID().toString();
    }

    public Fahrradtraeger(String[] props){
        this.fahrradtraegerID = props[0];
        this.anzahlFahrraeder = Integer.parseInt(props[1]);
        this.montierung = props[2];
        this.maximalGewicht = Integer.parseInt(props[3]);
        this.name = props[4];
        this.beschreibung = props[5];
        this.kompatibelIDs = props[6].split(",");
        this.fahrzeugID = props[7];

        /*this.kompatibel = new Fahrzeug[this.kompatibelIDs.length];
        for(int i = 0; i < this.kompatibelIDs.length; i++){
            this.kompatibel[i] = (Fahrzeug) Carsharing.em.find(Fahrzeug.class, this.kompatibelIDs[i]);
        }
        this.fahrzeug = (Fahrzeug) Carsharing.em.find(Fahrzeug.class, this.fahrzeugID);*/
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.fahrradtraegerID, String.valueOf(this.anzahlFahrraeder), this.montierung, String.valueOf(this.maximalGewicht), this.name, this.beschreibung, String.join(",", this.kompatibelIDs), this.fahrzeugID};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return fahrradtraegerID;
    }
}
