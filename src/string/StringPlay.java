package string;
public class StringPlay {
    public static void main(String[] args) {

        // String Pool

        // "Ja"     ← a
        // "va"     ← b
        // "Java"   ← c
        //         ↑
        //         f
        //         ↑
        //         e

        String a = "Ja";
        String b = "va";
        String c = "Java";
        String d = a + b;// It will be stored in a seperate object in Heap, and will be concatenated during run-time, as 'a' and 'b' are seperate variables
        String e = "Ja" + "va";// Here the value is concatenated and stored in String Pool. If printed, gives "Java"
        String f = "Java";

        
        System.out.println(c == d);
        System.out.println(d.equals(c));// Here equals will checks the objects content
        System.out.println(c);
        System.out.println(d);
        System.out.println(c == e);// Here the 2 pointers, points to the same value,
        System.out.println(c.equals(e));
        System.out.println(e);
        System.out.println(c == f);
    }
}
