// A concrete implementation of the new payment gateway.
public class PayPalGateway implements ModernPaymentGateway {
    @Override
    public void submitPayment(String paymentDetails) {
        System.out.println("Processing payment through PayPal: " + paymentDetails);
    }
}

