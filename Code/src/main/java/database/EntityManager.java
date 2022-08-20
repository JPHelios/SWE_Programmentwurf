package database;

import de.dhbwka.swe.utils.model.IPersistable;
import de.dhbwka.swe.utils.util.CSVReader;
import de.dhbwka.swe.utils.util.CSVWriter;
import de.dhbwka.swe.utils.util.GenericEntityManager;
import util.enums.Entities;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class EntityManager extends GenericEntityManager {

    CSVReader reader;
    CSVWriter writer;

    public EntityManager(){

    }

    public void modify(IPersistable el){
        String class_name= el.getClass().getName();


    }

    public void persistEl(IPersistable el){

    }

    public void removeEl(IPersistable el){

    }

    public Object find(Class c, String key){
        String path = getCSVPath(c);
        List<String[]> elements = read(path);
        System.out.println(elements);
        for(String[] el:elements){
            System.out.println("elm: " + el[0]);
            System.out.println("key: " + key);
            if(key.equals(el[0])){
                System.out.println("Found");
                try {
                    Constructor<?> cons = c.getConstructor(Array.newInstance(String.class, 0).getClass());
                    System.out.println(cons);
                    Object i = cons.newInstance(new String[][]{el});
                    System.out.println(i);
                    return i;
                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public String[] findTuple(Class c, String key){
        String path = getCSVPath(c);
        List<String[]> elements = read(path);
        for(String[] el:elements){
            if(el[0]==key){
                return el;
            }
        }
        return null;
    }

    public List<IPersistable> getAllEl(Class c){
        String path = getCSVPath(c);
        List<String[]> elements = read(path);

        return new ArrayList<>();
    }

    private String getCSVPath(Class c) {
        String class_name = c.getName();
        class_name = class_name.split("\\.")[2];
        System.out.println(class_name);
        String path = Entities.valueOf(class_name).getPath();
        return path;
    }


    private List<String[]> read(String path){
        reader = new CSVReader(path);
        try {
            List<String[]> data = reader.readData();
            for (String[] x: data) {
                for(String y: x){
                    System.out.println(y);
                }
            }
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null ;
        }
    }
    //1, 12, 4, "s1.jpg", 1
    //2, 100, 25, "s2.jpg", 2
    private void write(Object[][] args){
        writer = new CSVWriter("src\\main\\resources\\database\\standort.csv", false);
        try {
            writer.writeDataToFile(args, new String[]{});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
