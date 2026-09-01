package comparablecomparator.comparator;

import java.util.*;

public class Driver {
    /**  Where you have used, Comparator and Comparable?
        Comparator sCENARIO: My seniors created one class, and I was told to sort the assets depending on one of the metadata. Now i thought now without touching his class, we can use comparator only. I created a different class, and used it to sort the Objects
        Comparable Scensrio: I was told to create one class, for a new info from Artifactory, tht we have to fetch to our DB. And that should be ordered in terms of deployment date. so I created the class, and made it implement Comparable, and implemented compreTo, where I put the metadata, on basis of which i needed that to be ordered.
                     +--------------------+
                 |     Customer       |
                 |--------------------|
                 | id                 |
                 | name               |
                 +---------+----------+
                           |
                           | objects
                           ▼
                    +-------------+
                    | List<Customer>|
                    +------+------+
                           |
                           |
                     Collections.sort()
                           |
               +-----------+-----------+
               |                       |
               ▼                       ▼
    CustomerByIdComparator       CustomerByNameComparator(Diffferent class, or by creating lamda expression in this class)
    implements Comparator    
               |                       |
               ▼                       ▼
        compare id                compare name
               |                       |
               └───────────┬───────────┘
                           ▼
                    Sorted List
     */               
    public static void main(String[] args) {
        Customer p = new Customer(10, "LgPhone");
        Customer p2 = new Customer(11, "AppleTab");
        Customer p3 = new Customer(14, "Micromax");
        Customer p4 = new Customer(12, "Nokia");

        List<Customer> addCstmr = new ArrayList<>();
        addCstmr.add(p);
        addCstmr.add(p2);
        addCstmr.add(p3);
        addCstmr.add(p4);

        Collections.sort(addCstmr, new CustomerByIdComparator());
        ListIterator litr = addCstmr.listIterator();
            System.out.println("Ascending Order by Id");
        while(litr.hasNext()) {
            Customer cm = (Customer) litr.next();
            System.out.println(cm.id + " " + cm.name);
        }

        Collections.sort(addCstmr, new CustomerByNameComparator());
        ListIterator litr2 = addCstmr.listIterator();
            System.out.println("Ascending Order by Name");
        while(litr2.hasNext()){
            Customer cm2 = (Customer) litr2.next();
            System.out.println(cm2.id + " " + cm2.name);
        }

    // Comparator is a functional interface, so instead of implementing the class, we can use Lamda expression, and putting Customer in generics, to let it know only customer objects will compare. Also inside expression we have implemented compare abstract method.
    // Thus we dont need to create a different class, and make it implement comparator interface and its compare() method
        Comparator<Customer> customerByIdComparator = (c1, c2) -> Integer.compare(c1.id, c2.id);
        Collections.sort(addCstmr, customerByIdComparator); // Now we are ready to sort
        System.out.println("Funtional Interface Lamda expression Use case of comparator " + customerByIdComparator);
        ListIterator litr3 = addCstmr.listIterator();
        while(litr3.hasNext()){
            Customer cm3 = (Customer) litr3.next();
            System.out.println(cm3.id + " " + cm3.name);
        }
    }
}
