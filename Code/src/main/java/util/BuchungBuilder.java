package util;
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

    public BuchungBuilder kunde(Kunde k){
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

    public BuchungBuilder fahrzeug(Fahrzeug f){
        b.setFahrzeug(f);
        return this;
    }

    public BuchungBuilder mitarbeiter(Mitarbeiter m){
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
