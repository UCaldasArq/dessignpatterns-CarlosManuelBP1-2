package edu.ucaldas.behavior;

import java.util.Locale;

public class CryptoStrategy implements PaymentStrategy {
    private final String walletAddress;

    public CryptoStrategy(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public String pay(double amount) {
        return String.format(Locale.US, "Paid %.2f with Crypto (wallet: %s)", amount, walletAddress);
    }
}
