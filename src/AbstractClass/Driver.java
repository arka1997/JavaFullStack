package abstractclass;

public class Driver {
    public static void main(String[] args) {
        
        // PaymentSystem p = new PaymentSystem(); Now here, we cant create objects of parent class, because its abstract. We have to call the child class constructor, to reach parent's constructor thorough super().
        CardSystem u = new CardSystem();
        u.doTxn();
    }
}
