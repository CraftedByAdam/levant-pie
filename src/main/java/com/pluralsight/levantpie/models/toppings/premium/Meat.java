package com.pluralsight.levantpie.models.toppings.premium;

public class Meat extends PremiumTopping {

    public Meat(String toppingName, boolean isExtra) {
        super(toppingName, isExtra);
    }

    @Override
    public double getPrice(String size) {
        double price = 0;
        if (size.equals("8")) {
            price = 1.00;
            if (isExtra()) {
                price += 0.50;
            }
        }else if (size.equals("12")) {
            price = 2.00;
            if (isExtra()) {
                price += 1.00;
            }
        }else if (size.equals("16")) {
            price = 3.00;
            if (isExtra()) {
                price += 1.50;
            }
        }
        return price;
    }
}
