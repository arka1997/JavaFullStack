package hashmap;

import java.util.*;

public class EntrySet {
    public static void main(String[] args) {

        // Here we can store one null key, nd multiple null values
        Map<String, Integer> map = new HashMap<>();

        map.put("Aglaonema", 5);
        map.put("Snake", 4);
        // m.put("Aglaonema", 5);// Same key and value, then its replaced
        map.put("Jade", 3);
        map.put("Moon Cactus", 4);
        // Here in map, if we want to add a new value of the same key, then HashMap treats it as an update, like we update in CRUD
        map.put("Aglaonema", 6);
        map.put(null, null);
        map.put("ZZ", null);

        // First convert the Maop to entry Set
        Set<Map.Entry<String, Integer>> plantEntry = map.entrySet();
        // Then you have to iterate over the Entry Set
        Iterator<Map.Entry<String, Integer>> itr = plantEntry.iterator();
        while(itr.hasNext()){
            // Returns an unmodifiable list, after we downcast the Object return by Iterator itr.next() to Map.Entry<String, Integer>
            Map.Entry<String, Integer> e = (Map.Entry<String, Integer>) itr.next();
            System.out.println(e);
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }


    }
}
