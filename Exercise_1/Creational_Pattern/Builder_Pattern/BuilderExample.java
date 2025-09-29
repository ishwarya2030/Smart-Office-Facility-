package Exercise_1.Creational_Pattern.Builder_Pattern;

import java.util.*;

class Pizza {
    private String base;
    private String cheese;
    private String toppings;

    public Pizza(String base, String cheese, String toppings) {
        this.base = base;
        this.cheese = cheese;
        this.toppings = toppings;
    }

    public void showPizza() {
        System.out.println("🍕 Pizza with " + base + ", " + cheese + ", " + toppings);
    }
}

class PizzaBuilder {
    private String base;
    private String cheese;
    private String toppings;

    public PizzaBuilder setBase(String base) { this.base = base; return this; }
    public PizzaBuilder setCheese(String cheese) { this.cheese = cheese; return this; }
    public PizzaBuilder setToppings(String toppings) { this.toppings = toppings; return this; }

    public Pizza build() {
        return new Pizza(base, cheese, toppings);
    }
}

public class BuilderExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose base: ");
        String base = sc.nextLine();

        System.out.print("Choose cheese: ");
        String cheese = sc.nextLine();

        System.out.print("Choose toppings: ");
        String toppings = sc.nextLine();

        Pizza pizza = new PizzaBuilder()
                .setBase(base)
                .setCheese(cheese)
                .setToppings(toppings)
                .build();

        pizza.showPizza();
        sc.close();
    }
}
