package with_polymorphism;

public class CreditCard implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("💳 Paid $" + amount + " using Credit Card");
    }
}
