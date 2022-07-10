package util;

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

    public FahrradtraegerBuilder kompatibel(Fahrzeug[] fz){
        f.setKompatibel(fz);
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
