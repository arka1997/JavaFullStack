package with_polymorphism;

public class Upi implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("📲 Paid $" + amount + " using UPI");
    }
}
