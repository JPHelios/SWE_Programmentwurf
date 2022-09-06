package util;

import app.Carsharing;
import model.fahrzeug.Ausruestung;
import model.fahrzeug.Fahrzeug;
import model.fahrzeug.Kennzeichen;
import model.fahrzeug.Reifensatz;
import model.standort.Standort;
import model.utils.Bild;

public class FahrzeugBuilder {
    private Fahrzeug f;

    public FahrzeugBuilder(){
        f = new Fahrzeug();
    }

    public FahrzeugBuilder kennzeichen(String kID){
        f.setKennzeichenID(kID);
        Kennzeichen k = (Kennzeichen) Carsharing.em.find(Kennzeichen.class, kID);
        f.setKennzeichen(k);
        return this;
    }

    public FahrzeugBuilder reifensatz(String rsID){
        f.setReifensatzID(rsID);
        Reifensatz rs = (Reifensatz) Carsharing.em.find(Reifensatz.class, rsID);
        f.setReifensatz(rs);
        return this;
    }

    public FahrzeugBuilder bilder(String[] bIDs){
        f.setBildIDs(bIDs);
        Bild[] b = new Bild[3];
        for (int i = 0; i<bIDs.length; i++){
            b[i] = (Bild) Carsharing.em.find(Bild.class, bIDs[i]);
        }
        f.setBilder(b);
        return this;
    }

    public FahrzeugBuilder ausruestung(String[] aIDs){
        f.setAusruestungIDs(aIDs);
        Ausruestung[] a = new Ausruestung[aIDs.length];
        for (int i = 0; i<aIDs.length; i++){
            a[i] = (Ausruestung) Carsharing.em.find(Ausruestung.class, aIDs[i]);
        }
        f.setAusruestung(a);
        return this;
    }

    public FahrzeugBuilder standort(String sID){
        f.setStandortID(sID);
        Standort s = (Standort) Carsharing.em.find(Standort.class, sID);
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
