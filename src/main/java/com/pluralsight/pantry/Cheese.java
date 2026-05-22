package com.pluralsight.pantry;

public class Cheese extends PremiumTopping{

    public Cheese(String toppingName, boolean isExtra) {
        super(toppingName, isExtra);
    }

    //Make better Adam!
    @Override
    public double getPrice(String size) {
        double price = 0;
        if (size.equals("8")) {
            price = 0.75;
        }else if (size.equals("12")) {
            price = 1.50;
        }else if (size.equals("16")) {
            price = 2.25;
        }
        //Extra
        if (isExtra() && size.equals("8")) {
            price = 0.75 + 0.30;
        }else if (isExtra() && size.equals("12")) {
            price = 1.50 + 0.60;
        }else if (isExtra() && size.equals("16")) {
            price = 2.25 + 0.90;
        }
        return price;
    }
}
