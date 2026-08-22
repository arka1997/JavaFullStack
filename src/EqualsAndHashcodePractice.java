import java.util.*;

public class EqualsAndHashcodePractice {
    private String name;
    private int id;
    public EqualsAndHashcodePractice(String name, int id){
        super();
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode(){
        // different ways of creating hashcodes, to reduce chances of collisions.
        return this.name.hashCode() + this.id;
        // return Objects.hash(name, id); // This creates hash functions of combined parameters, industry standard
    }

     // Here we override the method, so the method as well as parameter should be same, here Object obj. And inside its parameter, we sent e2, containing object, so its like Object obj = new EqualsAndHashcodePractice("Arko",13900);
    @Override
    public boolean equals(Object obj){
        // Downcasted the object class, containing e2, so that we can access e2's content like name and id, and compare it with e1. Here e1.equals(e2)
        EqualsAndHashcodePractice emp = (EqualsAndHashcodePractice) obj;
        return this.name.equals(emp.name) && this.id == emp.id;
    }
}

class Drivers {
    public static void main(String[] args) {
        HashSet<EqualsAndHashcodePractice> id = new HashSet<>(64);

        EqualsAndHashcodePractice e1 = new EqualsAndHashcodePractice("Deba",13900);
        EqualsAndHashcodePractice e2 = new EqualsAndHashcodePractice("Arko",13900);
        EqualsAndHashcodePractice e3 = new EqualsAndHashcodePractice("Deba",13900);

        id.add(e1);
        id.add(e2);
        id.add(e3);


        System.out.println(e1.hashCode() + " " + e2.hashCode());
        System.out.println(e1.equals(e3));
        System.out.println(id.size());
    }
}