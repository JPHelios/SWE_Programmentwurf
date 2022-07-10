package model.fahrzeug;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reifen implements IPersistable {
    private int reifenID;

    private String hersteller;
    private String modell;
    private int jahr;
    private String txp;

    public Reifen(){

    }

    @Override
    public Object getPrimaryKey() {
        return reifenID;
    }
}
