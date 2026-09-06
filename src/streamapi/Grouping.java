package streamapi;

import java.util.*;
import java.util.stream.Collectors;

public class Grouping {
    public static void main(String[] args) {
        List<String> cities = List.of(
            "Bangalore",
            "Pune",
            "Chennai",
            "Hyderabad",
            "Delhi",
            "Noida",
            "Mysore"
        );

        // Group the cities by length, using Collections groupingBy method, that expects a conditional parameter on basis of what grouping happens, and returns a Map of parameter of Integer and List of Strings
       Map<Integer, List<String>> map = cities.stream().collect(Collectors.groupingBy(i -> i.length()));
       System.out.println(map);

    //    Group the cities by length whose length is more then 6
    Map<Integer, List<String>> map2 = cities.stream()
                                            .filter(i -> i.length() > 6)
                                            .collect(Collectors.groupingBy(i -> i.length()));
        System.out.println(map2);

        // Partitiion by partitions into 2 groups, depending on the condition, it picks the elements and put it in another array, and the one which satisfies the condition falls under "true" block, and the other falls under "false"
        Map<Boolean, List<String>> map3 = cities.stream().collect(Collectors.partitioningBy(i -> i.length() > 6));
        System.out.println(map3);
    }
}
