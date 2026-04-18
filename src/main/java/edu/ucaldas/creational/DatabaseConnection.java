package edu.ucaldas.creational;

/**
 * Thread-safe Singleton for a (mock) database connection.
 */
public class DatabaseConnection {
    private static volatile DatabaseConnection instance;

    // private constructor to prevent instantiation
    private DatabaseConnection() {
        // simulate expensive setup if needed
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    // example method to simulate usage
    public String query(String sql) {
        return "Result for: " + sql;
    }
}
