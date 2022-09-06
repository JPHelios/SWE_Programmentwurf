package model.fahrzeug;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ausruestung {
    private String name;
    private String beschreibung;
    private Fahrzeug[] kompatibel;
    private Fahrzeug fahrzeug;

    public Ausruestung(){

    }
}
