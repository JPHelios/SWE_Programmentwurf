package util;

import model.buchung.Buchung;
import model.standort.Filiale;
import model.standort.Mitarbeiter;
import model.standort.Rolle;
import model.utils.Backup;

public class MitarbeiterBuilder {
    private Mitarbeiter m;

    public MitarbeiterBuilder(){
        m = new Mitarbeiter();
    }

    public MitarbeiterBuilder nachname(String n){
        m.setNachname(n);
        return this;
    }

    public MitarbeiterBuilder vorname(String v){
        m.setVorname(v);
        return this;
    }

    public MitarbeiterBuilder telefon(String t){
        m.setTel(t);
        return this;
    }

    public MitarbeiterBuilder email(String e){
        m.setMail(e);
        return this;
    }

    public MitarbeiterBuilder addBuchung(Buchung b){
        Buchung[] buchungen = m.getBuchungen();
        int i;
        Buchung[] nb = new Buchung[buchungen.length + 1];
        for(i = 0; i<buchungen.length; i++){
            nb[i]=buchungen[i];
        }
        nb[i]=b;
        m.setBuchungen(nb);
        return this;
    }

    public MitarbeiterBuilder passwort(String p){
        m.setPasswort(p);
        return this;
    }

    public MitarbeiterBuilder addBackup(Backup b){
        Backup[] backups = m.getBackups();
        int i;
        Backup[] nb = new Backup[backups.length + 1];
        for(i = 0; i<backups.length; i++){
            nb[i]=backups[i];
        }
        nb[i]=b;
        m.setBackups(nb);
        return this;
    }

    public MitarbeiterBuilder rolle(Rolle r){
        m.setRolle(r);
        return this;
    }

    public MitarbeiterBuilder filiale(Filiale f){
        m.setFiliale(f);
        return this;
    }

    public Mitarbeiter build(){
        return m;
    }
}
