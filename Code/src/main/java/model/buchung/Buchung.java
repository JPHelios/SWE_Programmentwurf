package model.buchung;


import lombok.Getter;
import lombok.Setter;
import model.fahrzeug.Fahrzeug;
import model.kunde.Kunde;
import model.standort.Mitarbeiter;

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
    private Kunde kunde;
    private Mitarbeiter mitarbeiter;

    public Buchung(){

    }

}
