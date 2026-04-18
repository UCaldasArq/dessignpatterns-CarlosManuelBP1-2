package edu.ucaldas.behavior;

/**
 * Concrete Investor that records the last notification it received.
 */
public class ConcreteInvestor implements Investor {
    private final String name;
    private String lastSymbol;
    private double lastPrice;

    public ConcreteInvestor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double price) {
        this.lastSymbol = stockSymbol;
        this.lastPrice = price;
    }

    public String getName() {
        return name;
    }

    public String getLastSymbol() {
        return lastSymbol;
    }

    public double getLastPrice() {
        return lastPrice;
    }
}
