package model.fahrzeug;
import model.standort.Standort;
import model.utils.Bild;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fahrzeug {
    private String hersteller;
    private String modell;
    private int baujahr;
    private boolean status;
    private int kilometerstand;
    private boolean reserviert;
    private Kennzeichen kennzeichen;
    private Ausrüstung[] ausrüstung;
    private Reifensatz reifensatz;
    private Standort standort;
    private Bild[] bilder;

    public void Fahrzeug(){

    }


}
