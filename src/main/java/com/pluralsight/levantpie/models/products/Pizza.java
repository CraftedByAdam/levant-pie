package com.pluralsight.levantpie.models.products;

import com.pluralsight.levantpie.order.IPayable;
import com.pluralsight.levantpie.models.toppings.Topping;

import java.util.ArrayList;
import java.util.List;

public class Pizza implements IPayable {
    private String crustType;
    private boolean isStuffed;
    private String size;
    List<Topping>toppings;

    public Pizza(String crustType, boolean isStuffed, String size) {
        this.crustType = crustType;
        this.isStuffed = isStuffed;
        this.size = size;
        this.toppings = new ArrayList<>();
    }

    public String getCrustType() {
        return crustType;
    }

    public boolean isStuffed() {
        return isStuffed;
    }

    public String getSize() {
        return size;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    @Override
    public double getPrice() {
        double totalPrice = 0;
        if (size.equals("8")) {
            totalPrice = 8.50;
        } else if (size.equals("12")) {
            totalPrice = 12.00;
        } else if (size.equals("16")) {
            totalPrice = 16.50;
        }
        if (isStuffed) {
            //this is free not extra price
            //totalPrice += 3.20;
        }
        for (Topping topping : toppings) {
            totalPrice += topping.getPrice(size) ;
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Pizza: " + "crustType: " + crustType + ", isStuffed: " + isStuffed + ", size: " + size + ", toppings: " + toppings + "Price: $" + getPrice();
    }
}
