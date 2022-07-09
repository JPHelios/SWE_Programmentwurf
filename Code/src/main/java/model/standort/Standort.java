package model.standort;

import model.fahrzeug.Fahrzeug;
import model.utils.Adresse;
import model.utils.Bild;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Standort {
    private int anzahlPlaetze;
    private int anzahlSaeulen;
    private Fahrzeug[] fahrzeuge;
    private Filiale[] filialen;
    private Bild bild;
    private Adresse adresse;

    public Standort(){

    }
}
