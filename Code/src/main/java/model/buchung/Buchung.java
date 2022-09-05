package model.buchung;


import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;
import model.fahrzeug.Fahrzeug;
import model.kunde.Kunde;
import model.standort.Mitarbeiter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Buchung implements IPersistable {
    private String buchungID;

    private boolean canceled;
    private Date starttermin;
    private Date endtermin;

    private Fahrzeug fahrzeug;
    private Rechnung abrechnung;
    private Mahnung[] aufforderung;
    private Kunde kunde;
    private Mitarbeiter mitarbeiter;

    public Buchung(){
        this.buchungID = UUID.randomUUID().toString();
    }

    public String[] toStringArray(){
        String arr[] = new String[]{};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return this.buchungID;
    }
}
