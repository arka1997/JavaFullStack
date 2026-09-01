package set.hashset.linkedhashset;
import java.util.*;

class Employee {

    private int empId;
    private String name;

    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }
    public int hashCode(){
        return Objects.hash(empId);
    }
    public boolean equals(Object obj){
        Employee e = (Employee) obj;
        return Objects.equals(this.empId, e.empId);
    }
}
public class LinkedHashSetPrac {
    
    public static void main(String[] args) {
        // Here we maintain uniquenes by set, as well as Insertion Order is maintained by LinkedList. 
        // LinkedHashSet has after and before pointers, that holds the address of previous Node, and Next nODE. Also head node hold the first node, to print/read as per insertion order. Tail node is used to print in reverse order, as a DoubleLinkedList is used along with Hashser for first lookup.
        // Here we can insert from front and back with O(1) T.C.
        LinkedHashSet<String> s = new LinkedHashSet<>();
        s.add("JIR");
        s.add("JIR2");
        s.add("JIR5");
        s.add("JIR4");
        s.add("JIR5");
        s.add("JIR3");

        System.out.println(s);
        System.out.println(s.reversed());


        LinkedHashSet<Employee> id = new LinkedHashSet<>();
        Employee e1 = new Employee(13900, "Deba");
        Employee e2 = new Employee(13901, "Arko");
        Employee e3 = new Employee(13902, "dj");
        Employee e4 = new Employee(13903, "puku");
        Employee e5 = new Employee(13904, "bani");
        Employee e6 = new Employee(13905, "dilip");
        
        id.add(e1);
        id.add(e2);
        id.add(e3);
        id.add(e4);
        id.add(e5);
        id.add(e6);

        // How to get the 3rd element
        Iterator itr = id.iterator();
        int count = 0;
        while(itr.hasNext()){
            if(count == 3){
                String s2 = (String) itr.next();
                System.out.println(s2.toString());
                break;
            }
            count++;
        }
    }
}
