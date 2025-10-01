// This is a concrete decorator that adds milk.
public class WithMilk extends CoffeeDecorator {

    public WithMilk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        // Adds the cost of milk to the original cost.
        return super.getCost() + 0.5;
    }

    @Override
    public String getDescription() {
        // Adds the description for milk.
        return super.getDescription() + ", with Milk";
    }
}
