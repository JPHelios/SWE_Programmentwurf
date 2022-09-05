package model.standort;

import de.dhbwka.swe.utils.model.IPersistable;
import model.utils.Backup;
import model.buchung.Buchung;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Mitarbeiter implements IPersistable {
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

    public String[] toStringArray(){
        String arr[] = new String[]{this.mitarbeiterID, this.nachname, this.vorname, this.tel, this.mail, this.passwort, this.rolleID, this.filialeID, String.join(",", this.backupIDs), String.join(",", this.buchungIDs) };
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return mitarbeiterID;
    }
}
