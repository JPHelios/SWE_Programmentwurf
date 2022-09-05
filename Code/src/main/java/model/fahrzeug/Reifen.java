package model.fahrzeug;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Reifen implements IPersistable {
    private String reifenID;

    private String hersteller;
    private String modell;
    private int jahr;
    private String txp;

    public Reifen(){
        this.reifenID = UUID.randomUUID().toString();
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.reifenID, this.hersteller, this.modell, String.valueOf(this.jahr), this.txp};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return reifenID;
    }
}
