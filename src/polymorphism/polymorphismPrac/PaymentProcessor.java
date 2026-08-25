package polymorphism.polymorphismPrac;

public class PaymentProcessor {
    public void getPaymentFromDriver(Payment p){ // We could have kept object here, but thats add a security concern, Any class can be passed then, which is bad. It should be only child classes for Payments.
        // What all client sends,or selects the gateways, based on that the decision/routing is taking place
        p.doPayment(); //Based on the actual object, the specific method is called
    }
}
