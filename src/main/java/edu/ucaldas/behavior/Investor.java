package edu.ucaldas.behavior;

/** Observer interface for investors interested in stock price changes */
public interface Investor {
    void update(String stockSymbol, double price);
}
