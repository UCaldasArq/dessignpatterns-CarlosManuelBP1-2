package edu.ucaldas.behavior;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/** Subject: Stock that notifies registered investors when price changes */
public class Stock {
    private final String symbol;
    private double price;
    private final List<Investor> investors = new CopyOnWriteArrayList<>();

    public Stock(String symbol, double initialPrice) {
        this.symbol = symbol;
        this.price = initialPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public void addInvestor(Investor investor) {
        if (investor != null) investors.add(investor);
    }

    public void removeInvestor(Investor investor) {
        investors.remove(investor);
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
        notifyInvestors();
    }

    private void notifyInvestors() {
        for (Investor inv : investors) {
            try {
                inv.update(symbol, price);
            } catch (Exception e) {
                // swallow to ensure all investors are attempted
            }
        }
    }
}
