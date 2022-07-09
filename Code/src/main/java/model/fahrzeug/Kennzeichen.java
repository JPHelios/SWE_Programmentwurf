package model.fahrzeug;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Kennzeichen {
    private int kennzeichenID;

    private String kennzeichen;
    private String zulassungstelle;

    public Kennzeichen(){

    }
}
