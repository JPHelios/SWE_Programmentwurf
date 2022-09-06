package util;

import model.fahrzeug.Fahrzeug;
import model.fahrzeug.Hundetransportbox;

public class BoxBuilder {
    private Hundetransportbox h;

    public BoxBuilder(){
        h = new Hundetransportbox();
    }

    public BoxBuilder name(String n){
        h.setName(n);
        return this;
    }

    public BoxBuilder beschreibung(String b){
        h.setBeschreibung(b);
        return this;
    }

    public BoxBuilder kompatibel(Fahrzeug[] f){
        h.setKompatibel(f);
        return this;
    }

    public BoxBuilder hundekompatibilitaet(String[] hk){
        h.setHundekompatibilitaet(hk);
        return this;
    }

    public BoxBuilder anzahlHunde(int a){
        h.setAnzahlHunde(a);
        return this;
    }

    public Hundetransportbox build(){
        return h;
    }
}
