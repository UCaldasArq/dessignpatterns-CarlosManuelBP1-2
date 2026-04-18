package edu.ucaldas.behavior;

public interface PaymentStrategy {
    /**
     * Process a payment and return a human readable result.
     */
    String pay(double amount);
}
