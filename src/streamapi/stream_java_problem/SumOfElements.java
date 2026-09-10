package streamapi.stream_java_problem;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SumOfElements {

    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,2,3,4,5);

        int sum = l.stream().reduce(0,(a,b) -> a + b).intValue();
        System.out.println("sum1:" + sum);

        int sum2 = l.stream().mapToInt(m -> m).sum();
        System.out.println("Sum2:" + sum2);

        Optional<Integer> max = l.stream().max((a,b) -> a-b);
        System.out.println("Max=" + max.get());

    }
}
