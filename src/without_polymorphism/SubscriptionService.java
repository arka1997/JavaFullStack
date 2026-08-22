package without_polymorphism;

public class SubscriptionService {

    public void subscribe(PaymentType type, double amount) {
        System.out.println("-- SubscriptionService processing " + type + " for $" + amount);
        switch (type) {
            case CREDIT_CARD:
                System.out.println("[Subscription] Charging Credit Card for $" + amount);
                break;
            case PAYPAL:
                System.out.println("[Subscription] Charging PayPal for $" + amount);
                break;
            case UPI:
                System.out.println("[Subscription] Charging UPI for $" + amount);
                break;
            default:
                System.out.println("[Subscription] Unknown payment type");
        }
    }
}
