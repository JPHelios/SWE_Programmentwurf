package model.fahrzeug;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fahrzeugklasse {
    private String name;
    private int preis;
    private String beschreibung;
    private String führerschein;
    private Fahrzeug[] fahrzeuge;

    public void Fahrzeugklasse(){

    }
}
