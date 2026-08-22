package without_polymorphism;

public class ServicesDemo {
    public static void main(String[] args) {
        CheckoutService checkout = new CheckoutService();
        SubscriptionService subscription = new SubscriptionService();
        RefundService refund = new RefundService();
        InvoiceService invoice = new InvoiceService();

        System.out.println("=== DEMO: Without Polymorphism - duplicated vendor logic across services ===\n");

        double amount = 42.0;

        // Each business service has its own vendor-specific logic (duplicated)
        checkout.checkout(PaymentType.PAYPAL, amount);
        subscription.subscribe(PaymentType.PAYPAL, amount);
        refund.refund(PaymentType.PAYPAL, amount);
        invoice.generateInvoice(PaymentType.PAYPAL, amount);

        // PaymentService is a separate class that also contains vendor-specific logic.
        // This shows that multiple files must be updated when a provider changes.
        PaymentService paymentService = new PaymentService();
        paymentService.processPayment(PaymentType.PAYPAL, amount);

        System.out.println("\n--- Now simulate vendor change: replace PAYPAL with STRIPE (conceptually) ---");
        System.out.println("You would need to update each service above to know about Stripe's API and behavior.");
    }
}
