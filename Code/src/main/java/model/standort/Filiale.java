package model.standort;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Filiale implements IPersistable {
    private String filialeID;

    private String[] oeffnungszeiten = new String[7];
    private Mitarbeiter[] mitarbeiter;
    private Standort standort;

    public Filiale(){
        this.filialeID = UUID.randomUUID().toString();
    }

    public String[] toStringArray(){
        String arr[] = new String[]{};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return filialeID;
    }
}
