package with_polymorphism;

/**
 * 🌟 ADDING A NEW PAYMENT METHOD (CRYPTO):
 * 
 * Notice that we just create this new class!
 * We DO NOT touch PaymentMethod.java, CreditCard.java, PayPal.java, or PaymentService.java!
 */
public class Crypto implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("🪙 Paid $" + amount + " using Crypto (Bitcoin/Ethereum)");
    }
}
