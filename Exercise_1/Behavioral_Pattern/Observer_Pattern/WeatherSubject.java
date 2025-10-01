
import java.util.ArrayList;
import java.util.List;

// Subject (Weather Station)
public class WeatherSubject {
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
