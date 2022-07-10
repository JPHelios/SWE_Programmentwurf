package model.kunde;

import lombok.Getter;
import lombok.Setter;
import model.buchung.Buchung;
import model.utils.Adresse;

@Setter
@Getter
public class Kunde {
    private int kundeID;

    private String nachname;
    private String vorname;
    private String telefon;
    private String email;
    private Vertrag vertrag;
    private Adresse adresse;
    private Buchung[] buchungen;

    public Kunde(){

    }
}
