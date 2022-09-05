package model.buchung;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Rechnung {
    private String rechnungID;

    private double betrag;
    private Date faelligkeitsDatum;
    private String pfad;

    private Buchung rechnungsgrundlage;
    private Rabattaktion event;

    public Rechnung(){
        this.rechnungID = UUID.randomUUID().toString();
    }
}
