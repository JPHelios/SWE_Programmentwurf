package model.fahrzeug;
import de.dhbwka.swe.utils.model.IPersistable;
import model.standort.Standort;
import model.utils.Bild;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fahrzeug implements IPersistable {
    private int fahrzeugID;

    private String hersteller;
    private String modell;
    private int baujahr;
    private boolean status;
    private int kilometerstand;
    private boolean reserviert;
    private Kennzeichen kennzeichen;
    private Ausruestung[] ausruestung;
    private Reifensatz reifensatz;
    private Standort standort;
    private Bild[] bilder = new Bild[3];
    private Fahrzeugklasse fahrzeugklasse;

    public Fahrzeug(){

    }


    @Override
    public Object getPrimaryKey() {
        return fahrzeugID;
    }
}
