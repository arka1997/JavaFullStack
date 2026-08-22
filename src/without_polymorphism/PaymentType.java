package without_polymorphism;

/**
 * All supported payment types hardcoded in an enum.
 * ❌ PROBLEM: Adding CRYPTO forces you to edit this file!
 */
public enum PaymentType {
    CREDIT_CARD,
    PAYPAL,
    UPI
    // To add CRYPTO, you must edit this file:
    // , CRYPTO
}
