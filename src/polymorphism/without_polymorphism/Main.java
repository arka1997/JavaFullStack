package without_polymorphism;

public class Main {
    public static void main(String[] args) {
        // Lets say we have Payment Class, that is parent. Now there are child classes(Ex. GPay, PhonePay, Stripe) that needs to inherit methods of Parent class by Overriding.
        // Now lets say, a Gpay request came from client. And our business logic has if-else bocks, that redirects to the class, depending on request. Now without polymorphism, we have so many if-else blocksa. nOW TOmorrow, a new payment gateway comes, and you remove an existing one, then we have to go and chnage the logic, in business logic, as well as the other services that are involved for the payment gateways. 
        // If it was polymorphic buisiness logic, then at runtime, the object send from client will get initialized, and call its respective method
        System.out.println("=== WITHOUT POLYMORPHISM ===");

        PaymentService service = new PaymentService();

        service.processPayment(PaymentType.CREDIT_CARD, 100.0);
        service.processPayment(PaymentType.PAYPAL, 50.0);
        service.processPayment(PaymentType.UPI, 25.0);

        System.out.println("\n❌ To add CRYPTO here:");
        System.out.println(" 1. Edit PaymentType.java -> Add CRYPTO");
        System.out.println(" 2. Edit PaymentService.java -> Add case CRYPTO:");
        System.out.println(" (Modifying existing code creates risk of breaking existing features!)");
    }
}
