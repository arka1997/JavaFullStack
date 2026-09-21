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
public class Grouping {

    public static void main(String[] args) {


        List<Employee> employees = Arrays.asList(new Employee(1000, "Deba", "IT"),
                                        new Employee(2000, "Arko", "IT"),
                                        new Employee(3000, "Puku", "IT"),
                                        new Employee(4000, "Bani", "HR"),
                                        new Employee(5000, "Dilip", "HR"),
                                        new Employee(6000, "Sachin", "IT"),
                                        new Employee(7000, "Panchali", "ME"),
                                        new Employee(8000, "Kodewala", "ME"));
                                        System.out.println(employees);
        Map<String, Long> group = employees.stream().collect(Collectors.groupingBy(emp -> emp.department, Collectors.counting()));
        System.out.println("Group By Department" + group);
        
        List<String> cities = List.of(
            "Bangalore",
            "Pune",
            "Chennai",
            "Hyderabad",
            "Delhi",
            "Noida",
            "Mysore"
        );

        // Group the cities by length, using Collections groupingBy method, that expects a conditional parameter on basis of what grouping happens, and returns a Map of parameter of Integer and List of Strings
       Map<Integer, List<String>> map = cities.stream().collect(Collectors.groupingBy(i -> i.length()));
       System.out.println(map);

        //    Group the cities by length whose length is more then 6
        Map<Integer, List<String>> map2 = cities.stream()
                                            .filter(i -> i.length() > 6)
                                            .collect(Collectors.groupingBy(i -> i.length()));
        System.out.println(map2);

        // Partitiion by partitions into 2 groups, depending on the condition, it picks the elements and put it in another array, and the one which satisfies the condition falls under "true" block, and the other falls under "false"
        Map<Boolean, List<String>> map3 = cities.stream().collect(Collectors.partitioningBy(i -> i.length() > 6));
        System.out.println(map3);
    }
}
