package model.kunde;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Vertrag {
    private int vertragID;

    private String pfad;
    private Date datum;

    public Vertrag(){

    }
}
