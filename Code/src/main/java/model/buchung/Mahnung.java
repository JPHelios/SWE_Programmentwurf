package model.buchung;

import app.Carsharing;
import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Mahnung implements IPersistable {
    private String mahnungID;

    private double betrag;
    private Date faelligkeitsDatum;
    private int anzahl;

    private Buchung buchung;
    private String buchungID;

    public Mahnung(){
        this.mahnungID = UUID.randomUUID().toString();
    }

    public Mahnung(String[] props){
        this.mahnungID = props[0];
        this.betrag = Double.parseDouble(props[1]);
        this.faelligkeitsDatum = new Date(Integer.parseInt(props[2]));
        this.anzahl = Integer.parseInt(props[3]);
        this.buchungID = props[4];

        //this.buchung = (Buchung) Carsharing.em.find(Buchung.class, this.buchungID);
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.mahnungID, String.valueOf(this.betrag), String.valueOf(this.faelligkeitsDatum.getTime()), String.valueOf(this.anzahl), this.buchungID};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return this.mahnungID;
    }
}
