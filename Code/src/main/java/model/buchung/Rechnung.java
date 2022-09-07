package model.buchung;

import app.Carsharing;
import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Rechnung  implements IPersistable {
    private String rechnungID;

    private double betrag;
    private Date faelligkeitsDatum;
    private String pfad;

    private Buchung buchung;
    private String buchungID;
    private String eventID;
    private Rabattaktion event;

    public Rechnung(){
        this.rechnungID = UUID.randomUUID().toString();
    }

    public Rechnung(String[] props){
        this.rechnungID = props[0];
        this.faelligkeitsDatum = new Date(Integer.parseInt(props[1]));
        this.pfad = props[2];
        this.buchungID = props[3];
        this.eventID = props[4];

        //this.buchung = (Buchung) Carsharing.em.find(Buchung.class, this.buchungID);
        //this.event = (Rabattaktion) Carsharing.em.find(Rabattaktion.class, this.eventID);
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.rechnungID, String.valueOf(this.faelligkeitsDatum.getTime()), this.pfad, this.buchungID, this.eventID};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return this.rechnungID;
    }
}
