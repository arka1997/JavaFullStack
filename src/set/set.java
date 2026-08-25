package set;
import java.util.*;

// Super constructor chaining
public class set {

    // Constructor
    public set (){
        super();
        System.out.println("Step3");
    }
    public static void main(String[] args){

        set3 s = new set3();
        HashSet<String> sets = new HashSet<>();
        List<String> l1 = new LinkedList<>();
        sets.add("BLR");
        sets.add("CHE");
        sets.add("NOS");
        sets.add("ABC");
        sets.add("CVB");
        sets.add("ABc");
        sets.add("AbC");
        sets.add("aBC");
        sets.add("dfg");
        sets.add("GHF");
        sets.add("ERT");
        sets.add("VVD");
        sets.add("ADA");
        sets.add("abf");
        System.out.println(sets);
    }

}

class set2 extends set{
    public set2(){
        super();

        System.out.println("Step2");
    }
}

class set3 extends set2 {

    public set3(){
        super();

        System.out.println("Step1");
    }
}