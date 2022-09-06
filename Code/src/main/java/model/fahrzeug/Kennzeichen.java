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
    private String zulassungstelle = "Karlsruhe";

    public Kennzeichen(String kennzeichen){
        this.kennzeichenID = UUID.randomUUID().toString();
        this.kennzeichen = kennzeichen;
        //this.zulassungstelle = zulassungstelle;
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.kennzeichenID, this.kennzeichen, this.zulassungstelle};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return kennzeichenID;
    }
}
