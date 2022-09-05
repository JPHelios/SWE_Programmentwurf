package model.buchung;

import lombok.Getter;
import lombok.Setter;
import model.fahrzeug.Fahrzeugklasse;

import java.util.UUID;

@Getter
@Setter
public class Rabattaktion {
    private String rabattaktionID;

    private int preisnachlass;
    private String beschreibung;
    private Fahrzeugklasse[] aktionsKlassen;

    public Rabattaktion(){
        this.rabattaktionID = UUID.randomUUID().toString();
    }

}
