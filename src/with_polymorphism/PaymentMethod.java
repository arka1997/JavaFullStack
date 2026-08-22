package with_polymorphism;

/**
 * 🌟 The Polymorphic Interface (Contract)
 * Any class that implements this can be used as a PaymentMethod.
 */
public interface PaymentMethod {
    void pay(double amount);
}
