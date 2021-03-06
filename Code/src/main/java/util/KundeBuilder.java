package util;

import model.buchung.Buchung;
import model.kunde.Kunde;
import model.kunde.Vertrag;
import model.utils.Adresse;

public class KundeBuilder {
    private Kunde k;

    public KundeBuilder(){
        k = new Kunde();
    }

    public KundeBuilder nachname(String n){
        k.setNachname(n);
        return this;
    }

    public KundeBuilder vorname(String v){
        k.setVorname(v);
        return this;
    }

    public KundeBuilder telefon(String t){
        k.setTelefon(t);
        return this;
    }

    public KundeBuilder email(String e){
        k.setEmail(e);
        return this;
    }

    public KundeBuilder addBuchung(Buchung b){
        Buchung[] buchungen = k.getBuchungen();
        int i;
        Buchung[] nb = new Buchung[buchungen.length + 1];
        for(i = 0; i<buchungen.length; i++){
            nb[i]=buchungen[i];
        }
        nb[i]=b;
        k.setBuchungen(nb);
        return this;
    }

    public KundeBuilder vertrag(Vertrag v){
        k.setVertrag(v);
        return this;
    }

    public KundeBuilder adresse(Adresse a){
        k.setAdresse(a);
        return this;
    }

    public Kunde build(){
        return k;
    }
}
