package TreeSetPrac;
// Name should be there
// Price should be there
// status should be there

import java.util.*;

// Functionalities: 
// 1. Add unique product
// 2. Sort product by price

// Depending on functionalities, we need TreeSet, as it helps maintains uniqueness as well as we can order the elements on basis of price

class Product implements Comparable<Product> {
    int productId;
    String name;
    int price;
    String status;
    Product(int productId, String name, int price, String status) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.status = status;
    }
    @Override
    public int compareTo(Product obj){
        return this.price - obj.price;
    }

    @Override
    public String toString() {
        return "Product{id=" + productId +
            ", name='" + name +
            "', price=" + price +
            ", status='" + status + "'}";
    }
}
public class ProductApplicationDriver {
    public static void main(String[] args) {

        Set<Product> s = new TreeSet<>();
        Product p = new Product(10, "Deba", 100, "paid");
        Product p2 = new Product(11, "soumo", 200, "paid");
        Product p3 = new Product(12, "arko", 300, "paid");
        Product p4 = new Product(14, "puku", 400, "paid");


        s.add(p);
        s.add(p2);
        s.add(p3);
        s.add(p4);

        Iterator<Product> itr = s.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
