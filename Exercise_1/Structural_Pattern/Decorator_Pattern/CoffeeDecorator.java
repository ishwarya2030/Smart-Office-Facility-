// The abstract Decorator class implements the Component interface and holds a reference to a Component object.
public abstract class CoffeeDecorator implements Coffee {
    
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    // The decorator delegates the calls to the wrapped component.
    public double getCost() {
        return decoratedCoffee.getCost();
    }

    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
}
