package util;

import model.fahrzeug.Fahrzeug;
import model.standort.Filiale;
import model.standort.Standort;
import model.utils.Backup;

public class StandortBuilder {
    private Standort s;

    public StandortBuilder(){
        s = new Standort();
    }

    public StandortBuilder addFiliale(Filiale f){
        Filiale[] filialen = s.getFilialen();
        int i;
        Filiale[] nf = new Filiale[filialen.length + 1];
        for(i = 0; i<filialen.length; i++){
            nf[i]=filialen[i];
        }
        nf[i]=f;
        s.setFilialen(nf);
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

    public Standort build(){
        return s;
    }
}
