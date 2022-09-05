package model.utils;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Bild implements IPersistable {
    private String bildID;

    private String pfad;
    private String titel;

    public Bild(){
        this.bildID = UUID.randomUUID().toString();
    }

    @Override
    public Object getPrimaryKey() {
        return bildID;
    }
}
