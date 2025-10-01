import java.util.Scanner;

// Main class to demonstrate the Factory Pattern
public class NotificationMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NotificationFactory factory = new NotificationFactory();

        while (true) {
            System.out.println("\nChoose notification type:");
            System.out.println("  1. SMS");
            System.out.println("  2. EMAIL");
            System.out.println("  3. PUSH");
            System.out.println("  4. ALL");
            System.out.println(" -1. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == -1) {
                System.out.println("Exiting application.");
                break;
            }

            try {
                switch (choice) {
                    case 1:
                        factory.createNotification("SMS").notifyUser();
                        break;
                    case 2:
                        factory.createNotification("EMAIL").notifyUser();
                        break;
                    case 3:
                        factory.createNotification("PUSH").notifyUser();
                        break;
                    case 4:
                        System.out.println("--- Sending all notifications ---");
                        factory.createNotification("SMS").notifyUser();
                        factory.createNotification("EMAIL").notifyUser();
                        factory.createNotification("PUSH").notifyUser();
                        System.out.println("-----------------------------");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}

