package util;

import app.Carsharing;
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

    public DachboxBuilder kompatibel(String[] fzIDs){
        d.setKompatibelIDs(fzIDs);
        Fahrzeug[] fz = new Fahrzeug[fzIDs.length];
        for (int i = 0; i<fzIDs.length; i++){
            fz[i] = (Fahrzeug) Carsharing.em.find(Fahrzeug.class, fzIDs[i]);
        }
        d.setKompatibel(fz);
        return this;
    }

    public DachboxBuilder fahrzeug(String fzID){
        d.setFahrzeugID(fzID);
        Fahrzeug fz = (Fahrzeug) Carsharing.em.find(Fahrzeug.class, fzID);
        d.setFahrzeug(fz);
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
