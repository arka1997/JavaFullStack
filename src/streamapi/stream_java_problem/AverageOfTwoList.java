package streamapi.stream_java_problem;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class AverageOfTwoList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2,4,6,8,5,3);
        // mapToInt converts the the Object Stream to Int stream, to perform all arithmatic operations like average, max, min on the int stram
        OptionalDouble o = numbers.stream().mapToInt(e -> e).average();
        System.out.println(o);

    }
}
