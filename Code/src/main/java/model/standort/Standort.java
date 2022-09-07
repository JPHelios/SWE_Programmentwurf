package model.standort;

import app.Carsharing;
import database.EntityManager;
import de.dhbwka.swe.utils.model.Attribute;
import de.dhbwka.swe.utils.model.IDepictable;
import de.dhbwka.swe.utils.model.IPersistable;
import model.fahrzeug.Fahrzeug;
import model.utils.Adresse;
import model.utils.Bild;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import static java.lang.Integer.parseInt;

@Getter
@Setter
public class Standort implements IPersistable, IDepictable {
    private String standortID;

    private int anzahlPlaetze;
    private int anzahlSaeulen;
    private Fahrzeug[] fahrzeuge;
    private String[] fahrzeugIDs;
    private Filiale filiale;
    private String filialeID;
    private String bildID;
    private Bild bild;
    private String adresseID;
    private Adresse adresse;


    public Standort(){
        this.standortID = UUID.randomUUID().toString();
    }

    public Standort(String[] props){
        this.standortID = props[0];
        this.anzahlPlaetze = parseInt(props[1]);
        this.anzahlSaeulen = parseInt(props[2]);
        this.fahrzeugIDs = props[3].split(",");
        this.filialeID = props[4];
        this.bildID = props[5];
        this.adresseID = props[6];

        this.adresse = (Adresse) Carsharing.em.find(Adresse.class, this.adresseID);

        /*this.bild = (Bild) Carsharing.em.find(Bild.class, this.bildID);
        this.adresse = (Adresse) Carsharing.em.find(Adresse.class, this.adresseID);
        this.fahrzeuge = new Fahrzeug[this.fahrzeugIDs.length];
        for(int i = 0; i < this.fahrzeugIDs.length; i++){
            this.fahrzeuge[i] = (Fahrzeug) Carsharing.em.find(Fahrzeug.class, this.fahrzeugIDs[i]);
        }
        this.filialen = new Filiale[this.filialenIDs.length];
        for(int j = 0; j< this.filialenIDs.length; j++){
            this.filialen[j] = (Filiale) Carsharing.em.find(Filiale.class, this.filialenIDs[j]);
        }*/
    }

    public String[] toStringArray(){
        String[] arr = {this.standortID, String.valueOf(this.anzahlPlaetze), String.valueOf(this.anzahlSaeulen), String.join(",", this.fahrzeugIDs), String.join(",", this.filialeID), this.bildID, this.adresseID};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return standortID;
    }

    @Override
    public String getElementID() {
        return null;
    }

    @Override
    public Attribute[] getAttributeArray() {
        return new Attribute[0];
    }

    @Override
    public String toString(){
        return this.adresse.toString() + " | Filiale: ";
    }
}
