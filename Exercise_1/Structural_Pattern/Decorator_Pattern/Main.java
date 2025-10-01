import java.util.Scanner;

// Main class to demonstrate the Decorator Pattern with user input.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Start with a base coffee
        Coffee myCoffee = new SimpleCoffee();
        
        System.out.println("Let's create your coffee order!");
        
        while (true) {
            System.out.println("\nCurrent Order: " + myCoffee.getDescription());
            System.out.println("Current Cost: $" + String.format("%.2f", myCoffee.getCost()));
            System.out.println("\nAdd an extra:");
            System.out.println("  1. Add Milk ($0.50)");
            System.out.println("  2. Add Sugar ($0.20)");
            System.out.println("  3. Finish Order");
            System.out.print("Your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    // Decorate the current coffee object with Milk
                    myCoffee = new WithMilk(myCoffee);
                    System.out.println("-> Milk added.");
                    break;
                case 2:
                    // Decorate the current coffee object with Sugar
                    myCoffee = new WithSugar(myCoffee);
                    System.out.println("-> Sugar added.");
                    break;
                case 3:
                    System.out.println("\n--- Your final order is complete! ---");
                    System.out.println("Final Description: " + myCoffee.getDescription());
                    System.out.println("Final Cost: $" + String.format("%.2f", myCoffee.getCost()));
                    scanner.close();
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

