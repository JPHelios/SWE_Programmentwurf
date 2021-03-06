package util;

import model.fahrzeug.Dachbox;
import model.fahrzeug.Fahrzeug;

public class DachboxBuilder {
    private Dachbox d;

    public DachboxBuilder(){
        d = new Dachbox();
    }

    public DachboxBuilder name(String n){
        d.setName(n);
        return this;
    }

    public DachboxBuilder beschreibung(String b){
        d.setBeschreibung(b);
        return this;
    }

    public DachboxBuilder kompatibel(Fahrzeug[] f){
        d.setKompatibel(f);
        return this;
    }

    public DachboxBuilder volumen(float v){
        d.setVolumen(v);
        return this;
    }

    public DachboxBuilder hoehe(float h){
        d.setHoehe(h);
        return this;
    }

    public Dachbox build(){
        return d;
    }
}
