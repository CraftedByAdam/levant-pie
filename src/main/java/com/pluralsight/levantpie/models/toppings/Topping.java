package com.pluralsight.levantpie.models.toppings;

public abstract class Topping{

    private String toppingName;

    public Topping(String toppingName) {
        this.toppingName = toppingName;
    }

    public String getToppingName() {
        return toppingName;
    }

    public abstract double getPrice(String size);
}
