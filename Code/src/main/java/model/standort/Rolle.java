package model.standort;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Rolle implements IPersistable {
    private String rolleID;

    private String bezeichnung;
    private Object[] berechtigt;

    public Rolle(){
        this.rolleID = UUID.randomUUID().toString();
    }

    @Override
    public Object getPrimaryKey() {
        return rolleID;
    }
}
