package model.standort;

import de.dhbwka.swe.utils.model.IPersistable;
import model.utils.Backup;
import model.buchung.Buchung;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mitarbeiter implements IPersistable {
    private int mitarbeiterID;

    private String nachname;
    private String vorname;
    private  String tel;
    private String mail;
    private String passwort;
    private Rolle rolle;
    private Filiale filiale;
    private Backup[] backups;
    private Buchung[] buchungen;

    public Mitarbeiter(){

    }

    @Override
    public Object getPrimaryKey() {
        return mitarbeiterID;
    }
}
