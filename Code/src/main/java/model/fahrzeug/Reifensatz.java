package model.fahrzeug;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reifensatz implements IPersistable {
    private int reifensatzID;

    private Reifen[] reifensatz = new Reifen[4];
    private Reifen ersatzrad;

    public Reifensatz(){

    }

    @Override
    public Object getPrimaryKey() {
        return reifensatzID;
    }
}
