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

    public Backup(){
        this.backupID = UUID.randomUUID().toString();
    }

    public Backup loadBackup(){
        return null;
    }

    @Override
    public Object getPrimaryKey() {
        return backupID;
    }
}



