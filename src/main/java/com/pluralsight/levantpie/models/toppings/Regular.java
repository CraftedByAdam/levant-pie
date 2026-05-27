package com.pluralsight.levantpie.models.toppings;

public class Regular extends Topping{

    public Regular(String toppingName) {
        super(toppingName);
    }

    @Override
    public double getPrice(String size) {
        return 0;
    }
}
