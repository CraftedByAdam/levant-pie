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
            bufferedWriter.write("-------Levant Pie-------");
            bufferedWriter.newLine();

            for (IPayable item : order.getItems() ) {
                bufferedWriter.write(item.toString());
                bufferedWriter.newLine();
            }

            bufferedWriter.write("Total: $" + order.calculateTotal());
            bufferedWriter.newLine();

            bufferedWriter.write("-------------------------------");
            bufferedWriter.newLine();

        }catch (Exception e) {
            System.out.println("Error writing receipt file");
        }
    }
}