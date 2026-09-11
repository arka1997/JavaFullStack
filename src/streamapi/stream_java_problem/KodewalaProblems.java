package streamapi.stream_java_problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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




        List<Integer> numbers = Arrays.asList(2,4,6,8,5,3);

        Optional<Integer> o = numbers.stream().filter(e -> e %2 ==0).findFirst();
        System.out.println(o.get());


        Long cnt = numbers.stream().count();

        numbers.stream().sorted((a,b) -> b - a).forEach(out -> System.out.println(out));
        numbers.stream().skip(1).forEach(out -> System.out.println(out));
        
        /**
         *  So first we have list of salaries. Now, we have to find the 3rd highest salary. For that highest, we need to order this
            list in descending order, to bring the highest elements to the top, and reduce no. of operations.
            To get the 3rd highest, we can say to skip the 1st 2 elements, which is first highest and 2nd highest, and then either 
            use findFirst to get the 1st element, or limit 1, will just give the 1st element.
        */
        List<Integer> salary = Arrays.asList(52000, 25000, 32000, 45000, 38000, 52000, 28000, 65000, 41000, 75000, 55000, 32000);
        List<Integer> thirdHighest = salary.stream().distinct().sorted((a,b) -> b - a).skip(2).limit(1).toList();
        System.out.println(thirdHighest);

        /**
         * Find the duplicates from given list of string
         * 1st we can use HashMap to store
         */

        List<String> employee = Arrays.asList("Deba","Arko","Puku","Puku", "Arko");
        HashSet<String> set = new HashSet<>();
        List<String> duplicatesOnly = employee.stream().filter(emps -> !set.add(emps)).toList();
        System.out.println(duplicatesOnly);
    }
}
