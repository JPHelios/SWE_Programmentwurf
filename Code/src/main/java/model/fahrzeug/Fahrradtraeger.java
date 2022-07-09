package model.fahrzeug;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fahrradtraeger extends Ausruestung {
    private int anzahlFahrraeder;
    private String montierung;
    private int maximalGewicht;

    public Fahrradtraeger(){

    }
}
