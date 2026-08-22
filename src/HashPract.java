import java.util.HashSet;
import java.util.Objects;
class Employee {

    private int empId;
    private String name;

    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, name);
    }

    @Override
    public boolean equals(Object obj) {
        // if (this == obj) {
        //     return true;
        // }
        // if (!obj instanceOf Employee) {
        //     return false;
        // }

        Employee emp = (Employee) obj;
        // Use this Object.equals() when we are dealing with Non primitive data types, like Integer, String, etc.
        // return Objects.equals(empId, emp.empId) && Objects.equals(name, emp.name);
        // Use "==", when we have primitive data types, like int, char, etc.
        return empId == emp.empId && Objects.equals(name, emp.name);
    }
}

public class HashPract {

    public static void main(String[] args) {

        HashSet<Employee> id = new HashSet<>(64);

        Employee e1 = new Employee(13900, "Deba");
        Employee e2 = new Employee(13900, "Arko");
        Employee e3 = new Employee(13900, "dj");
        Employee e4 = new Employee(13900, "puku");
        Employee e5 = new Employee(13900, "bani");
        Employee e6 = new Employee(13900, "dilip");
        Employee e7 = new Employee(13900, "saket");
        Employee e8 = new Employee(13900, "arpan");
        Employee e9 = new Employee(13900, "ayan");
        
        id.add(e1);
        id.add(e2);
        id.add(e3);
        id.add(e4);
        id.add(e5);
        id.add(e6);
        id.add(e7);
        id.add(e8);
        id.add(e9);

        System.out.println(e1.hashCode() + " " + e2.hashCode());
        System.out.println(e1.equals(e3));
        System.out.println(id.size());
    }
}