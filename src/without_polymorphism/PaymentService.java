package without_polymorphism;

/**
 * ❌ PROBLEM / CODE SMELL:
 * 
 * To add a new payment method (e.g. CRYPTO), you MUST modify this class!
 * You have to open this existing, working code and add a new "case CRYPTO:".
 * If you make a mistake here, you could break existing Credit Card or PayPal logic.
 */
public class PaymentService {

    public void processPayment(PaymentType type, double amount) {
        switch (type) {
            case CREDIT_CARD:
                System.out.println("💳 Paid $" + amount + " using Credit Card");
                break;

            case PAYPAL:
                System.out.println("🅿️ Paid $" + amount + " using PayPal");
                break;

            case UPI:
                System.out.println("📲 Paid $" + amount + " using UPI");
                break;

            // ⚠️ To add CRYPTO, you are FORCED to modify this class:
            // case CRYPTO:
            //     System.out.println("🪙 Paid $" + amount + " using Crypto");
            //     break;

            default:
                System.out.println("❌ Unknown payment type!");
        }
    }
}
