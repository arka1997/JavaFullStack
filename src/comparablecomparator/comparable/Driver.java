package comparablecomparator.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// Here we use this, when we have control on this class, and we are the owner, and we are free to modify in this class, like implementing Comparable
// There was a situaation when, in my own class I had to sort the Object data depending on the Health Insurance Plans, so I implemented Comparable Interface, and used compareTo() method, to achieve that.
class Product implements Comparable<Product>{
    int productId;
    String productName;

    Product(int productId, String productName){
        this.productId = productId;
        this.productName = productName;
    }

    // to sort in descending order, we do the reverse "cmp.productId - this.productId"
    // 1. productId different → result should be != 0 → Return result in DESCENDING order
    // 2. if product ID is same → result should be == 0 → Sort by productName → DESCENDING order
    @Override
    public int compareTo(Product cmp){
        int result = cmp.productId - this.productId;
        
        if(result != 0){
            return result;
        }
       return cmp.productName.compareTo(this.productName);
    }
}

public class Driver {
        public static void main(String[] args) {
            
        List<Product> prod = new ArrayList<>();
        Product p = new Product(10, "LgPhone");
        Product p2 = new Product(10, "AppleTab");
        Product p3 = new Product(14, "Nokia");
        Product p4 = new Product(14, "Pokia");
        prod.add(p);
        prod.add(p2);
        prod.add(p3);
        prod.add(p4);
        // This Collections method extends Comparable internally to sort the Objects with respect to productId and productName(as fallback when id is same)
        Collections.sort(prod);
        System.out.println(prod);

        for(int i = 0; i < prod.size(); i++){
            Product sortProd = prod.get(i);
            System.out.println(sortProd.productId + " " + sortProd.productName);
        }
        }
}
