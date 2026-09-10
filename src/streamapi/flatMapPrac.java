package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapPrac {
    
    /**
     * map vs flatMap
     * map operates on 1D array
     * flatMap operates on 2D Array
     * @param args
     */
    public static void main(String[] args) {
        List<List<String>> toD = Arrays.asList(Arrays.asList("Maya", "Vriksh", "Mayavriksh"), Arrays.asList("Bangalore","Chennai"));
        List<String> result2 = toD.stream()
        .flatMap(c -> c.stream())
        .filter(city -> city.startsWith("M"))
        .map(city -> city.toUpperCase())
        .collect(Collectors.toList());

        System.out.println("gg"+result2);

        // cREATED a 3*2 array
        List<List<String>> arr = List.of(Arrays.asList("Bengalore","Chennhai"), Arrays.asList("Delhi","Bangalore"), Arrays.asList("WestBengal","UP"));
        arr.stream()
        .flatMap(list -> list.stream())
        .filter(loc -> loc.startsWith("C") || loc.startsWith("B"))
        .map(loc -> loc.toUpperCase())
        .forEach(loc -> System.out.println(loc));
        
        System.out.println(arr);


    }
}
