package streamapi.stream_java_problem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    String name;
    int salary;

    Employee(String name, int salary){
        this.name = name;
        this.salary = salary;
    }
}

class Products {
    String name;
    int price;

    Products(String name, int price){
        this.name = name;
        this.price = price;
    }
}

public class KodewalaProblems {
    /**
     *  1.   ⁠Given a list of integers, use filter() to find all numbers greater than 50.

        2.	Given a list of employee names, use map() to convert all names to uppercase.

        3.	Given a list of employees, use filter() to find employees with salary greater than 10 LPA and map() to get only their names.

        4.	Given a list of products, use filter() to find products with price greater than 1,000 and map() to apply a 10% discount.

        5.	Given List<List<String>>, use flatMap() to convert it into a single List<String>.
    */
    public static void main(String[] args) {
        // Problem 1.
        List<Integer> l = Arrays.asList(23,56,12,78,34,23,56,98,26,16);
        List<Integer> result = l.stream().filter(num -> num > 50).collect(Collectors.toList());
        System.out.println("Numbers > 50: " + result);

        // Problem 2:

        List<String> employees = Arrays.asList("Deba","Arko","Puku");
        List<String> result2 = employees.stream()
        .map(name -> name.toUpperCase())
        .collect(Collectors.toList());
        System.out.println("Convert to Uppercase: " + result2);

        // Problem 3:

        List<Employee> emp = Arrays.asList(new Employee("Deba", 100000),new Employee("Arko", 200000),new Employee("Puku", 500000));
        List<String> result3 = emp.stream()
        .filter(e -> e.salary > 100000)
        .map(name -> name.name)
        .collect(Collectors.toList());

        System.out.println("Return name of employee whose salary > 100000: " + result3);

        // Problem 4:
        List<Products> prod = Arrays.asList(new Products("Apple", 100000),new Products("Mango", 200000),new Products("Strawberry", 500000));
        List<Double> result4 = prod.stream()
                                    .filter(obj -> obj.price > 100000)
                                    .map(obj -> obj.price - (obj.price * 0.1))
                                    .collect(Collectors.toList());
        System.out.println("Price of Apples greater then 100000, apply 10% discount: " + result4);

        //  Problem 5:

        List<List<String>> toD = Arrays.asList(Arrays.asList("Maya", "Vriksh", "Mayavriksh"), Arrays.asList("Bangalore","Chennai"));
        List<String> result5 = toD.stream()
        .flatMap(e -> e.stream())
        .filter(e -> e.length() > 6)
        .collect(Collectors.toList());
        System.out.println("Lengths of cities greater then 6: " + result5);
    }
}
