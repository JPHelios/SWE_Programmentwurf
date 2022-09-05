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
    private Ausruestung[] ausruestung;
    private Reifensatz reifensatz;
    private Standort standort;
    private Bild[] bilder = new Bild[3];
    private Fahrzeugklasse fahrzeugklasse;

    public Fahrzeug(){
        this.fahrzeugID = UUID.randomUUID().toString();
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
