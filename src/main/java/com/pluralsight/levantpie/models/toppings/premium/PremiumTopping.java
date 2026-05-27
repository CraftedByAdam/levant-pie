package com.pluralsight.levantpie.models.toppings.premium;

import com.pluralsight.levantpie.models.toppings.Topping;

public abstract class PremiumTopping extends Topping {

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
