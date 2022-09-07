package model.standort;

import app.Carsharing;
import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Filiale implements IPersistable {
    private String filialeID;

    private String[] oeffnungszeiten = new String[7];
    private Mitarbeiter[] mitarbeiter;
    private String[] mitarbeiterIDs;
    private Standort standort;
    private String standortID;

    public Filiale(){
        this.filialeID = UUID.randomUUID().toString();
    }

    public Filiale(String[] props){
        this.filialeID = props[0];
        this.oeffnungszeiten = props[1].split(",");
        this.mitarbeiterIDs = props[2].split(",");
        this.standortID = props[3];

        /*this.mitarbeiter = new Mitarbeiter[this.mitarbeiterIDs.length];
        for(int i = 0; i < this.mitarbeiterIDs.length; i++){
            this.mitarbeiter[i] = (Mitarbeiter) Carsharing.em.find(Mitarbeiter.class, this.mitarbeiterIDs[i]);
        }
        this.standort = (Standort) Carsharing.em.find(Standort.class, this.standortID);*/
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.filialeID, String.join(",", this.oeffnungszeiten), String.join(",", this.mitarbeiterIDs), this.standortID};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return filialeID;
    }

    public String getOeffnungszeiten(){

        StringBuilder sb = new StringBuilder();

        for(String s : this.oeffnungszeiten){
            sb.append(s).append(" ");
        }

        return String.valueOf(sb);
    }

    @Override
    public String toString(){

        if(this.oeffnungszeiten[0].equals("")){
            return "Keine Filiale";
        } else {
            return filialeID;
        }
    }
}
