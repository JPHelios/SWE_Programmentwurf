package model.fahrzeug;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fahrradtraeger extends Ausrüstung {
    private int anzahlFahrräder;
    private String montierung;
    private int maximalGewicht;

    public void Fahrradtraeger(){

    }
}
