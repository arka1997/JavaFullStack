
class Product {
    public String name;
    public String desc;
    public int displayProductDetails(){
        System.out.println("This is a general product");
        return 20;
    }
}

class ElectronicsProduct extends Product {
    public String size;
    public String color;

    public ElectronicsProduct(String size, String color){
        this.size = size;
        this.color = color;
    }

    // Here child or Parent(PRODUCT) is very disobedient, now he doesn't listens to his parent. The parent told to return 20. But he created his own method, and returned something else.
    @Override
    public int displayProductDetails(){
        System.out.println("This is a Electronics product");
        return 40;
    }

    public static void main(String[] args) {
        // UPCASTING
        Product p = new ElectronicsProduct("Small", "Red");

        // p can access only members visible in Product
        System.out.println("Product reference: " + p.name);

        // DOWNCASTING
        ElectronicsProduct elc = (ElectronicsProduct) p;

        // elc can access child-specific members
        System.out.println("Electronics size: " + elc.size);
        System.out.println("Electronics color: " + elc.color);
    }
}
public class InheritancePractice {
    public static void main(String[] args) {
        ElectronicsProduct elc = new ElectronicsProduct("Small", "Red");
        System.out.println(elc.displayProductDetails());
    }
}
