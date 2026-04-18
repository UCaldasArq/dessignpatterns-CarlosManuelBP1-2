package edu.ucaldas.behavior;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentStrategyTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("=== Ejercicio 5: Strategy (Payment methods) ===");
    }

    @Test
    public void testCreditCardPayment() {
        PaymentProcessor processor = new PaymentProcessor(new CreditCardStrategy("1234567812345678"));
        String result = processor.process(10.5);
        assertEquals("Paid 10.50 with CreditCard (card: ****5678)", result);
    }

    @Test
    public void testSwitchToPaypal() {
        PaymentProcessor processor = new PaymentProcessor(new CreditCardStrategy("1111222233334444"));
        processor.setStrategy(new PaypalStrategy("user@example.com"));
        String result = processor.process(20);
        assertEquals("Paid 20.00 with PayPal (account: user@example.com)", result);
    }

    @Test
    public void testCryptoPayment() {
        PaymentProcessor processor = new PaymentProcessor(new CryptoStrategy("0xABCDEF"));
        String result = processor.process(0.123);
        assertEquals("Paid 0.12 with Crypto (wallet: 0xABCDEF)", result);
    }
}
