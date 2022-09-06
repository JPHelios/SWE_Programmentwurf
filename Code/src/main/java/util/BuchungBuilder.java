package util;
import app.Carsharing;
import model.buchung.Buchung;
import model.fahrzeug.Fahrzeug;
import model.kunde.Kunde;
import model.standort.Mitarbeiter;

import java.util.Date;

public class BuchungBuilder {
    private Buchung b;

    public BuchungBuilder(){
        b = new Buchung();
    }

    public BuchungBuilder kunde(String kID){
        b.setKundeID(kID);
        Kunde k = (Kunde) Carsharing.em.find(Kunde.class, kID);
        b.setKunde(k);
        return this;
    }

    public BuchungBuilder starttermin(Date t){
        b.setStarttermin(t);
        return this;
    }

    public BuchungBuilder endtermin(Date t) {
        b.setEndtermin(t);
        return this;
    }

    public BuchungBuilder fahrzeug(String fID){
        b.setFahrzeugID(fID);
        Fahrzeug f = (Fahrzeug) Carsharing.em.find(Fahrzeug.class, fID);
        b.setFahrzeug(f);
        return this;
    }

    public BuchungBuilder mitarbeiter(String mID){
        b.setMitarbeiterID(mID);
        Mitarbeiter m = (Mitarbeiter) Carsharing.em.find(Mitarbeiter.class, mID);
        b.setMitarbeiter(m);
        return this;
    }

    public BuchungBuilder abgebrochen(Boolean c){
        b.setCanceled(c);
        return this;
    }

    public Buchung build(){
        return b;
    }
}
