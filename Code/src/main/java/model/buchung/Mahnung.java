package model.buchung;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Mahnung {
    private int mahnungID;

    private double betrag;
    private Date faelligkeitsDatum;
    private int anzahl;

    private Buchung mahnungsgrund;

    public Mahnung(){

    }


}
