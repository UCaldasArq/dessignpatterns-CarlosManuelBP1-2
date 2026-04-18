package edu.ucaldas.creational;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShapeFactoryTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("=== Ejercicio 1: Factory Method (ShapeFactory) ===");
    }

    @Test
    public void testCircleCreation() {
        ShapeFactory factory = new ShapeFactory();
        Shape shape = factory.createShape("Circle");
        assertEquals("Dibujando un círculo.", shape.draw());
    }

    @Test
    public void testSquareCreation() {
        ShapeFactory factory = new ShapeFactory();
        Shape shape = factory.createShape("Square");
        assertEquals("Dibujando un cuadrado.", shape.draw());
    }

    @Test
    public void testInvalidShape() {
        ShapeFactory factory = new ShapeFactory();
        Shape shape = factory.createShape("Triangle");
        assertNull(shape);
    }
}
