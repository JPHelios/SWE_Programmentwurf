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
    private String fahrzeugID;
    private Rechnung rechnung;
    private String rechnungID;
    private Mahnung[] mahnung;
    private String[] mahnungIDs;
    private Kunde kunde;
    private String kundeID;
    private Mitarbeiter mitarbeiter;
    private String mitarbeiterID;

    public Buchung(){
        this.buchungID = UUID.randomUUID().toString();
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.buchungID, String.valueOf(this.canceled), this.starttermin.toString(), this.endtermin.toString(), this.fahrzeugID, this.rechnungID, String.join(",", this.mahnungIDs), this.kundeID, this.mitarbeiterID};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return this.buchungID;
    }
}
