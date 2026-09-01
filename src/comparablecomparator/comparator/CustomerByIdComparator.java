package comparablecomparator.comparator;

import java.util.Comparator;

public class CustomerByIdComparator implements Comparator<Customer>{
    public int compare(Customer c1, Customer c2){
        return c1.id - c2.id;
    }
}
