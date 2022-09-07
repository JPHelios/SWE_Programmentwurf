package model.utils;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Backup implements IPersistable {
    private String backupID;

    private String pfad;
    private String mitarbeiterID;

    public Backup(){
        this.backupID = UUID.randomUUID().toString();
    }

    public Backup loadBackup(){
        return null;
    }

    public Backup(String[] props){
        this.backupID = props[0];
        this.pfad = props[1];
        this.mitarbeiterID = props[2];
    }

    public String[] toStringArray(){
        String arr[] = new String[]{this.backupID, this.pfad, this.mitarbeiterID};
        return arr;
    }

    @Override
    public Object getPrimaryKey() {
        return backupID;
    }
}



