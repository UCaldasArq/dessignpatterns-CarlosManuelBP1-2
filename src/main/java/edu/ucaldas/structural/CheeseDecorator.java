package edu.ucaldas.structural;

public class CheeseDecorator extends ProductDecorator {

    public CheeseDecorator(Product wrappee) {
        super(wrappee);
    }

    @Override
    public String getDescription() {
        return wrappee.getDescription() + ", Cheese";
    }

    @Override
    public double getPrice() {
        return wrappee.getPrice() + 1.0; // cheese price
    }
}
