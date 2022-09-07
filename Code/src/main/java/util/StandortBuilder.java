package util;

import app.Carsharing;
import model.fahrzeug.Fahrzeug;
import model.standort.Filiale;
import model.standort.Standort;
import model.utils.Adresse;
import model.utils.Backup;
import model.utils.Bild;

public class StandortBuilder {
    private Standort s;

    public StandortBuilder(){
        s = new Standort();
    }

    public StandortBuilder filiale(Filiale f){
        s.setFiliale(f);
        return this;
    }

    public StandortBuilder addFahrzeug(Fahrzeug f){
        Fahrzeug[] fahrzeuge = s.getFahrzeuge();
        int i;
        Fahrzeug[] nf = new Fahrzeug[fahrzeuge.length + 1];
        for(i = 0; i<fahrzeuge.length; i++){
            nf[i]=fahrzeuge[i];
        }
        nf[i]=f;
        s.setFahrzeuge(nf);
        return this;
    }

    public StandortBuilder stellplaetze(int sp){
        s.setAnzahlPlaetze(sp);
        return this;
    }

    public StandortBuilder ladesaeulen(int l){
        s.setAnzahlSaeulen(l);
        return this;
    }

    public StandortBuilder adresse(String aID){
        s.setAdresseID(aID);
        Adresse a = (Adresse) Carsharing.em.find(Adresse.class, aID);
        s.setAdresse(a);
        return this;
    }

    public StandortBuilder bild(String bID){
        s.setBildID(bID);
        Bild b = (Bild) Carsharing.em.find(Bild.class, bID);
        s.setBild(b);
        return this;
    }


    public Standort build(){
        return s;
    }
}
