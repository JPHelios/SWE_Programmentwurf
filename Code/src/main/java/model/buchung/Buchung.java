package model.buchung;


import app.Carsharing;
import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;
import model.fahrzeug.Fahrzeug;
import model.kunde.Kunde;
import model.standort.Mitarbeiter;

import java.io.CharArrayReader;
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

    public Buchung(String[] props){
        this.buchungID = props[0];
        this.canceled = Boolean.parseBoolean(props[1]);
        this.starttermin = new Date(Integer.parseInt(props[2]));
        this.endtermin = new Date(Integer.parseInt(props[3]));
        this.fahrzeugID = props[4];
        this.rechnungID = props[5];
        this.mahnungIDs = props[6].split(",");
        this.kundeID = props[7];
        this.mitarbeiterID = props[8];

        /*this.fahrzeug = (Fahrzeug) Carsharing.em.find(Fahrzeug.class, this.fahrzeugID);
        this.rechnung = (Rechnung) Carsharing.em.find(Rechnung.class, this.rechnungID);
        this.mahnung = new Mahnung[this.mahnungIDs.length];
        for(int i = 0; i < this.mahnungIDs.length; i++){
            this.mahnung[i] = (Mahnung) Carsharing.em.find(Mahnung.class, this.mahnungIDs[i]);
        }
        this.kunde = (Kunde) Carsharing.em.find(Kunde.class, this.kundeID);
        this.mitarbeiter = (Mitarbeiter) Carsharing.em.find(Mitarbeiter.class, this.mitarbeiterID);*/
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
