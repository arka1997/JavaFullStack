package streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Employee {

    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
public class FindFirstWithHighestProb {
    public static void main(String[] args) {
        
        List<Integer> input = List.of(100000,4,600000,7,6,300000,14,56700000,8992,56000,78,34,14);
        
        // findFirst() is used when we are only concerned about the first element, that will be returned after satisfying some conditions
        // returns an Optional class, as findFirst(), can be empty, if no element found based on condition, and throw NullpOINTER EXCEPTION
        Optional<Integer> output = input.stream().findFirst();
        System.out.println("Result of 1st Problem " + output.get());

        // Problem2: Find 2nd highest Salary, can contain duplicates,
        // for 3rd highest, write "2" in skip(2)
        Optional<Integer> scndHighOpt = input.stream()
        .distinct()
        .sorted((a,b) -> Integer.compare(b, a))
        .skip(1)
        .findFirst();
        if (scndHighOpt.isPresent()) {
            System.out.println("2nd highest salary among list of Integers : " + scndHighOpt.get());
        }


        // Problem3: First employee with salary > 20,000, but if 2 salary are some, then ignore one of them
        // Output: 150000
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "Rahul", 80000));
        employees.add(new Employee(102, "Amit", 95000));
        employees.add(new Employee(103, "Priya", 120000));
        employees.add(new Employee(104, "Neha", 150000));
        employees.add(new Employee(105, "Ravi", 200000));
        employees.add(new Employee(106, "Sima", 200000));

        Optional<Employee> out = employees.stream()
            .filter(e -> e.getSalary() > 100000)
            .findFirst();

        Employee emp = out.get();
        System.out.println("Result of 2nd Problem " + emp.getSalary());

        // Problem 4: Find 2nd highest Salary
        employees.stream()
        .distinct()
        .sorted((a,b) -> Double.compare(b.getSalary(), a.getSalary()))
        .skip(1).limit(1)
        .forEach(i -> System.out.println(i.getSalary()));

        // Problem 5: Find 3rd highest even number from list of integers
        input.stream()
        .filter(i -> i % 2 == 0)
        .sorted((a,b) -> Integer.compare(b,a))
        .skip(2)
        .limit(1)
        .forEach(s -> System.out.println("Done with limit and forEach is returned " + s));

        /** OR */

        Optional<Integer> o = input.stream()
        .filter(i -> i % 2 == 0)
        .sorted((a,b) -> Integer.compare(b,a))
        .skip(2)
        .findFirst();
        if(o.isPresent()){
            System.out.println("Done with findFirst and Optional is returned " + o.get());
        }
    }
}
