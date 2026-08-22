## Polymorphism vs No-Polymorphism — File/Flow view

Below are two flow diagrams (Mermaid) that show how files relate in the `without_polymorphism` and `with_polymorphism` approaches, followed by a short explanation of benefits and flaws.

```mermaid
flowchart LR
  subgraph WithoutPolymorphism [Without Polymorphism]
    direction TB
    Checkout[CheckoutService]
    Subscription[SubscriptionService]
    Refund[RefundService]
    Invoice[InvoiceService]
    PaymentSvc[PaymentService]
    PaymentType[PaymentType (enum)]
    Credit[CreditCard logic]
    PayPal[PayPal logic]
    UPI[UPI logic]

    Checkout -->|switch on| PaymentType
    Subscription -->|switch on| PaymentType
    Refund -->|switch on| PaymentType
    Invoice -->|switch on| PaymentType
    PaymentSvc -->|switch on| PaymentType

    PaymentType --> Credit
    PaymentType --> PayPal
    PaymentType --> UPI
  end

  subgraph WithPolymorphism [With Polymorphism]
    direction TB
    CCheckout[CheckoutService]
    CSubscription[SubscriptionService]
    CRefund[RefundService]
    CInvoice[InvoiceService]

    IPayment[Payment (interface/abstract)]
    CreditImpl[CreditCardPayment]
    PayPalImpl[PayPalPayment]
    UPIImpl[UpiPayment]
    Factory[Factory / DI container]

    CCheckout -->|depends on| IPayment
    CSubscription -->|depends on| IPayment
    CRefund -->|depends on| IPayment
    CInvoice -->|depends on| IPayment

    IPayment --> CreditImpl
    IPayment --> PayPalImpl
    IPayment --> UPIImpl

    Factory -->|provides| CreditImpl
    Factory -->|provides| PayPalImpl
    Factory -->|provides| UPIImpl
  end

  %% Visual connector between the two diagrams to emphasize contrast
  WithoutPolymorphism --- WithPolymorphism
```

Key takeaways

- **Without Polymorphism (flaws):**
  - Business services (Checkout, Subscription, Refund, Invoice, etc.) each contain `switch` logic tied to `PaymentType` and concrete vendor code.
  - Adding or replacing a provider (e.g., PayPal → Stripe) requires editing many files and adapting to different vendor APIs.
  - Duplicate code increases maintenance effort and risk of inconsistent behavior.

- **With Polymorphism (benefits):**
  - Business services depend only on the `Payment` abstraction.
  - Vendor-specific behavior is implemented once per provider (`PayPalPayment`, `StripePayment`, ...).
  - Replacing or adding providers requires changing or adding one implementation and adjusting DI/factory wiring — business code remains unchanged.
  - Easier to unit-test: inject test doubles that implement `Payment`.

Recommended next steps

1. Keep the `without_polymorphism` example for teaching, but add a `with_polymorphism` implementation that shows the `Payment` interface and concrete implementations.
2. Demonstrate a provider swap (PayPal → Stripe) by editing only the concrete implementation and factory registration.

File: [docs/polymorphism-flowchart.md](docs/polymorphism-flowchart.md)
