package com.pluralsight.pantry;

public class Sauce extends Topping{

    public Sauce(String toppingName) {
        super(toppingName);
    }

    @Override
    public double getPrice(String size) {
        return 0;
    }
}
