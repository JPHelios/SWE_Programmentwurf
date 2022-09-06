package util;

import app.Carsharing;
import model.fahrzeug.Fahrradtraeger;
import model.fahrzeug.Fahrzeug;

public class FahrradtraegerBuilder {
    private Fahrradtraeger f;

    public FahrradtraegerBuilder(){
        f = new Fahrradtraeger();
    }

    public FahrradtraegerBuilder name(String n){
        f.setName(n);
        return this;
    }

    public FahrradtraegerBuilder beschreibung(String b){
        f.setBeschreibung(b);
        return this;
    }

    public FahrradtraegerBuilder kompatibel(String[] fzIDs){
        f.setKompatibelIDs(fzIDs);
        Fahrzeug[] fz = new Fahrzeug[fzIDs.length];
        for (int i = 0; i<fzIDs.length; i++){
            fz[i] = (Fahrzeug) Carsharing.em.find(Fahrzeug.class, fzIDs[i]);
        }
        f.setKompatibel(fz);
        return this;
    }

    public FahrradtraegerBuilder fahrzeug(String fzID){
            f.setFahrzeugID(fzID);
            Fahrzeug fz = (Fahrzeug) Carsharing.em.find(Fahrzeug.class, fzID);
            f.setFahrzeug(fz);
        return this;
    }

    public FahrradtraegerBuilder anzahlFahrraeder(int a){
        f.setAnzahlFahrraeder(a);
        return this;
    }

    public FahrradtraegerBuilder montierung(String m){
        f.setMontierung(m);
        return this;
    }

    public FahrradtraegerBuilder maximalGewicht(int mg){
        f.setMaximalGewicht(mg);
        return this;
    }

    public Fahrradtraeger build(){
        return f;
    }
}
