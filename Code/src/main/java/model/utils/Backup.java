package model.utils;

import de.dhbwka.swe.utils.model.IPersistable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Backup implements IPersistable {
    private int backupID;

    private String pfad;

    public Backup(){

    }

    public Backup loadBackup(){
        return null;
    }

    @Override
    public Object getPrimaryKey() {
        return backupID;
    }
}



