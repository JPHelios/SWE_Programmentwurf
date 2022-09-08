package model.fahrzeug;
import app.Carsharing;
import de.dhbwka.swe.utils.model.Attribute;
import de.dhbwka.swe.utils.model.IDepictable;
import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Data;
import model.standort.Standort;
import model.utils.Bild;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
public class Fahrzeug implements IPersistable, IDepictable {

    private String fahrzeugID;

    private String hersteller;
    private String modell;
    private int baujahr;
    private boolean status;
    private int kilometerstand;
    private boolean reserviert;
    private String kennzeichen;
    private Ausruestung[] ausruestung;
    private String[] ausruestungIDs;
    private Reifensatz reifensatz;
    private String reifensatzID;
    private Standort standort;
    private String standortID;
    private Bild[] bilder = new Bild[3];
    private String[] bildIDs;
    private Fahrzeugklasse fahrzeugklasse;
    private String fahrzeugklasseID;

    public Fahrzeug(){
        this.fahrzeugID = UUID.randomUUID().toString();
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.fahrzeugID, this.hersteller, this.modell, String.valueOf(this.baujahr), String.valueOf(this.status), String.valueOf(this.kilometerstand), String.valueOf(this.reserviert), this.kennzeichen, String.join(",", this.ausruestungIDs), this.reifensatzID, this.standortID, String.join(",", this.bildIDs), this.fahrzeugklasseID};
        return arr;
    }

    public Fahrzeug(String[] props){
        this.fahrzeugID = props[0];
        this.hersteller = props[1];
        this.modell = props[2];
        this.baujahr = Integer.parseInt(props[3]);
        this.status = Boolean.parseBoolean(props[4]);
        this.kilometerstand = Integer.parseInt(props[5]);
        this.reserviert = Boolean.parseBoolean(props[6]);
        this.kennzeichen = (props[7]);
        this.ausruestungIDs = props[8].split(",");
        this.reifensatzID = (props[9]);
        this.standortID = (props[10]);
        this.bildIDs = props[11].split(",");
        this.fahrzeugklasseID = (props[12]);

        this.standort = (Standort) Carsharing.em.find(Standort.class, this.standortID);

        /*this.kennzeichen = (Kennzeichen) Carsharing.em.find(Kennzeichen.class, this.kennzeichenID);
        this.ausruestung = new Ausruestung[this.ausruestungIDs.length];
        for(int i = 0; i < this.ausruestungIDs.length; i++){
            this.ausruestung[i] = (Ausruestung) Carsharing.em.find(Ausruestung.class, this.ausruestungIDs[i]);
        }
        this.reifensatz = (Reifensatz) Carsharing.em.find(Reifensatz.class, this.reifensatzID);
        this.standort = (Standort) Carsharing.em.find(Standort.class, this.standortID);
        this.bilder = new Bild[this.bildIDs.length];
        for(int j =0; j < this.bildIDs.length; j++){
            this.bilder[j] = (Bild) Carsharing.em.find(Bild.class, this.bildIDs[j]);
        }*/
        this.fahrzeugklasse = Fahrzeugklasse.valueOf(this.fahrzeugklasseID);
    }


    @Override
    public Object getPrimaryKey() {
        return fahrzeugID;
    }

    @Override
    public Attribute[] getAttributeArray() {
        return new Attribute[0];
    }

    @Override
    public String getElementID() {
        return null;
    }

    @Override
    public String toString(){
        return hersteller + " " + this.modell + " " + this.standort.getAdresse().getOrt();
    }
}
