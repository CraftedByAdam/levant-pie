package com.pluralsight.levantpie.models.toppings.premium;

public class Cheese extends PremiumTopping {

    public Cheese(String toppingName, boolean isExtra) {
        super(toppingName, isExtra);
    }

    @Override
    public double getPrice(String size) {
        double price = 0;
        if (size.equals("8")) {
            price = 0.75;
            if (isExtra()) {
                price += 0.30;
            }
        }else if (size.equals("12")) {
            price = 1.50;
            if (isExtra()) {
                price += 0.60;
            }
        }else if (size.equals("16")) {
            price = 2.25;
            if (isExtra()) {
                price += 0.90;
            }
        }
        return price;
    }
}