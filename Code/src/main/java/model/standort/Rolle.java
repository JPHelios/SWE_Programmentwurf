package model.standort;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rolle {
    private int rolleID;

    private String bezeichnung;
    private Object[] berechtigt;

    public Rolle(){

    }
}
