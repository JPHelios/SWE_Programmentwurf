package model.utils;


import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class Adresse implements IPersistable {
    private String adresseID;

    private String strasse;
    private String hausnummer;
    private String plz;
    private String ort;
    private String zusatz;

    public Adresse(){
        this.adresseID = UUID.randomUUID().toString();
    }

    public Adresse(String strasse, String hausnummer, String plz, String ort, String zusatz ){
        this.adresseID = UUID.randomUUID().toString();
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
        this.zusatz = zusatz;
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.adresseID, this.strasse, String.valueOf(this.hausnummer), this.plz, this.ort, this.zusatz};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return adresseID;
    }
}
