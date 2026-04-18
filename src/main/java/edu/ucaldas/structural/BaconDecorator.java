package edu.ucaldas.structural;

public class BaconDecorator extends ProductDecorator {

    public BaconDecorator(Product wrappee) {
        super(wrappee);
    }

    @Override
    public String getDescription() {
        return wrappee.getDescription() + ", Bacon";
    }

    @Override
    public double getPrice() {
        return wrappee.getPrice() + 1.5; // bacon price
    }
}
