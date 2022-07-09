package model.buchung;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Rechnung {

    private double betrag;
    private Date faelligkeitsDatum;
    private String pfad;

    private Buchung rechnungsgrundlage;
    private Rabattaktion event;

    public Rechnung(){

    }
}
