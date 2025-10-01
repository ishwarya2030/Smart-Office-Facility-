

public class LEDDisplay implements Observer {
    public void update(int temp) {
        System.out.println("LED Display: Temperature is now " + temp + "°C");
    }
}
