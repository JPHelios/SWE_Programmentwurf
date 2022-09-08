package model.kunde;

import app.Carsharing;
import de.dhbwka.swe.utils.model.Attribute;
import de.dhbwka.swe.utils.model.IDepictable;
import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;
import model.buchung.Buchung;
import model.utils.Adresse;

import java.util.UUID;

@Setter
@Getter
public class Kunde implements IPersistable, IDepictable{
    private String kundeID;

    private String nachname;
    private String vorname;
    private String telefon;
    private String email;
    private Vertrag vertrag;
    private Adresse adresse;
    private Buchung[] buchungen;
    private String vertragID;
    private String adresseID;
    private String[] buchungIDs;

    public Kunde(){
        this.kundeID = UUID.randomUUID().toString();
    }

    public Kunde(String[] props){
        this.kundeID = props[0];
        this.nachname = props[1];
        this.vorname = props[2];
        this.telefon = props[3];
        this.email = props[4];
        this.vertragID = props[5];
        this.adresseID = props[6];
        this.buchungIDs = props[7].split(",");

        /*this.vertrag = (Vertrag) Carsharing.em.find(Vertrag.class, this.vertragID);
        this.adresse = (Adresse) Carsharing.em.find(Adresse.class, this.adresseID);
        this.buchungen = new Buchung[this.buchungIDs.length];
        for(int i = 0; i < this.buchungIDs.length; i++){
            this.buchungen[i] = (Buchung) Carsharing.em.find(Buchung.class, this.buchungIDs[i]);
        }*/
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.kundeID, this.nachname, this.vorname, this.telefon, this.email, this.vertragID, this.adresseID, String.join(",", this.buchungIDs)};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return kundeID;
    }

    @Override
    public String getElementID() {
        return null;
    }

    @Override
    public Attribute[] getAttributeArray() {
        return new Attribute[0];
    }
}
