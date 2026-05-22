package com.pluralsight.pantry;

public abstract class PremiumTopping extends Topping{

    private boolean isExtra;

    public PremiumTopping(String toppingName,boolean isExtra) {
        super(toppingName);
        this.isExtra = isExtra;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public abstract double getPrice(String size);
}
