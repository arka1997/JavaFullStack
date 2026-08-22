import java.util.*;

public class TreeSetPrac implements Comparable<Object>{

    public int compareTo(Object obj){
        return 0;
    }
    public static void main(String[] args) {
        Set<String> s = new TreeSet<>();


        s.add("JIR");
        s.add("JIR2");
        s.add("JIR3");
        s.add("JIR4");
        s.add("JIR4");

        System.out.println(s);

        Employee e1 = new Employee(13900, "Deba");
        Employee e2 = new Employee(13901, "Deba");
        Employee e3 = new Employee(13902, "Deba");
        Employee e4 = new Employee(13903, "Deba");
        Employee e5 = new Employee(13904, "Deba");

        Set<Employee> emp = new TreeSet<Employee>();
        emp.add(e1);
        emp.add(e2);
        emp.add(e3);
        emp.add(e4);
        emp.add(e5);

        System.out.println(emp);
    }

}


