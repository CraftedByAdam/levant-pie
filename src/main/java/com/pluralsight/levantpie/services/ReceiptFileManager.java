package com.pluralsight.levantpie.services;

import com.pluralsight.levantpie.order.IPayable;
import com.pluralsight.levantpie.order.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {

    public void writeReceipt(Order order){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");

       String formattedDateTime;
       formattedDateTime = dateTimeFormatter.format(order.getDateTime());

        String fileName = "receipts/" + formattedDateTime + ".txt";

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, false))) {

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\tLevant Pie\n");
            stringBuilder.append(" ____________________\n");
            stringBuilder.append("|      Receipt       |\n");
            stringBuilder.append("|____________________|\n\n");
            stringBuilder.append("Date: ").append(dateTimeFormatter.format(order.getDateTime())).append("\n\n");
            stringBuilder.append("Order Summary:\n");
            stringBuilder.append("==============================\n");

            for (IPayable item : order.getItems()){
                stringBuilder.append(item.toString()).append("\n");
            }
            stringBuilder.append("==============================\n");
            stringBuilder.append("Total: $").append(String.format("%.2f", order.calculateTotal()));
            bufferedWriter.write(stringBuilder.toString());

        }catch (Exception e) {
            System.out.println("Error writing receipt file");
        }
    }
}