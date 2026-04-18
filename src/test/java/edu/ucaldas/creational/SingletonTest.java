package edu.ucaldas.creational;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.*;

public class SingletonTest {

    @org.junit.jupiter.api.BeforeAll
    public static void beforeAll() {
        System.out.println("=== Ejercicio 2: Singleton (DatabaseConnection) ===");
    }

    @Test
    public void testSameInstanceSingleThread() {
        DatabaseConnection a = DatabaseConnection.getInstance();
        DatabaseConnection b = DatabaseConnection.getInstance();
        assertSame(a, b);
    }

    @Test
    public void testSameInstanceMultiThread() throws Exception {
        Callable<DatabaseConnection> task = () -> DatabaseConnection.getInstance();
        int threads = 10;
        ExecutorService ex = Executors.newFixedThreadPool(threads);
        try {
            java.util.List<Future<DatabaseConnection>> futures = new java.util.ArrayList<>();
            for (int i = 0; i < threads; i++) {
                futures.add(ex.submit(task));
            }
            DatabaseConnection first = futures.get(0).get();
            for (Future<DatabaseConnection> f : futures) {
                assertSame(first, f.get());
            }
        } finally {
            ex.shutdown();
        }
    }
}
