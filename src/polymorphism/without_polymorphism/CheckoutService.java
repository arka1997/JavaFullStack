package without_polymorphism;

public class CheckoutService {

    public void checkout(PaymentType type, double amount) {
        System.out.println("-- CheckoutService processing " + type + " for $" + amount);
        switch (type) {
            case CREDIT_CARD:
                System.out.println("[Checkout] Calling Credit Card API for payment of $" + amount);
                break;
            case PAYPAL:
                System.out.println("[Checkout] Calling PayPal API for payment of $" + amount);
                break;
            case UPI:
                System.out.println("[Checkout] Calling UPI API for payment of $" + amount);
                break;
            default:
                System.out.println("[Checkout] Unknown payment type");
        }
    }
}
