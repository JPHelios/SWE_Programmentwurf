package model.kunde;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;
import model.buchung.Buchung;
import model.utils.Adresse;

@Setter
@Getter
public class Kunde implements IPersistable {
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

    @Override
    public Object getPrimaryKey() {
        return kundeID;
    }
}
