// Main class to demonstrate the Singleton Connection Manager
public class SingletonDemo {

    public static void main(String[] args) {
        System.out.println("--- Web Service A needs a database connection ---");
        DatabaseConnectionManager manager1 = DatabaseConnectionManager.getInstance();
        String conn1 = manager1.getConnection();
        System.out.println("Web Service A received: " + conn1);

        System.out.println("\n--- Reporting Service B needs a database connection ---");
        DatabaseConnectionManager manager2 = DatabaseConnectionManager.getInstance();
        String conn2 = manager2.getConnection();
        System.out.println("Reporting Service B received: " + conn2);
        
        System.out.println("\n--- Web Service A is done, releases its connection ---");
        manager1.releaseConnection(conn1);
        
        System.out.println("\n--- Payment Service C needs a database connection ---");
        DatabaseConnectionManager manager3 = DatabaseConnectionManager.getInstance();
        String conn3 = manager3.getConnection(); // Should get the connection A released
        System.out.println("Payment Service C received: " + conn3);

        // Verify that all manager variables point to the same object
        if (manager1 == manager2 && manager2 == manager3) {
            System.out.println("\nVerification successful: All services are using the same single connection manager instance.");
        }
    }
}
