package streamapi;

import java.util.*;
import java.util.stream.Collectors;

public class Duplicates {
    public static void main(String[] args) {
        List<Integer> input = List.of(1,4,6,7,6,3,14,567,8992,56,78,34,14);

        // Problem1: Remove the duplicates
        List<Integer> l = input.stream().distinct().collect(Collectors.toList());
        System.out.println(l);
        
        
        // Problem2: print the duplicate elements only

        HashSet<Integer> h = new HashSet<>();
        // here intermediate filter function keeps the values, which returned true after the operation "!h.add(i)", and in the terminal function we print it. For duplicates, "h.add()" => gives "false", and !false = true, so filter returns its value
        input.stream().filter(i -> !h.add(i)).forEach(i -> System.out.println(i));

        // Problem3: Sorting
        List<Integer> sorts = input.stream().sorted((a,b) -> b - a).collect(Collectors.toList()); 
        System.out.println(sorts);
    }
}
