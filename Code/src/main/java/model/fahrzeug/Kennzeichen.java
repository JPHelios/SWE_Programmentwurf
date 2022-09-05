package model.fahrzeug;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Kennzeichen implements IPersistable {
    private String kennzeichenID;

    private String kennzeichen;
    private String zulassungstelle;

    public Kennzeichen(){
        this.kennzeichenID = UUID.randomUUID().toString();
    }

    @Override
    public Object getPrimaryKey() {
        return kennzeichenID;
    }
}
