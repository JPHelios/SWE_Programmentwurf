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

    public Fahrradtraeger(){
        this.fahrradtraegerID = UUID.randomUUID().toString();
    }

    @Override
    public Object getPrimaryKey() {
        return fahrradtraegerID;
    }
}
