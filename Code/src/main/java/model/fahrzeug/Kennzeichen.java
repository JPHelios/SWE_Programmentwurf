package model.fahrzeug;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Kennzeichen implements IPersistable {
    private int kennzeichenID;

    private String kennzeichen;
    private String zulassungstelle;

    public Kennzeichen(){

    }

    @Override
    public Object getPrimaryKey() {
        return kennzeichenID;
    }
}
