package com.pluralsight.levantpie.order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order{
    private LocalDateTime dateTime;
    private List<IPayable> items;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");



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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\tLevant Pie\n");
        stringBuilder.append(" ____________________\n");
        stringBuilder.append("|      Receipt       |\n");
        stringBuilder.append("|____________________|\n\n");
        stringBuilder.append("Date: ").append(dateTimeFormatter.format(dateTime)).append("\n\n");
        stringBuilder.append("Order Summary:\n");
        stringBuilder.append("==============================\n");

        for (IPayable item : items){
            stringBuilder.append(item.toString()).append("\n");
        }
        stringBuilder.append("==============================\n");
        stringBuilder.append("Total: $").append(String.format("%.2f", calculateTotal()));
        System.out.println(stringBuilder.toString());
    }
}
