package streamapi;

import java.util.List;
import java.util.stream.Collectors;

public class StreamPrac1 {
    public static void main(String[] args) {
        
        // Find the city names which starts with B and city names length is more then 6
        List<String> brands = List.of("Bajaj","samsung","Boroline","sony","apple","Bosch","sonata","sony");

        List<String> output = brands.parallelStream().filter(brand -> brand.startsWith("B") && brand.length() > 6).toList();
        System.out.println(output);

        // Find even number, then multiply result with 10
        List<Integer> num = List.of(23,34,56,212,77,34,32,14);
        List<Integer> result = num.stream()
            .filter(i -> i%2 == 0)
            .map(i -> i * 10)
            .collect(Collectors.toList());
        System.out.println(result);
    }
}
