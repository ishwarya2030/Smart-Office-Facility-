import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ModernPaymentGateway payPalGateway = new PayPalGateway();
        PaymentProvider paymentAdapter = new PaymentGatewayAdapter(payPalGateway);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to pay: ");
        double amount = scanner.nextDouble();

        System.out.println("\n--- Using the Adapter to process a payment ---");
        paymentAdapter.processPayment(amount);
        
        scanner.close();
    }
}