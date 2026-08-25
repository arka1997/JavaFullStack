package set.hashset.treeset.TreeSetPrac;
import java.util.*;

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
    public String toString(){
        return this.name + " " + this.price;
    }
}

class ProductApplicationDriverWithSet{
    Set<Product> s = new HashSet<>();
    
}