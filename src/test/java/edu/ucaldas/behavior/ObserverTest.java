package edu.ucaldas.behavior;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

public class ObserverTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("=== Ejercicio 6: Observer (Stock / Investors) ===");
    }

    @Test
    public void testNotifyInvestors() {
        Stock s = new Stock("ACME", 100.0);
        ConcreteInvestor a = new ConcreteInvestor("Alice");
        ConcreteInvestor b = new ConcreteInvestor("Bob");

        s.addInvestor(a);
        s.addInvestor(b);

        s.setPrice(110.5);

        assertEquals("ACME", a.getLastSymbol());
        assertEquals(110.5, a.getLastPrice(), 0.0001);
        assertEquals("ACME", b.getLastSymbol());
        assertEquals(110.5, b.getLastPrice(), 0.0001);
    }

    @Test
    public void testRemoveInvestor() {
        Stock s = new Stock("ACME", 50.0);
        ConcreteInvestor a = new ConcreteInvestor("Alice");
        s.addInvestor(a);
        s.setPrice(55.0);
        assertEquals(55.0, a.getLastPrice(), 0.0001);

        s.removeInvestor(a);
        s.setPrice(60.0);
        // should still be last 55.0
        assertEquals(55.0, a.getLastPrice(), 0.0001);
    }
}
