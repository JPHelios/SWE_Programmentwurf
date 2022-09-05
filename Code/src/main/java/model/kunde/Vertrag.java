package model.kunde;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
public class Vertrag implements IPersistable {
    private String vertragID;

    private String pfad;
    private Date datum;

    public Vertrag(){
        this.vertragID = UUID.randomUUID().toString();
    }

    @Override
    public Object getPrimaryKey() {
        return vertragID;
    }
}
