package edu.ucaldas.structural;

public abstract class ProductDecorator implements Product {
    protected final Product wrappee;

    protected ProductDecorator(Product wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public String getDescription() {
        return wrappee.getDescription();
    }

    @Override
    public double getPrice() {
        return wrappee.getPrice();
    }
}
