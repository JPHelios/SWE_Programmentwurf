package model.fahrzeug;

import app.Carsharing;
import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Reifensatz implements IPersistable {
    private String reifensatzID;

    private Reifen[] reifensatz = new Reifen[4];
    private String[] reifenIDs;
    private Reifen ersatzrad;
    private String ersatzradID;

    public Reifensatz(){
        this.reifensatzID = UUID.randomUUID().toString();
    }

    public Reifensatz(String[] props){
        this.reifensatzID = props[0];
        this.reifenIDs = props[1].split(",");
        this.ersatzradID = props[2];

        /*for (int i = 0; i<4; i++){
            this.reifensatz[i] = (Reifen) Carsharing.em.find(Reifen.class, this.reifenIDs[i]);
        }
        this.ersatzrad = (Reifen) Carsharing.em.find(Reifen.class, this.ersatzradID);*/
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.reifensatzID, String.join(",", this.reifenIDs), this.ersatzradID};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return reifensatzID;
    }
}
