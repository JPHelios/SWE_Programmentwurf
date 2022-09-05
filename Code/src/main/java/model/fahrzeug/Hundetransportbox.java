package model.fahrzeug;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Hundetransportbox extends Ausruestung implements IPersistable {
    private String hundetransportboxID;
    private String[] hundekompatibilitaet;
    private int anzahlHunde;

    public Hundetransportbox(){
        this.hundetransportboxID = UUID.randomUUID().toString();
    }

    public String[] toStringArray(){
        String arr[] = new String[]{};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return hundetransportboxID;
    }
}
