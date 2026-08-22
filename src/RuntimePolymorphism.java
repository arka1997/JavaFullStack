class Delivery {
    public void estimateTime(String hour, String minute){
        System.out.println("Parent Delivery estimated time " + hour + " " + minute);
    }
}

class ExpressDelivery extends Delivery {
    public void estimateTime(String hour, String minute){
        System.out.println("Child Express Delivery estimated time " + hour + " " + minute);
    }
}


class OneDayDelivery extends ExpressDelivery {
    public void estimateTime(String hour, String minute){
        System.out.println("Child One Day Delivery estimated time " + hour + " " + minute);
    }
}

class QuickCommerceDelivery extends OneDayDelivery {

}

public class RuntimePolymorphism {
    public static void main(String[] args) {
        Delivery d = new ExpressDelivery();
        d.estimateTime("24 hr","20 min");

        Delivery d2 = new OneDayDelivery();
        d2.estimateTime("22 hr","30 min");

        // hERE AS THERE IS NO METHOD DEFINED IN QuickCommerceDelivery class, so it goes to its parent to give the method. Thatswhy we have to declare the method in top-most parent, if child has no method, it goes further up to the top-most parent, which is a default method.
        Delivery d3 = new QuickCommerceDelivery();
        d3.estimateTime("20 hr","10 min");
    }
}
