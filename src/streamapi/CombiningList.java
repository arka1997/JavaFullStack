package streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.*;
public class CombiningList {
    private static Optional<String> max;

    public static void main(String[] args) {

        // Problem: Concatenate or merge this two list, without any duplicates
        List<String> list1 = Arrays.asList(
        "Bangalore", "Delhi", "Pune", "Chennai", "Hyderabad");

        List<String> list2 = Arrays.asList(
                "Delhi", "Noida", "Mysore", "Delhi");

        Stream.concat(list1.stream(), list2.stream()).distinct().forEach(s -> System.out.println("Merge 2 lists into one without duplicates " + s));

        // Problem2: Find the longest city in both the list
        max = Stream.concat(list1.stream(), list2.stream()).distinct().max(Comparator.comparingInt(size -> size.length()));// max calculates the maximum of the cities length, depending on the condition
        System.out.println(max.get());
    }
}
