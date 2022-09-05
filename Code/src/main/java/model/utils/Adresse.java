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
    private int hausnummer;
    private String plz;
    private String ort;
    private String zusatz;

    public Adresse(){
        this.adresseID = UUID.randomUUID().toString();
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
