package with_polymorphism;

/**
 * ✅ CLEAN & CLOSED FOR MODIFICATION:
 * 
 * This service takes the INTERFACE `PaymentMethod`.
 * It doesn't care whether you pass CreditCard, PayPal, UPI, Crypto, or ApplePay.
 * You NEVER have to touch this class again when adding new payment methods!
 */
public class PaymentService {

    public void processPayment(PaymentMethod method, double amount) {
        // Dynamic Dispatch: Calls the actual class's pay() method at runtime!
        method.pay(amount);
    }
}
