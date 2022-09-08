package model.standort;

import app.Carsharing;
import de.dhbwka.swe.utils.model.Attribute;
import de.dhbwka.swe.utils.model.IDepictable;
import de.dhbwka.swe.utils.model.IPersistable;
import model.utils.Backup;
import model.buchung.Buchung;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Mitarbeiter implements IPersistable, IDepictable {
    private String mitarbeiterID;

    private String nachname;
    private String vorname;
    private String tel;
    private String mail;
    private String passwort;
    private Rolle rolle;
    private String rolleID;
    private Filiale filiale;
    private String filialeID;
    private Buchung[] buchungen;
    private Backup[] backups;
    private String[] backupIDs;
    private String[] buchungIDs;

    public Mitarbeiter(){
        this.mitarbeiterID = UUID.randomUUID().toString();
    }

    public Mitarbeiter(String[] props){
        this.mitarbeiterID = props[0];
        this.nachname = props[1];
        this.vorname = props[2];
        this.tel = props[3];
        this.mail = props[4];
        this.passwort = props[5];
        this.rolleID = props[6];
        this.filialeID = props[7];
        this.backupIDs = props[8].split(",");
        this.buchungIDs = props[9].split(",");

        /*this.rolle = (Rolle) Carsharing.em.find(Rolle.class, this.rolleID);
        this.filiale = (Filiale) Carsharing.em.find(Filiale.class, this.filialeID);
        this.backups = new Backup[this.backupIDs.length];
        for(int i = 0; i < this.backupIDs.length; i++){
            this.backups[i] = (Backup) Carsharing.em.find(Backup.class, this.backupIDs[i]);
        }
        this.buchungen = new Buchung[this.buchungIDs.length];
        for(int j = 0; j < this.buchungIDs.length; j++){
            this.buchungen[j] = (Buchung) Carsharing.em.find(Buchung.class, this.buchungIDs[j]);
        }*/
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.mitarbeiterID, this.nachname, this.vorname, this.tel, this.mail, this.passwort, this.rolleID, this.filialeID, String.join(",", this.backupIDs), String.join(",", this.buchungIDs) };
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return mitarbeiterID;
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
        return this.mitarbeiterID + " | " + this.nachname + ", " + this.vorname;
    }
}
