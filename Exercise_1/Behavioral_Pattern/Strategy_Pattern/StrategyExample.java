package Exercise_1.Behavioral_Pattern.Strategy_Pattern;

import java.util.*;

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class UPIPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

class CashPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Cash");
    }
}

class PaymentContext {
    private PaymentStrategy strategy;
    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    public void payBill(int amount) {
        strategy.pay(amount);
    }
}

public class StrategyExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter amount to pay: ");
        int amount = sc.nextInt();

        System.out.println("Choose payment method: 1.Credit Card  2.UPI  3.Cash");
        int choice = sc.nextInt();

        PaymentContext context;
        switch (choice) {
            case 1: context = new PaymentContext(new CreditCardPayment()); break;
            case 2: context = new PaymentContext(new UPIPayment()); break;
            case 3: context = new PaymentContext(new CashPayment()); break;
            default: System.out.println("Invalid choice"); sc.close(); return;
        }

        context.payBill(amount);
        sc.close();
    }
}
