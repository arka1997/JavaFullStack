package streamapi;

import java.util.List;

public class SumOfNumber {
    public static void main(String[] args) {
        List<Integer> input = List.of(10,4,60,7,6,30,14,5670,8992,56,78,37,17);
        
        // reduce(0, (a,b) -> a+b) => '0' is the identity or initial value. from which the accumulation starts. 'a' stores the accumulated result so far. 'b' keeps the next element from stream
        int val1 = input.stream().reduce(0, (a,b) -> a+b);
        System.out.println(val1);
        int val2 = input.stream().filter(i -> i%2 == 0).reduce(0, (a,b) -> a + b);
        System.out.println(val2);

        // Minimum no. in array. ".min" and ".max" are terminal operations
        int minimum = input.stream().min((a,b) -> a - b).get();
        System.out.println(minimum);
    }
}
