package model.buchung;


import app.Carsharing;
import de.dhbwka.swe.utils.model.Attribute;
import de.dhbwka.swe.utils.model.IDepictable;
import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;
import model.fahrzeug.Fahrzeug;
import model.kunde.Kunde;
import model.standort.Mitarbeiter;

import java.io.CharArrayReader;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

@Getter
@Setter
public class Buchung implements IPersistable, IDepictable {
    private String buchungID;

    private boolean canceled;
    private Date starttermin;
    private Date endtermin;

    private Fahrzeug fahrzeug;
    private String fahrzeugID;

    private String rechnungID;
    private Mahnung[] mahnung;
    private String[] mahnungIDs;
    private Kunde kunde;
    private String kundeID;
    private Mitarbeiter mitarbeiter;
    private String mitarbeiterID;

    public Buchung(){
        this.buchungID = UUID.randomUUID().toString();
        this.canceled = false;
    }

    public Buchung(String[] props){
        this.buchungID = props[0];
        this.canceled = Boolean.parseBoolean(props[1]);
        this.starttermin = new Date(Long.parseLong(props[2]));
        this.endtermin = new Date(Long.parseLong(props[3]));
        this.fahrzeugID = props[4];
        this.rechnungID = props[5];
        this.mahnungIDs = props[6].split(",");
        this.kundeID = props[7];
        this.mitarbeiterID = props[8];

        this.fahrzeug = (Fahrzeug) Carsharing.em.find(Fahrzeug.class, this.fahrzeugID);
        this.mahnung = new Mahnung[this.mahnungIDs.length];
        for(int i = 0; i < this.mahnungIDs.length; i++){
            this.mahnung[i] = (Mahnung) Carsharing.em.find(Mahnung.class, this.mahnungIDs[i]);
        }
        this.kunde = (Kunde) Carsharing.em.find(Kunde.class, this.kundeID);
        this.mitarbeiter = (Mitarbeiter) Carsharing.em.find(Mitarbeiter.class, this.mitarbeiterID);
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.buchungID, String.valueOf(this.canceled), String.valueOf(this.starttermin.getTime()), String.valueOf(this.endtermin.getTime()), this.fahrzeugID, this.rechnungID, String.join(",", this.mahnungIDs), this.kundeID, this.mitarbeiterID};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return this.buchungID;
    }

    @Override
    public String getElementID() {
        return this.buchungID;
    }

    @Override
    public Attribute[] getAttributeArray() {
        return new Attribute[0];
    }

    @Override
    public String toString() {
        //Initialize your Date however you like it.
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(this.starttermin);
        int start_year = calendar.get(Calendar.YEAR);
        int start_month = calendar.get(Calendar.MONTH) + 1;
        int start_day = calendar.get(Calendar.DAY_OF_MONTH);

        String startString = start_day + "." + start_month + "." + start_year;

        calendar.setTime(this.endtermin);
        int end_year = calendar.get(Calendar.YEAR);
        int end_month = calendar.get(Calendar.MONTH) + 1;
        int end_day = calendar.get(Calendar.DAY_OF_MONTH);

        String endString = end_day + "." + end_month + "." + end_year;

        return this.kunde.getNachname() + ", " + this.kunde.getVorname() + ": " + this.fahrzeug.getHersteller() + " " + this.fahrzeug.getModell() + " | " + startString + " - " + endString;
    }
}
