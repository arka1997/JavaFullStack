package polymorphismPrac;

public class DriverClient {
    // Here in polymorphism, we are chnaging the system, lets say tomorrow a new payment gateway comes, and we want to integrate that, then simply we create that payment's class, and client if selects, then that classes method will be called. Also, if lets say CardPayment, wants to have some more validations, then simply from doPayments, he can call different other methods in same class.
    public static void main(String[] args) {
        // Create an Object of payment class, and store it inside Parent REFERENCE
        // But here client needs to select from UI, about which payment gateway he needs to select, and based on the request the processor redirects to the required payment gateways class's doPayment methods for payments.
        Payment payment = new CardPayment();
        PaymentProcessor process = new PaymentProcessor();
        process.getPaymentFromDriver(payment);
    }
}
