package edu.ucaldas.structural;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

public class DecoratorOrderTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("=== Ejercicio 4: Decorator (Pedidos - Burger + extras) ===");
    }

    @Test
    public void testBasicBurger() {
        Product burger = new BasicBurger();
        assertEquals("Burger", burger.getDescription());
        assertEquals(5.0, burger.getPrice(), 0.0001);
    }

    @Test
    public void testBurgerWithCheese() {
        Product burger = new CheeseDecorator(new BasicBurger());
        assertEquals("Burger, Cheese", burger.getDescription());
        assertEquals(6.0, burger.getPrice(), 0.0001);
    }

    @Test
    public void testBurgerWithCheeseAndBacon() {
        Product burger = new BaconDecorator(new CheeseDecorator(new BasicBurger()));
        assertEquals("Burger, Cheese, Bacon", burger.getDescription());
        assertEquals(7.5, burger.getPrice(), 0.0001);
    }
}
