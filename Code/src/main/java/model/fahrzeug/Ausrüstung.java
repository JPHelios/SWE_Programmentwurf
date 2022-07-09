package model.fahrzeug;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ausrüstung {
    private String name;
    private String beschreibung;
    private Fahrzeug[] kompatibel;
    private Fahrzeug fahzeug;

    public void Ausrüstung(){

    }
}
