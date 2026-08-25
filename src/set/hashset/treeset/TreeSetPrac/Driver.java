package set.hashset.treeset.TreeSetPrac;
// 1st extend class to comparable
// create Payment objects,a nd insert in Tree set
// Implement the abstract compareTo() method from comparable
// Create Iterator to traverse the tree set

import java.util.*;

class Payments implements Comparable<Payments> {
    String empId;
    Payments(String empId){
        this.empId = empId;
    }

    public int compareTo(Payments obj){
        return this.empId.compareTo(obj.empId);
    }

    // If we dont override toString, then we get address of objects
    // What is the use of toString() then? What it does internally?
    @Override
    public String toString(){
        return Objects.toString(empId);
    }
}

public class Driver {

    public static void main(String[] args) {
        Set<Payments> s = new TreeSet<>();
        Payments p = new Payments("234");
        Payments p2 = new Payments("235");
        Payments p3 = new Payments("236");
        Payments p4 = new Payments("237");
        s.add(p);
        s.add(p2);
        s.add(p3);
        s.add(p4);
        System.out.println(s);

        Iterator<Payments> itr = s.iterator();
        // itr.hasNext() -> check if the next element is there or not
        while(itr.hasNext()){
            System.out.println( itr.next()); //itr.next(basically prints the values
        }

        StringBuilder a = new StringBuilder("Java");
        StringBuilder b = a;
        a.append("21");
        System.out.println((a==b) + " " +b + " " +a);
    }
}
