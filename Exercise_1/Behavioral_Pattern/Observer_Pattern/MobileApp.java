
public class MobileApp implements Observer {
    public void update(int temp) {
        System.out.println("Mobile App: Temperature updated to " + temp + "°C");
    }
}
