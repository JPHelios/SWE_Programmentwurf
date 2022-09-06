package model.buchung;

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

    public String[] toStringArray(){
        String arr[] = new String[]{this.rechnungID, this.faelligkeitsDatum.toString(), this.pfad, this.buchungID, this.eventID};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return this.rechnungID;
    }
}
