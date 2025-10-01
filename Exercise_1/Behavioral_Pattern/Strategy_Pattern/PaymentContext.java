// Context
public class PaymentContext {
    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void payBill(int amount) {
        strategy.pay(amount);
    }
}
