package database;

import de.dhbwka.swe.utils.model.IPersistable;
import de.dhbwka.swe.utils.util.CSVReader;
import de.dhbwka.swe.utils.util.CSVWriter;
import de.dhbwka.swe.utils.util.GenericEntityManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EntityManager extends GenericEntityManager {

    CSVReader reader;
    CSVWriter writer;

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



    public void read(){
        reader = new CSVReader("src\\main\\resources\\database\\standort.csv");
        try {
            List<String[]> data = reader.readData();
            for (String[] x: data) {
                for(String y: x){
                    System.out.println(y);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //1, 12, 4, "s1.jpg", 1
    //2, 100, 25, "s2.jpg", 2
    public void write(Object[][] args){
        writer = new CSVWriter("src\\main\\resources\\database\\standort.csv", false);
        try {
            writer.writeDataToFile(args, new String[]{"Standort-ID", "Anzahl Stellplätze", "Anzahl E-Säulen", "Bild-ID", "Adress-ID"});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
