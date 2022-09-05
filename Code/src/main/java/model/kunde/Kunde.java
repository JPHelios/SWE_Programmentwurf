package model.kunde;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;
import model.buchung.Buchung;
import model.utils.Adresse;

import java.util.UUID;

@Setter
@Getter
public class Kunde implements IPersistable {
    private String kundeID;

    private String nachname;
    private String vorname;
    private String telefon;
    private String email;
    private Vertrag vertrag;
    private Adresse adresse;
    private Buchung[] buchungen;

    public Kunde(){
        this.kundeID = UUID.randomUUID().toString();
    }

    public String[] toStringArray(){
        String arr[] = new String[]{};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return kundeID;
    }
}
