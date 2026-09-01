package streamapi;

import java.util.Arrays;
import java.util.List;

public class flatMapPrac {
    public static void main(String[] args) {
        // cREATED a 3*3 array
        List<List<String>> arr = List.of(Arrays.asList("Bengalore","Chennhai"), Arrays.asList("Delhi","Bangalore"), Arrays.asList("WestBengal","UP"));
        arr.stream()
        .flatMap(list -> list.stream())
        .filter(loc -> loc.startsWith("C") || loc.startsWith("B"))
        .map(loc -> loc.toUpperCase())
        .forEach(loc -> System.out.println(loc));
        
        System.out.println(arr);
    }
}
