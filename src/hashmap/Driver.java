package hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Driver {
    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<>();
        m.put("Aglaonema", 5);
        m.put("Snake", 4);
        // m.put("Aglaonema", 5);// Same key and value, then its replaced
        m.put("Jade", 3);
        m.put("Moon Cactus", 4);
        m.put("Aglaonema", 6); //same key, diffferent value, If key is same , value will be overridden, with new value for same key

        System.out.println(m);

        Map<String, Integer> m2 = new LinkedHashMap<>();
        m2.put("Aglaonema", 5);
        m2.put("Snake", 4);
        // m.put("Aglaonema", 5);// Same key and value, then its replaced
        m2.put("Jade", 3);
        m2.put("Moon Cactus", 4);
        m2.put("Aglaonema", 6);

        System.out.println(m2);

        Map<String, Integer> m3 = new TreeMap<>();
        
        m3.put("Aglaonema", 5);
        m3.put("Snake", 4);
        // m.put("Aglaonema", 5);// Same key and value, then its replaced
        m3.put("Jade", 3);
        m3.put("Moon Cactus", 4);
        m3.put("Aglaonema", 6);
        
        System.out.println(m3);
    }
}
