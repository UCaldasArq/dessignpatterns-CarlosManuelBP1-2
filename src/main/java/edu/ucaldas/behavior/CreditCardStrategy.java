package edu.ucaldas.behavior;

import java.util.Locale;

public class CreditCardStrategy implements PaymentStrategy {
    private final String cardNumber;

    public CreditCardStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String pay(double amount) {
        String masked = "****" + (cardNumber.length() >= 4 ? cardNumber.substring(cardNumber.length() - 4) : cardNumber);
        return String.format(Locale.US, "Paid %.2f with CreditCard (card: %s)", amount, masked);
    }
}
