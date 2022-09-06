package util;

import model.fahrzeug.*;
import model.standort.Standort;
import model.utils.Bild;

public class FahrzeugBuilder {
    private Fahrzeug f;

    public FahrzeugBuilder(){
        f = new Fahrzeug();
    }

    public FahrzeugBuilder kennzeichen(Kennzeichen k){
        f.setKennzeichen(k);
        return this;
    }

    public FahrzeugBuilder reifensatz(Reifensatz rs){
        f.setReifensatz(rs);
        return this;
    }

    /*public FahrzeugBuilder fahrzeugklasse(Fahrzeugklassen fk){
        f.setFahrzeugklassen(fk);
        return this;
    }*/

    public FahrzeugBuilder bilder(Bild[] b){
        f.setBilder(b);
        return this;
    }

    public FahrzeugBuilder ausruestung(Ausruestung[] a){
        f.setAusruestung(a);
        return this;
    }

    public FahrzeugBuilder standort(Standort s){
        f.setStandort(s);
        return this;
    }

    public FahrzeugBuilder hersteller(String h){
        f.setHersteller(h);
        return this;
    }

    public FahrzeugBuilder modell(String m){
        f.setModell(m);
        return this;
    }

    public FahrzeugBuilder baujahr(int b){
        f.setBaujahr(b);
        return this;
    }

    public FahrzeugBuilder kilometerstand(int k){
        f.setKilometerstand(k);
        return this;
    }

    public FahrzeugBuilder status(Boolean s){
        f.setStatus(s);
        return this;
    }

    public Fahrzeug build(){
        return f;
    }
}
