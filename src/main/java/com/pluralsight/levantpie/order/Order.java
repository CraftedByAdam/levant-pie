package com.pluralsight.levantpie.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order{
    private LocalDateTime dateTime;
    private List<IPayable> items;

    public Order(){
        this.dateTime = LocalDateTime.now();
        this.items = new ArrayList<>();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public List<IPayable> getItems() {
        return items;
    }

    public double calculateTotal(){
        double total = 0;
        for (IPayable item : items){
            total += item.getPrice();
        }
        return total;
    }

    public void addItem(IPayable item){
        this.items.add(item);
    }

    public void displayOrder(){
        //Make a string builder
        //test it
        for (IPayable item : items){
            System.out.println(item.toString());
        }
    }
}
