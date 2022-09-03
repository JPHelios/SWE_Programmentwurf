package model.standort;

import de.dhbwka.swe.utils.model.IPersistable;
import model.fahrzeug.Fahrzeug;
import model.utils.Adresse;
import model.utils.Bild;

import lombok.Getter;
import lombok.Setter;

import static java.lang.Integer.parseInt;

@Getter
@Setter
public class Standort implements IPersistable {
    private String standortID;

    private int anzahlPlaetze;
    private int anzahlSaeulen;
    private Fahrzeug[] fahrzeuge;
    private Filiale[] filialen;
    private String bildID;
    private Bild bild;
    private String adresseID;
    private Adresse adresse;


    public Standort(){

    }

    public Standort(String[] props){
        this.standortID = props[0];
        this.anzahlPlaetze = parseInt(props[1]);
        this.anzahlSaeulen = parseInt(props[2]);
        this.bildID = props[3];
        this.adresseID = props[4];
        //this.bild = EntityManager.find(Bild, this.bildId)
        //this.adresse = EntityManager.find(Adresse, this.adresseID)
        System.out.println("success");
    }

    public String[] toStringArray(){
        String[] arr = {this.standortID, String.valueOf(this.anzahlPlaetze), String.valueOf(this.anzahlSaeulen), this.bildID, this.adresseID};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return standortID;
    }
}
