package model.standort;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Filiale {
    private String[] oeffnungszeiten = new String[7];
    private Mitarbeiter[] mitarbeiter;
    private Standort standort;

    public Filiale(){

    }
}
