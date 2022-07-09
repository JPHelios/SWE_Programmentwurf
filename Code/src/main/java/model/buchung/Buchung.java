package model.buchung;


import lombok.Getter;
import lombok.Setter;
import model.fahrzeug.Fahrzeug;

import java.sql.Array;
import java.util.Date;

@Getter
@Setter
public class Buchung {
    private int buchungID;

    private boolean canceled;
    private Date starttermin;
    private Date endtermin;

    private Fahrzeug fahrzeug;
    private Rechnung abrechnung;
    private Mahnung[] aufforderung;

    public Buchung(){

    }

}
