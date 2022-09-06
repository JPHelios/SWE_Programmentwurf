package util;

import app.Carsharing;
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

    public BoxBuilder kompatibel(String[] fzIDs){
        h.setKompatibelIDs(fzIDs);
        Fahrzeug[] fz = new Fahrzeug[fzIDs.length];
        for (int i = 0; i<fzIDs.length; i++){
            fz[i] = (Fahrzeug) Carsharing.em.find(Fahrzeug.class, fzIDs[i]);
        }
        h.setKompatibel(fz);
        return this;
    }

    public BoxBuilder fahrzeug(String fzID){
        h.setFahrzeugID(fzID);
        Fahrzeug fz = (Fahrzeug) Carsharing.em.find(Fahrzeug.class, fzID);
        h.setFahrzeug(fz);
        return this;
    }

    public BoxBuilder hundekompatibilität(String[] hk){
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
