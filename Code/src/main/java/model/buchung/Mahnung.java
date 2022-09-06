package model.buchung;

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

    public String[] toStringArray(){
        String arr[] = new String[]{this.mahnungID, String.valueOf(this.betrag), this.faelligkeitsDatum.toString(), String.valueOf(this.anzahl), this.buchungID};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return this.mahnungID;
    }
}
