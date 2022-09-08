package util;

import model.buchung.Buchung;
import model.buchung.Rabattaktion;
import model.buchung.Rechnung;
import model.utils.Adresse;
import model.utils.Bild;

import java.util.Date;

public class EntityFactory {

    public Bild createBild(String pfad, String titel) {
        return new Bild(pfad, titel);
    }

    public Adresse createAdresse(String[] args){
        Adresse a = new Adresse();

        a.setStrasse(args[0]);
        a.setHausnummer(args[1]);
        a.setPlz(args[2]);
        a.setOrt(args[3]);
        a.setZusatz(args[4]);

        return a;
    }

    public Rechnung createRechnung(Buchung b, Rabattaktion r){
        Rechnung rechnung = new Rechnung();

        float preisProTag = b.getFahrzeug().getFahrzeugklasse().getPreis();
        double tage = Math.ceil((b.getEndtermin().getTime() - b.getStarttermin().getTime())/1000/60/60/24);
        double betrag = preisProTag * tage * ((100d-r.getPreisnachlass())/100);

        rechnung.setBetrag(betrag);
        rechnung.setPfad("/");
        rechnung.setFaelligkeitsDatum(new Date(b.getEndtermin().getTime() + 1000 * 60 * 60 * 24 * 30));
        rechnung.setBuchung(b);
        rechnung.setBuchungID(b.getBuchungID());
        rechnung.setEvent(r);
        rechnung.setEventID(r.getRabattaktionID());

        return rechnung;
    }

}
