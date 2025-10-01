import java.util.Scanner;

public class ObserverDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WeatherSubject station = new WeatherSubject();

        station.addObserver(new MobileApp());
        station.addObserver(new LEDDisplay());

        System.out.println("Enter temperature values (type -1 to stop):");

        while (true) {
            int temp = sc.nextInt();
            if (temp == -1) break;
            station.setTemperature(temp);
            System.out.println("Enter temperature values (type -1 to stop):");

        }

        System.out.println("Weather monitoring stopped.");
        sc.close();
    }
}
