package with_polymorphism;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== WITH POLYMORPHISM ===");

        PaymentService service = new PaymentService();

        // We can create any payment method
        PaymentMethod card = new CreditCard();
        PaymentMethod paypal = new PayPal();
        PaymentMethod upi = new Upi();

        // Pass them polymorphically, this is our UI side
        service.processPayment(card, 100.0);
        service.processPayment(paypal, 50.0);
        service.processPayment(upi, 25.0);

        System.out.println("\n🌟 Now we add CRYPTO:");
        System.out.println(" We created Crypto.java and passed it below.");
        System.out.println(" ZERO changes were made to PaymentService.java or any other class!");

        PaymentMethod crypto = new Crypto();
        service.processPayment(crypto, 75.0);
    }
}
