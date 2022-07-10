package model.kunde;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Vertrag implements IPersistable {
    private int vertragID;

    private String pfad;
    private Date datum;

    public Vertrag(){

    }

    @Override
    public Object getPrimaryKey() {
        return vertragID;
    }
}
