package com.pluralsight.levantpie.models.toppings;

public class Side extends Topping{
    public Side(String toppingName) {
        super(toppingName);
    }

    @Override
    public double getPrice(String size) {
        return 0;
    }
}
