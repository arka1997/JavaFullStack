import java.util.HashSet;

public class CollisionDemo {
    static class Key {
        String name;
        int id;
        Key(String name, int id) { this.name = name; this.id = id; }
        @Override public int hashCode() { return 42; } // force collisions
        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Key)) return false;
            return id == ((Key) o).id;
        }
        @Override public String toString() { return name + "#" + id; }
    }

    public static void main(String[] args) {
        HashSet<Key> set = new HashSet<>();
        Key k1 = new Key("A", 1);
        Key k2 = new Key("B", 2);
        Key k3 = new Key("C", 3);

        set.add(k1); // put breakpoint here
        set.add(k2); // put breakpoint here
        set.add(k3);

        System.out.println("Set size: " + set.size());
        for (Key k : set) System.out.println(k);

        // keep the process alive briefly so you can inspect in debugger
        try { Thread.sleep(30000); } catch (InterruptedException ignored) {}
    }
}
