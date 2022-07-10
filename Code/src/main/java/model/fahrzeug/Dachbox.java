package model.fahrzeug;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dachbox extends Ausruestung implements IPersistable {
    private int dachboxID;
    private float volumen;
    private float hoehe;

    public Dachbox(){

    }

    @Override
    public Object getPrimaryKey() {
        return dachboxID;
    }
}
