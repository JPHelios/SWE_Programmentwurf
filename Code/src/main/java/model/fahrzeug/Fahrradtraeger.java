package model.fahrzeug;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fahrradtraeger extends Ausruestung implements IPersistable {
    private int fahrradtraegerID;
    private int anzahlFahrraeder;
    private String montierung;
    private int maximalGewicht;

    public Fahrradtraeger(){

    }

    @Override
    public Object getPrimaryKey() {
        return fahrradtraegerID;
    }
}
