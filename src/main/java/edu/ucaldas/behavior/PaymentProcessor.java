package edu.ucaldas.behavior;

public class PaymentProcessor {
    private PaymentStrategy strategy;

    public PaymentProcessor(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public String process(double amount) {
        if (strategy == null) throw new IllegalStateException("PaymentStrategy not set");
        return strategy.pay(amount);
    }
}
