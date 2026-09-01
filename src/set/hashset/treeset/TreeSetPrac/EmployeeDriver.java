package set.hashset.treeset.TreeSetPrac;

import java.util.Set;
import java.util.TreeSet;


class Employee implements Comparable<Object>{
    int salary;
    String location;

    Employee(int salary, String location){
        this.salary = salary;
        this.location = location;
    }

    @Override
    public int compareTo(Object obj){
        Employee e = (Employee) obj;
        return e.salary;
    }
}

class Employee2 implements Comparable<Employee2> {
    int salary;
    String location;

    Employee2(int salary, String location){
        this.salary = salary;
        this.location = location;
    }

    // Its used when we want to sort the data on basis of a Object's specific property, here salary
    @Override
    public int compareTo(Employee2 emp) {

        System.out.println(this.salary - emp.salary);
        int result = this.salary - emp.salary;

        System.out.println(this.salary + " " + emp.salary + " " + result);
        return result;
    }

    // This is used to override oBJECTS toString() method, to print the objects content
    @Override
    public String toString(){
        return this.salary + " " + this.location;
    }
}
public class EmployeeDriver {
    public static void main(String[] args) {
        Set<Employee2> s = new TreeSet<>();
        Employee2 emp1 = new Employee2(200, "WB");
        Employee2 emp2 = new Employee2(208, "Delhi");
        Employee2 emp3 = new Employee2(205, "TamilNadu");
        Employee2 emp4 = new Employee2(225, "TamilNadu");
        Employee2 emp5 = new Employee2(210, "TamilNadu");
        Employee2 emp6 = new Employee2(215, null);

        s.add(emp1);
        s.add(emp2);
        s.add(emp3);
        s.add(emp4);
        s.add(emp5);
        s.add(emp6);

        System.out.println(s);
    }
}
