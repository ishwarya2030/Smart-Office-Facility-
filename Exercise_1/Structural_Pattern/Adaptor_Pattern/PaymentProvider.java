// This is the interface that our e-commerce system expects to use.
public interface PaymentProvider {
    void processPayment(double amount);
}

