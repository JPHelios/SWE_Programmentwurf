package database;

import de.dhbwka.swe.utils.model.IPersistable;
import de.dhbwka.swe.utils.util.GenericEntityManager;
import model.fahrzeug.Fahrzeug;

import java.util.ArrayList;
import java.util.List;

public class EntityManager extends GenericEntityManager {

    public EntityManager(){

    }

    public void modify(IPersistable el){

    }

    public void persistEl(IPersistable el){

    }

    public void removeEl(IPersistable el){

    }

    public List<IPersistable> getAllEl(Class c){
        return new ArrayList<>();
    }
}
