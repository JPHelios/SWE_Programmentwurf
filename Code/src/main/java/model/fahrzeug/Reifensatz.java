package model.fahrzeug;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Reifensatz implements IPersistable {
    private String reifensatzID;

    private Reifen[] reifensatz = new Reifen[4];
    private Reifen ersatzrad;

    public Reifensatz(){
        this.reifensatzID = UUID.randomUUID().toString();
    }

    public String[] toStringArray(){
        String arr[] = new String[]{};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return reifensatzID;
    }
}
