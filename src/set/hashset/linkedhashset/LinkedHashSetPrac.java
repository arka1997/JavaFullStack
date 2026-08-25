package set.hashset.linkedhashset;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetPrac {
    public static void main(String[] args) {
        Set<String> s = new LinkedHashSet<>();
        s.add("JIR");
        s.add("JIR2");
        s.add("JIR3");
        s.add("JIR4");
        s.add("JIR5");

        System.out.println(s);
    }
}
