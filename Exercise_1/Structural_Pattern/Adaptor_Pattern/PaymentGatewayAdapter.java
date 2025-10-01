// The Adapter class that makes the ModernPaymentGateway compatible with PaymentProvider.
public class PaymentGatewayAdapter implements PaymentProvider {
    
    // The adapter holds a reference to the adaptee (the new gateway).
    private ModernPaymentGateway modernGateway;

    public PaymentGatewayAdapter(ModernPaymentGateway gateway) {
        this.modernGateway = gateway;
    }

    @Override
    public void processPayment(double amount) {
        // Here is where the "adaptation" happens.
        // We convert the double amount into a String format the new gateway expects.
        System.out.println("Adapter is converting the payment of $" + amount + " for the modern gateway.");
        String paymentDetails = "amount=" + amount + ";currency=USD";
        
        // Now, we call the method on the adapted object.
        modernGateway.submitPayment(paymentDetails);
    }
}

