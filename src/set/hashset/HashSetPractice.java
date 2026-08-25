package set.hashset;
import java.util.HashSet;
class HashSetPractice {

    public static void main(String[] args) {

        HashSet<String> h = new HashSet<>();

        h.add("iPhone17");
        h.add("samsungs26");
        h.add("lg32");
        h.add("mac-pro324");
        h.add("iPhone17s");
        h.add("samsungs26s");
        h.add("lg32s");
        h.add("mac-pro324s");
        System.out.println("HashSet = " + h);

        // Keep debugger here
        System.out.println("Pause here");

        int hash = "mac-pro324".hashCode();
        // int spreadHash = hash ^ (hash >>> 16);

        // IMPORTANT:
        // This assumes table capacity = 16.
        int bucket = hash & (16 - 1);

        System.out.println("hash       = " + hash);
        // System.out.println("spreadHash = " + spreadHash);
        System.out.println("bucket     = " + bucket);
    }
}