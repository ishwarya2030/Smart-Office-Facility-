package Exercise_1.Behavioral_Pattern.Observer_Pattern;

import java.util.*;

// Subject (Weather Station)
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (Observer obs : observers) {
            obs.update(temperature);
        }
    }
}

// Observer interface
interface Observer {
    void update(int temp);
}

// Concrete Observers
class MobileApp implements Observer {
    public void update(int temp) {
        System.out.println("📱 Mobile App: Temperature updated to " + temp + "°C");
    }
}

class LEDDisplay implements Observer {
    public void update(int temp) {
        System.out.println("💡 LED Display: Temperature is now " + temp + "°C");
    }
}

// Main
public class ObserverDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WeatherStation station = new WeatherStation();

        // Add observers
        station.addObserver(new MobileApp());
        station.addObserver(new LEDDisplay());

        System.out.println("Enter temperature values (type -1 to stop):");

        while (true) {
            int temp = sc.nextInt();
            if (temp == -1) break; // stop input
            station.setTemperature(temp);
        }

        System.out.println("Weather monitoring stopped.");
        sc.close();
    }
}
