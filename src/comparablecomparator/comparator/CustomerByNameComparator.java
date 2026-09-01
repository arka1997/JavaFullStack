package comparablecomparator.comparator;
import java.util.*;
public class CustomerByNameComparator implements Comparator<Customer>{
    public int compare(Customer c1, Customer c2){
        return c1.name.compareTo(c2.name);
    }
}
