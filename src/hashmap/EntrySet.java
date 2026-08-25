package hashmap;

import java.util.*;

public class EntrySet {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("Aglaonema", 5);
        map.put("Snake", 4);
        // m.put("Aglaonema", 5);// Same key and value, then its replaced
        map.put("Jade", 3);
        map.put("Moon Cactus", 4);
        map.put("Aglaonema", 6);

        Set<Map.Entry<String, Integer>> s = map.entrySet();
        s.iterator();
        while(s.iterator().hasNext()){
            
        }
    }
}
