package edu.ucaldas.structural;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotifierDecoratorTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("=== Ejercicio 4: Decorator (Notifier) ===");
    }

    @Test
    public void testEmailNotifier() {
        Notifier email = new EmailNotifier();
        assertEquals("Email enviado: Hola", email.send("Hola"));
    }

    @Test
    public void testSMSDecorator() {
        Notifier email = new EmailNotifier();
        Notifier sms = new SMSNotifier(email);
        assertEquals("SMS enviado: Hola | Email enviado: Hola", sms.send("Hola"));
    }
}
