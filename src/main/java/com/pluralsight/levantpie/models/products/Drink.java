package com.pluralsight.levantpie.models.products;

import com.pluralsight.levantpie.order.IPayable;

public class Drink implements IPayable {

    private String flavor;
    private String size;

    public Drink(String flavor, String size) {
        this.flavor = flavor;
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getSize() {
        return size;
    }

    @Override
    public double getPrice() {
        double price = 0;
        if (size.equalsIgnoreCase("Small")) {
            price = 2.00;
        }else if (size.equalsIgnoreCase("Medium")) {
            price = 2.50;
        }else if (size.equalsIgnoreCase("Large")) {
            price = 3.00;
        }
        return price;
    }

    @Override
    public String toString() {
        return getSize() + " " + getFlavor() + " -" + String.format("$%.2f", getPrice());
    }
}