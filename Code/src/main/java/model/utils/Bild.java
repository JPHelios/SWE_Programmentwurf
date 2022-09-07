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


    public Bild(String pfad, String titel){
        this.bildID = UUID.randomUUID().toString();
        this.pfad = pfad;
        this.titel = titel;
    }

    public Bild(String[] props){
        this.bildID = props[0];
        this.pfad = props[1];
        this.titel = props[2];
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.bildID, this.pfad, this.titel};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return bildID;
    }
}
