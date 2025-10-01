// This is the concrete component - the base object we will decorate.
public class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 2.0; // Base price for a simple coffee
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}
