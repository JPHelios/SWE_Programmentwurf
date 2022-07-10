package model.utils;


import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Adresse implements IPersistable {
    private int adresseID;

    private String strasse;
    private int hausnummer;
    private int plz;
    private String ort;
    private String zusatz;

    public Adresse(){

    }

    @Override
    public Object getPrimaryKey() {
        return adresseID;
    }
}
