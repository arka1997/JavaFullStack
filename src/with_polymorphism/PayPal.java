package with_polymorphism;

public class PayPal implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("🅿️ Paid $" + amount + " using PayPal");
    }
}
