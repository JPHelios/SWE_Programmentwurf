package util;

import model.utils.Adresse;
import model.utils.Bild;

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

}
