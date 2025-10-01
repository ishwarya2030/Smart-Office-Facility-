import java.util.Scanner;

// Main class to demonstrate the Strategy Pattern
public class StrategyMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter amount to pay: ");
        int amount = sc.nextInt();

        System.out.println("Choose payment method: 1.Credit Card  2.UPI  3.Cash");
        int choice = sc.nextInt();

        PaymentContext context;
        switch (choice) {
            case 1:
                context = new PaymentContext(new CreditCardPayment());
                break;
            case 2:
                context = new PaymentContext(new UPIPayment());
                break;
            case 3:
                context = new PaymentContext(new CashPayment());
                break;
            default:
                System.out.println("Invalid choice");
                sc.close();
                return;
        }

        context.payBill(amount);
        sc.close();
    }
}
