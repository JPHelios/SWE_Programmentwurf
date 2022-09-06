package model.fahrzeug;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Fahrradtraeger extends Ausruestung implements IPersistable {
    private String fahrradtraegerID;
    private int anzahlFahrraeder;
    private String montierung;
    private int maximalGewicht;
    private String name;
    private String beschreibung;
    private Fahrzeug[] kompatibel;
    private String[] kompatibelIDs;

    public Fahrradtraeger(){
        this.fahrradtraegerID = UUID.randomUUID().toString();
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.fahrradtraegerID, String.valueOf(this.anzahlFahrraeder), this.montierung, String.valueOf(this.maximalGewicht), this.name, this.beschreibung, String.join(",", this.kompatibelIDs)};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return fahrradtraegerID;
    }
}
