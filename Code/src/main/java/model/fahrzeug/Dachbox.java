package model.fahrzeug;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Dachbox extends Ausruestung implements IPersistable {
    private String dachboxID;
    private float volumen;
    private float hoehe;

    public Dachbox(){
        this.dachboxID = UUID.randomUUID().toString();
    }

    @Override
    public Object getPrimaryKey() {
        return dachboxID;
    }
}
