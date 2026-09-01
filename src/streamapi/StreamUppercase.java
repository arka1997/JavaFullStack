package streamapi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUppercase {
    public static void main(String[] args) {
        List<String> brands = List.of("nokia","samsung","lg","sony","apple","windows","sonata","sony");
        // Converting the collections list to stream object
        Stream<String> streams = brands.stream();
        // Now start processing the stream into Uppercase - Intermediate Operations Start, Converting one Streams to another Streams
        //  Map function in streams api expects Functional predicate, to process each of the elements passed to Map into a different stream, which means, it accepts a stream of values, then we do some processing on it, and the output is also new stream of values
        Stream<String> stream2Uppercase = streams.map(s -> s.toUpperCase());
        // Terminal operations starts, Streams to Output-List/Set/Int,etc.
        List<String> l = stream2Uppercase.collect(Collectors.toList());
        System.out.println(l);
        
        Stream<String> streams2 = brands.stream();
        // As I have used Set, so duplicate values will not be printed
        Set<String> set = streams2.filter(e -> e.startsWith("s")).map(e -> e.replace('s', 'p')).collect(Collectors.toSet());

        System.out.println(set);
    }
}
