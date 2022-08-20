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
    private Bild bild;
    private Adresse adresse;

    public Standort(){

    }

    public Standort(String[] props){
        this.standortID = props[0];
        this.anzahlPlaetze = parseInt(props[1]);
        this.anzahlSaeulen = parseInt(props[2]);
        //this.bild = EntityManager.find(Bild, props[3])
        //this.adresse = EntityManager.find(Adresse, props[4])
        System.out.println("success");
    }

    @Override
    public Object getPrimaryKey() {
        return standortID;
    }
}
