package model.fahrzeug;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reifen {
    private int reifenID;

    private String hersteller;
    private String modell;
    private int jahr;
    private String txp;

    public Reifen(){

    }
}
