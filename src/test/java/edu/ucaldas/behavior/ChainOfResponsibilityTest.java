package edu.ucaldas.behavior;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChainOfResponsibilityTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("=== Ejercicio: Chain of Responsibility (SupportHandler) ===");
    }

    @Test
    public void testBasicRequest() {
        Handler handler = SupportHandler.createChain();
        assertEquals("Atendido por Soporte Básico", handler.handleRequest("básica"));
    }

    @Test
    public void testSupervisorRequest() {
        Handler handler = SupportHandler.createChain();
        assertEquals("Atendido por Supervisor", handler.handleRequest("intermedia"));
    }

    @Test
    public void testManagerRequest() {
        Handler handler = SupportHandler.createChain();
        assertEquals("Atendido por Gerente", handler.handleRequest("avanzada"));
    }

    @Test
    public void testUnknownRequest() {
        Handler handler = SupportHandler.createChain();
        assertEquals("No se puede atender la solicitud.", handler.handleRequest("desconocida"));
    }
}
