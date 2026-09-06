package polymorphism.without_polymorphism;

public class RefundService {

    public void refund(PaymentType type, double amount) {
        System.out.println("-- RefundService processing " + type + " for $" + amount);
        switch (type) {
            case CREDIT_CARD:
                System.out.println("[Refund] Initiating Credit Card refund of $" + amount);
                break;
            case PAYPAL:
                System.out.println("[Refund] Initiating PayPal refund of $" + amount);
                break;
            case UPI:
                System.out.println("[Refund] Initiating UPI refund of $" + amount);
                break;
            default:
                System.out.println("[Refund] Unknown payment type");
        }
    }
}
