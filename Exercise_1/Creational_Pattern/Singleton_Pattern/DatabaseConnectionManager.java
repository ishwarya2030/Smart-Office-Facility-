import java.util.ArrayList;
import java.util.List;

// The Singleton class for managing database connections
public class DatabaseConnectionManager {

    // 1. The single, static instance of the class
    private static DatabaseConnectionManager instance;
    private List<String> connectionPool;
    private static final int MAX_CONNECTIONS = 5;

    // 2. Private constructor to prevent external instantiation
    private DatabaseConnectionManager() {
        System.out.println("Creating a new database connection pool...");
        connectionPool = new ArrayList<>();
        // Simulate creating a pool of connections
        for (int i = 1; i <= MAX_CONNECTIONS; i++) {
            connectionPool.add("Connection-" + i);
        }
        System.out.println("Connection pool initialized with " + MAX_CONNECTIONS + " connections.");
    }

    // 3. Public static method to get the single instance
    public static DatabaseConnectionManager getInstance() {
        // Using lazy initialization
        if (instance == null) {
            instance = new DatabaseConnectionManager();
        }
        return instance;
    }

    // --- Business logic methods ---

    /**
     * Gets a connection from the pool.
     * @return A connection string, or null if the pool is empty.
     */
    public String getConnection() {
        if (connectionPool.isEmpty()) {
            System.out.println("No available connections in the pool.");
            return null;
        }
        // Remove and return the first available connection
        String connection = connectionPool.remove(0);
        System.out.println("Lent out: " + connection + ". Available connections: " + connectionPool.size());
        return connection;
    }

    /**
     * Releases a connection back to the pool.
     * @param connection The connection string to be returned.
     */
    public void releaseConnection(String connection) {
        if (connection != null) {
            connectionPool.add(connection);
            System.out.println("Returned: " + connection + ". Available connections: " + connectionPool.size());
        }
    }
}

