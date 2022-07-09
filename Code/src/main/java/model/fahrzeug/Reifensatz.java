package model.fahrzeug;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reifensatz {
    private Reifen[] reifensatz = new Reifen[4];
    private Reifen ersatzrad;

    public void Reifensatz(){
        
    }
}
