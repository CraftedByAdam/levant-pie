package com.pluralsight.pantry;


public abstract class Topping{
    //protected?
    private String toppingName;

    public Topping(String toppingName) {
        this.toppingName = toppingName;
    }

    public String getToppingName() {
        return toppingName;
    }

    public abstract double getPrice(String size);
}
