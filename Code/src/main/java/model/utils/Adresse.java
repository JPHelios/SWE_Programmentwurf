package model.utils;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Adresse {
    private int adresseID;

    private String strasse;
    private int hausnummer;
    private int plz;
    private String ort;
    private String zusatz;

    public Adresse(){

    }
}
