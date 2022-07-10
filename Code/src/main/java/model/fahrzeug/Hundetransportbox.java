package model.fahrzeug;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hundetransportbox extends Ausruestung implements IPersistable {
    private int hundetransportboxID;
    private String[] hundekompatibilitaet;
    private int anzahlHunde;

    public Hundetransportbox(){

    }

    @Override
    public Object getPrimaryKey() {
        return hundetransportboxID;
    }
}
