package model.buchung;

import app.Carsharing;
import de.dhbwka.swe.utils.model.Attribute;
import de.dhbwka.swe.utils.model.IDepictable;
import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Rechnung  implements IPersistable, IDepictable {
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
        this.betrag = Double.parseDouble(props[1]);
        this.faelligkeitsDatum = new Date(Integer.parseInt(props[2]));
        this.pfad = props[3];
        this.buchungID = props[4];
        this.eventID = props[5];

        this.buchung = (Buchung) Carsharing.em.find(Buchung.class, this.buchungID);
        this.event = (Rabattaktion) Carsharing.em.find(Rabattaktion.class, this.eventID);
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.rechnungID, String.valueOf(this.betrag), String.valueOf(this.faelligkeitsDatum.getTime()), this.pfad, this.buchungID, this.eventID};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return this.rechnungID;
    }

    @Override
    public String getElementID() {
        return null;
    }

    @Override
    public Attribute[] getAttributeArray() {
        return new Attribute[0];
    }

    @Override
    public String toString(){
        return rechnungID + " | " + buchung.getKunde().getNachname() + ", " + buchung.getKunde().getVorname() + " | Betrag: " + betrag + " €";
    }
}
