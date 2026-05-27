package com.pluralsight.levantpie;


import com.pluralsight.levantpie.models.products.Drink;
import com.pluralsight.levantpie.models.products.Pizza;
import com.pluralsight.levantpie.models.toppings.premium.Meat;
import com.pluralsight.levantpie.order.Order;
import com.pluralsight.levantpie.services.ReceiptFileManager;
import com.pluralsight.levantpie.ui.UserInterface;

public class LevantPie {
    public static void main(String[] args) {

        /*UserInterface userInterface = new UserInterface();
        userInterface.displayHomeScreen();*/

        //Order Class
       /* Drink drink1 = new Drink("Pepsi", "Medium");
        Drink drink2 = new Drink("Sprite", "Medium");
        Order order1 = new Order();
        order1.addItem(drink1);
        order1.addItem(drink2);
        order1.displayOrder();*/

        //ReceiptFileManager Class
       /* ReceiptFileManager receiptFileManager = new ReceiptFileManager();
        Drink drink3 = new Drink("Sprite", "Medium");
        Order order2 = new Order();
        order2.addItem(drink3);
        receiptFileManager.writeReceipt(order2);*/

        //Pizza Class
        Pizza pizza = new Pizza("Thin", true, "8");
        pizza.addTopping(new Meat("Chicken", false));
        Drink drink1 = new Drink("Pepsi", "Medium");
        Order order = new Order();
        order.addItem(pizza);
        order.addItem(drink1);
        order.displayOrder();
    }
}
