// This is another concrete decorator that adds sugar.
public class WithSugar extends CoffeeDecorator {
    
    public WithSugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.2;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with Sugar";
    }
}
