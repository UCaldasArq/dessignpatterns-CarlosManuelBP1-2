package edu.ucaldas.structural;

public class BasicBurger implements Product {

    @Override
    public String getDescription() {
        return "Burger";
    }

    @Override
    public double getPrice() {
        return 5.0; // base price
    }
}
