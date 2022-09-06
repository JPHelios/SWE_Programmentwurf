package model.fahrzeug;
import de.dhbwka.swe.utils.model.Attribute;
import de.dhbwka.swe.utils.model.IDepictable;
import de.dhbwka.swe.utils.model.IPersistable;
import model.standort.Standort;
import model.utils.Bild;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Fahrzeug implements IPersistable, IDepictable {
    private String fahrzeugID;

    private String hersteller;
    private String modell;
    private int baujahr;
    private boolean status;
    private int kilometerstand;
    private boolean reserviert;
    private Kennzeichen kennzeichen;
    private String kennzeichenID;
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
        String arr[] = new String[]{this.fahrzeugID, this.hersteller, this.modell, String.valueOf(this.baujahr), String.valueOf(this.status), String.valueOf(this.kilometerstand), String.valueOf(this.reserviert), this.kennzeichenID, String.join(",", this.ausruestungIDs), this.reifensatzID, this.standortID, String.join(",", this.bildIDs), this.fahrzeugklasseID};
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
        return fahrzeugID + ": " + hersteller + " " + modell + " -> 10,50€" + " Buchen -> " + status;
    }
}
