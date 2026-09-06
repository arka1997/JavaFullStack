package polymorphism.without_polymorphism;

public class InvoiceService {

    public void generateInvoice(PaymentType type, double amount) {
        System.out.println("-- InvoiceService processing " + type + " for $" + amount);
        switch (type) {
            case CREDIT_CARD:
                System.out.println("[Invoice] Recording Credit Card invoice for $" + amount);
                break;
            case PAYPAL:
                System.out.println("[Invoice] Recording PayPal invoice for $" + amount);
                break;
            case UPI:
                System.out.println("[Invoice] Recording UPI invoice for $" + amount);
                break;
            default:
                System.out.println("[Invoice] Unknown payment type");
        }
    }
}
