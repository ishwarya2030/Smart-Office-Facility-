package Exercise_1.Creational_Pattern.Factory_Pattern;

import java.util.*;

interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() { System.out.println("⚪ Drawing Circle"); }
}

class Square implements Shape {
    public void draw() { System.out.println("⬛ Drawing Square"); }
}

class ShapeFactory {
    public Shape getShape(String type) {
        if (type.equalsIgnoreCase("circle")) return new Circle();
        if (type.equalsIgnoreCase("square")) return new Square();
        return null;
    }
}

public class FactoryExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShapeFactory factory = new ShapeFactory();

        System.out.print("Enter shape to draw (circle/square): ");
        String input = sc.nextLine();

        Shape shape = factory.getShape(input);
        if (shape != null) {
            shape.draw();
        } else {
            System.out.println("❌ Invalid shape!");
        }
        sc.close();
    }
}
