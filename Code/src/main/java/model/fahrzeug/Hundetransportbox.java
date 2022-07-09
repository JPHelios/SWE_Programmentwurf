package model.fahrzeug;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hundetransportbox extends Ausruestung {
    private String[] hundekompatibilitaet;
    private int anzahlHunde[];

    public Hundetransportbox(){

    }
}
