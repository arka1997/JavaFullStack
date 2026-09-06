package streamapi;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringDuplicatesImp {
    private static Stream<Character> filter;

    public static void main(String[] args) {

        // word.chars() gives IntStream, converts each primitives like every Characters ASCII value
        // mapToObj() => Converts each primitive stream, here ASCII, into an Object
        // c -> (char) c => Converts/casts each AASCII numbers of intstream into stream of character object
        // filter() => Depending on condition == true, it returns those data. Here we pick each character from stream and get its index from the "word="swiss" string
        // Find the all non-repeating characters
        String word = "swiss";
        IntStream i = word.chars();
        Stream<Character> chars = i.mapToObj(c -> (char) c);
        Stream<Character> output = chars.filter(ch -> word.indexOf(ch) == word.lastIndexOf(ch));
        output.forEach(s -> System.out.println(" All non-repeating characters: " + s));
        // Find first non-repeating characters
        Optional<Character> op = word.chars()
        .mapToObj(c -> (char) c)
        .filter(ch -> word.indexOf(ch) == word.lastIndexOf(ch))
        .findFirst();
        if(op.isPresent()){
            System.out.println("first non-repeating characters : " + op.get());
        }
        // Find 2nd non-repeating characters => use skip, after getting the condition matching index using filter
        Optional<Character> op2 = word.chars()
        .mapToObj(c -> (char) c)
        .filter(ch -> word.indexOf(ch) == word.lastIndexOf(ch))
        .skip(1)
        .findFirst();

        if(op2.isPresent()){
            System.out.println("2nd non-repeating character: " + op2.get());
        }
    }
}
