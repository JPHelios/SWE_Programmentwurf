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
    private String[] berechtigt;

    public Rolle(){
        this.rolleID = UUID.randomUUID().toString();
    }

    public Rolle(String[] props){
        this.rolleID = props[0];
        this.bezeichnung = props[1];
        this.berechtigt = props[2].split(",");
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.rolleID, this.bezeichnung, String.join(",", this.berechtigt)};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return rolleID;
    }
}
