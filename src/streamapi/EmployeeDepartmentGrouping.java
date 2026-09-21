package streamapi;

import java.util.*;
import java.util.stream.Collectors;

class Employee{
    int salary;
    String empName;
    String department;

    Employee(int salary, String empName, String department){
        this.salary = salary;
        this.empName = empName;
        this.department = department;
    }
}
public class EmployeeDepartmentGrouping {

    public static void main(String[] args) {


        List<Employee> employees = Arrays.asList(new Employee(1000, "Deba", "IT"),
                                        new Employee(2000, "Arko", "IT"),
                                        new Employee(3000, "Puku", "IT"),
                                        new Employee(4000, "Bani", "HR"),
                                        new Employee(5000, "Dilip", "HR"),
                                        new Employee(6000, "Sachin", "IT"),
                                        new Employee(7000, "Panchali", "ME"),
                                        new Employee(8000, "Kodewala", "ME"));
                                        
        Map<String, Long> group = employees.stream().collect(Collectors.groupingBy(emp -> emp.department, Collectors.counting()));
        System.out.println("Group By Department" + group);
        
    }
}
