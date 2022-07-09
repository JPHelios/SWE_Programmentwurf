package model.buchung;

import lombok.Getter;
import lombok.Setter;
import model.fahrzeug.Fahrzeugklasse;

@Getter
@Setter
public class Rabattaktion {
    private int rabattaktionID;

    private int preisnachlass;
    private String beschreibung;
    private Fahrzeugklasse[] aktionsKlassen;

    public Rabattaktion(){

    }

}
