import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableEmployee {

    private final String name;
    private final Department department;
    private final List<String> roles;

    public ImmutableEmployee(String name,
                             Department department,
                             List<String> roles) {

        this.name = name;

        // Creating a new object and storing department, so that while creating ImmutableEmployee object, with department ones, we cant modify the new department object stored under Employee object. 
        this.department = new Department(department.getDepartmentName());

        // Defensive copy of mutable List
        this.roles = new ArrayList<>(roles);
    }

    public String getName() {
        return name;
    }

    // If we keep it like this, then from the outside, which is driver class, we can fetch the department Object of employee, and can modify its value with setter(setDepartmentName) as well. That is manipulating inside employee object. So to rpevent that, we are creting new object, if anyone is trying to chnage the department inside immutable employee object
    public Department getDepartment() {
        return department;
    }
    // This is the correct one, where, even if from outside, we try to fetch department object of an employee, it creates a new Department object and returns me. Old Deprtment under the Employee is not tampered, 
    // public Department getDepartment() {
    //     return new Department(department.getDepartmentName());
    // }

    // Here we return a copy of the List, and make the copy read-only, to attain immutability
    public List<String> getRoles() {
        return Collections.unmodifiableList(
                new ArrayList<>(roles)
        );
    }
}

class Driver {
    public static void main(String[] args) {
        List<String> roles = new ArrayList<>();
        roles.add("ADMIN");

        // Set of Departments in a company
        Department dep = new Department("HR");// The department objects are mutable, can be chnaged with setter functions
        Department dep2 = new Department("DG");

        // Set of employees in a company, with various departments
        ImmutableEmployee emp = new ImmutableEmployee("Deba", dep, roles);// Immutable, once when we creating an object, we are not storing the department object, rather we are creating a complete new object for ImmutableEmployee, and while initializing the values from constructor, we are creating a new object of department, inside employee object, and calling the assigned department name. So that, once this new Departmentobject is created, and assigned in ImmutableEmployee Object, then if we now, modify the respective Department through setter, that will not change the department we stored under Immutable Employee Object
        ImmutableEmployee emp2 = new ImmutableEmployee("Arko", dep, roles);

        System.out.println(emp.getDepartment().getDepartmentName());
        System.out.println(emp.getName());
        System.out.println(emp.getRoles());

        dep.setDepartmentName("IT"); // Altered the department now of the Object "dep" is pointing
        System.out.println(emp.getDepartment().getDepartmentName()); // But still here we see the old setted data of department, and the value is not different.
        // System.out.println(emp.department.getDepartmentName());
        System.out.println(dep.getDepartmentName());

        //Here emp.getDepartment doesnot bring the actaul Department under ImmutableEmployee, rather it creates a new Department object, and returns it. Now the outsider can modify as much as possible, but the real department object data of and Employee is stored securely
        Department x = emp.getDepartment();
        x.setDepartmentName("BG");
        System.out.println(emp.getDepartment().getDepartmentName());
    }
}