package com.pluralsight.levantpie.models.products;

import com.pluralsight.levantpie.order.IPayable;

public class GarlicKnots implements IPayable {
    private String flavor;

    public GarlicKnots(String flavor) {
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String toString() {
        return "Garlic Knots "  + getFlavor() + String.format(" $%.2f", getPrice());
    }
}
