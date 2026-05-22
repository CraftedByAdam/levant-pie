package com.pluralsight.pantry;

public class Meat extends PremiumTopping{

    public Meat(String toppingName, boolean isExtra) {
        super(toppingName, isExtra);
    }

    //Make better
    @Override
    public double getPrice(String size) {
        double price = 0;
        if (size.equals("8")) {
            price = 1.00;
        }else if (size.equals("12")) {
            price = 2.00;
        }else if (size.equals("16")) {
            price = 3.00;
        }
        //Extra
        if (isExtra() && size.equals("8")) {
            price = 1.00 + 0.50;
        }else if (isExtra() && size.equals("12")) {
            price = 2.00 + 1.00;
        }else if (isExtra() && size.equals("16")) {
            price = 3.00 + 1.50;
        }
        return price;
    }
}
