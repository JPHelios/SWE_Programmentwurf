package model.kunde;

import app.Carsharing;
import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
public class Vertrag implements IPersistable {
    private String vertragID;

    private String pfad;
    private Date datum;
    private Kunde kunde;
    private String kundeID;

    public Vertrag(){
        this.vertragID = UUID.randomUUID().toString();
    }

    public Vertrag(String[] props){
        this.vertragID = props[0];
        this.pfad = props[1];
        this.datum = new Date(Integer.parseInt(props[2]));
        this.kundeID = props[3];

        //this.kunde = (Kunde) Carsharing.em.find(Kunde.class, this.kundeID);
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.vertragID, this.pfad, String.valueOf(this.datum.getTime()), this.kundeID};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return vertragID;
    }
}
