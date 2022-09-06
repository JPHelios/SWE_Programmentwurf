package util;

import app.Carsharing;
import model.buchung.Rabattaktion;
import model.fahrzeug.Ausruestung;
import model.fahrzeug.Fahrzeugklasse;

public class RabattaktionBuilder {
    private Rabattaktion r;

    public RabattaktionBuilder(){
        r = new Rabattaktion();
    }

    public RabattaktionBuilder rabatt(int rab){
        r.setPreisnachlass(rab);
        return this;
    }

    public RabattaktionBuilder beschreibung(String b){
        r.setBeschreibung(b);
        return this;
    }

    public RabattaktionBuilder aktionsklassen(String[] aIDs){
        r.setAktionsKlassenIDs(aIDs);
        Fahrzeugklasse[] a = new Fahrzeugklasse[aIDs.length];
        for (int i = 0; i<aIDs.length; i++){
            a[i] = Fahrzeugklasse.valueOf(aIDs[i]);
        }
        r.setAktionsKlassen(a);
        return this;
    }

    public Rabattaktion build(){
        return r;
    }
}
