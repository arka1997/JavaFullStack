package set;
// Name should be there
// Price should be there

import java.util.*;

// paymentStatus should be there


// Functionalities: 
// 1. Add unique product -> Products will be unique, so for that we can use HashSet
// 2. Sort product by price -> To order the price, we can use TreeSet. Now treeSet cannot be used for products and price together because, we can sort and prevent duplicates on basis of one property only, here that is price. TreeSet makes sure price is sorted and unique. But in question it is told that productId should be also unique. So for that we need HashSet

// Product Attributes:
// productId(Unique)
// name
// price
// paymentStatus

// Depending on functionalities, we need TreeSet, as it helps maintains uniqueness as well as we can order the elements on basis of price

public class ProductDashboard implements Comparable<ProductDashboard>{
    int productId;
    String name;
    int price;
    String paymentStatus;
    ProductDashboard(int productId, String name, int price, String paymentStatus) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.paymentStatus = paymentStatus;
    }

    @Override
    public int compareTo(ProductDashboard prod){
        return this.price - prod.price;
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.productId, this.name);
    }

    @Override
    public boolean equals(Object obj){
        ProductDashboard prod = (ProductDashboard) obj;
        return Objects.equals(this.productId, prod.productId) & Objects.equals(this.name, prod.name);
    }

    @Override
    public String toString(){
        return "For ProductId "+ this.productId + " " + this.name + " " + this.paymentStatus + " Rs " + this.price + "\n";
    }
}

class Driver {
    public static void main(String[] args) {
        ProductDashboard p = new ProductDashboard(10, "Deba", 100, "paid");
        ProductDashboard p2 = new ProductDashboard(11, "soumo", 200, "paid");
        ProductDashboard p3 = new ProductDashboard(14, "puku", 300, "not paid");
        ProductDashboard p4 = new ProductDashboard(12, "puku", 400, "paid");
        ProductDashboard p5 = new ProductDashboard(12, "puku", 400, "not paid");

        // Now to achieve product Uniqueness, we have to override hashcode and equals, to prevent duplicate entries, or productId. If the requirement was to get uniquenes with productId and name, then in equals and hashCode, we will give the 2 properties together
        Set<ProductDashboard> s = new HashSet<>();
        s.add(p);
        s.add(p2);
        s.add(p3);
        s.add(p4);
        s.add(p5);
        System.out.println(s);

        // Now uniqueness is achieved. Now its time for sorted product order by product's price. For that we need Treeset

        Set<ProductDashboard> sortProd = new TreeSet<>();
        sortProd.addAll(s);
        
        Iterator itr = sortProd.iterator();
        while (itr.hasNext()) {
            ProductDashboard elem = (ProductDashboard) itr.next();
            System.out.println(elem.toString());
        }
        System.out.println(sortProd);
    }
}