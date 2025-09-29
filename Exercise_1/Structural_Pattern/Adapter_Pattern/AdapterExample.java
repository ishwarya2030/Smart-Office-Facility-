package Exercise_1.Structural_Pattern.Adapter_Pattern;

import java.util.*;

interface IndianSocket {
    void plugIn();
}

class EuropeanPlug {
    public void providePower() {
        System.out.println("⚡ Power from European Plug");
    }
}

class PlugAdapter implements IndianSocket {
    private EuropeanPlug plug;
    public PlugAdapter(EuropeanPlug plug) { this.plug = plug; }
    public void plugIn() { plug.providePower(); }
}

public class AdapterExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Do you want to use a European plug in India? (yes/no): ");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            EuropeanPlug euroPlug = new EuropeanPlug();
            IndianSocket adapter = new PlugAdapter(euroPlug);
            adapter.plugIn();
        } else {
            System.out.println("🔌 Using normal Indian socket.");
        }

        sc.close();
    }
}
