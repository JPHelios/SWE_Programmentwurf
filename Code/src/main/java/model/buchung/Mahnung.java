package model.buchung;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Mahnung {
    private String mahnungID;

    private double betrag;
    private Date faelligkeitsDatum;
    private int anzahl;

    private Buchung mahnungsgrund;

    public Mahnung(){
        this.mahnungID = UUID.randomUUID().toString();
    }


}
