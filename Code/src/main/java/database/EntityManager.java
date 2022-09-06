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

    public void modify(Class c, String[] new_el){
        String path = getCSVPath(c);
        List<String[]> elements = read(path);
        System.out.println(elements);
        Object key = new_el[0];
        for(String[] el:elements){
            System.out.println("elm: " + el[0]);
            System.out.println("key: " + key);
            if(key.equals(el[0])){
                elements.set(elements.indexOf(el), new_el);
            }
        }

        Object[][] write_elements = new Object[elements.size()][];
        for(int i = 0; i<elements.size(); i++){
            write_elements[i] = elements.get(i);
        }
        write(write_elements, c);
    }

    public void persistEl(Class c, String[] el){
        String path = getCSVPath(c);
        List<String[]> elements = read(path);
        elements.add(el);
        Object[][] write_elements = new Object[elements.size()][];
        for(int i = 0; i<elements.size(); i++){
            write_elements[i] = elements.get(i);
        }
        write(write_elements, c);
    }

    //69;69;69;69;69
    //70;70;70;70;70

    public void removeEl(IPersistable el){
        String path = getCSVPath(el.getClass());
        List<String[]> elements = read(path);
        System.out.println(elements);
        Object key = el.getPrimaryKey();
        Object[][] write_elements = new Object[elements.size()-1][];
        int new_index = 0;
        for(int i =0; i<elements.size(); i++){
            System.out.println("elm: " + elements.get(i)[0]);
            if(!key.equals(elements.get(i)[0])){
                System.out.println("+1");
                System.out.println(elements.get(i));
                write_elements[new_index] = elements.get(i);
                new_index++;
            }
        }
        write(write_elements, el.getClass());
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

    public List<Object> getAllEl(Class c){
        String path = getCSVPath(c);
        List<String[]> elements = read(path);
        List<Object> return_elements = new ArrayList<>();
        for(String[] el:elements){
            try {
                Constructor<?> cons = c.getConstructor(Array.newInstance(String.class, 0).getClass());
                System.out.println(cons);
                Object i = cons.newInstance(new String[][]{el});
                System.out.println(i);
                return_elements.add(i);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return return_elements;
    }

    private String getCSVPath(Class c) {
        String class_name = c.getName();
        class_name = class_name.split("\\.")[2];
        String path = Entities.valueOf(class_name).getPath();
        return path;
    }

    private String[] getCSVHeader(Class c) {
        String class_name = c.getName();
        class_name = class_name.split("\\.")[2];
        String[] path = Entities.valueOf(class_name).getHeader();
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
    private void write(Object[][] values, Class c){
        writer = new CSVWriter(getCSVPath(c), false);
        try {
            writer.writeDataToFile(values, getCSVHeader(c));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
