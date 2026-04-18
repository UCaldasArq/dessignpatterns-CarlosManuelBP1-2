package edu.ucaldas.behavior;

import java.util.Locale;

public class PaypalStrategy implements PaymentStrategy {
    private final String email;

    public PaypalStrategy(String email) {
        this.email = email;
    }

    @Override
    public String pay(double amount) {
        return String.format(Locale.US, "Paid %.2f with PayPal (account: %s)", amount, email);
    }
}
