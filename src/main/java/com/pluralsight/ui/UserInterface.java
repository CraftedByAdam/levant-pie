package com.pluralsight.ui;

import com.pluralsight.data.ReceiptFileManager;
import com.pluralsight.kitchen.Drink;
import com.pluralsight.kitchen.GarlicKnots;
import com.pluralsight.kitchen.Order;
import com.pluralsight.kitchen.Pizza;

import java.util.Scanner;

public class UserInterface {
    //ANSI colors
    private static final String RESET = "\u001B[0m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String WHITE = "\u001B[37m";

    private Scanner scanner;
    private Order order;
    private ReceiptFileManager receiptFileManager;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.receiptFileManager = new ReceiptFileManager();
    }

    public void displayHomeScreen(){
        storeLogo();
        pizzaMan();

        boolean running = true;
        while(running){
            System.out.println(BLUE + "1) New Order🛍️" + RESET);
            System.out.println(RED + "0) Exit👋\n" + RESET);

            System.out.print(WHITE + "Enter your choice: " + RESET);
            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    order = new Order();
                    displayOrderScreen();
                    break;
                case "0":
                    running = false;
                    System.out.println("\nThanks For Visiting!😁");
                    break;
                default:
                    System.out.println("\n❌Invalid choice try again🔄️\n");
            }
        }
    }

    public void displayOrderScreen(){
        boolean running = true;

        while(running){
            System.out.println("\n1) Add Pizza🍕");
            System.out.println("2) Add Drink🥤");
            System.out.println("3) Add Garlic Knots🧄🍞");
            System.out.println("4) Checkout✅");
            System.out.println("5) Cancel Order❌\n");

            System.out.print(WHITE + "Enter your choice: " + RESET);
            String choice = scanner.nextLine();

            switch(choice){
                case "1":
                    addPizza();
                    break;
                case "2":
                    addDrink();
                    break;
                case "3":
                    addGarlicKnots();
                    break;
                case "4":
                    checkout();
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    System.out.println("\n❌Invalid choice try again🔄️");
            }
        }
    }

    public void addPizza(){}

    public void addDrink(){}

    public void addGarlicKnots(){}

    public void checkout(){}

    public void displayPizza(Pizza pizza) {}

    public void displayDrink(Drink drink) {}

    public void displayGarlicKnots(GarlicKnots garlicKnots) {}

    private void pizzaMan() {
        System.out.println(GREEN + " " +
                 " ____                   \n" +
                 "/    \\\t\t\t\n" +
                "  u  u|      _______    \n" +
                "    \\|  .-''Welcome``-.   \n" +
                "   = /  (( To my Shop ))  \n" +
                "    |    `-._ ENJOY! _.-'   \n" +
                " /\\/\\`--. `-.\"\".-'\n" +
                " |  |    \\   /`./          \n" +
                " |\\/|  \\  `-'  /\n" +
                " || |   \\     / " + RESET);
    }

    private void storeLogo() {
        System.out.println(RED + "                                                         \n" +
                "                                                         \n" +
                "██     ▄▄▄▄▄ ▄▄ ▄▄  ▄▄▄  ▄▄  ▄▄ ▄▄▄▄▄▄   █████▄ ▄▄ ▄▄▄▄▄ \n" +
                "██     ██▄▄  ██▄██ ██▀██ ███▄██   ██     ██▄▄█▀ ██ ██▄▄  \n" +
                "██████ ██▄▄▄  ▀█▀  ██▀██ ██ ▀██   ██     ██     ██ ██▄▄▄ \n" +
                "                                                         "+ RESET +
                YELLOW + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                  ⠀⠀⠀⠀⠀⠀⠀⠀          \n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⠤⠴⠖⡚⢉⠍⡉⢡⠂⠔⡉⡙⠶⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠴⠒⡍⠩⢐⠨⢐⠂⡡⠌⡐⠌⠤⠘⡠⠑⡐⢂⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠴⠚⢩⠠⠘⡐⠠⠃⡌⠄⡃⢌⠐⣤⣡⢮⣖⣻⣵⠿⠽⠛⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡶⠏⡀⠸⠈⡀⢆⠱⠈⢁⠶⢀⢱⢰⡾⢿⣶⣹⡾⠏⠉⠀⠀⠀⠀⠈⢇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⢀⡤⠞⡉⠰⠠⠡⢑⠨⠐⡂⢌⡘⢠⢦⡗⢯⣳⡿⠛⠋⠁⢀⣤⣶⢿⣻⣿⣶⣤⡈⢧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⣀⠴⢋⠐⠤⢁⠡⠡⠑⢂⠡⡑⣨⢴⡺⣏⡷⡞⠋⠁⠀⠀⠀⢤⣿⢯⣟⣯⠿⣽⣞⡯⣿⣎⢧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⢀⣼⠏⡐⠌⡨⠐⠌⢂⠥⠉⣄⡧⣞⢧⡯⠗⠉⠁⠀⢠⠖⢦⠀⠘⣿⣯⣟⣾⣟⡿⣷⣫⡿⣵⣿⠠⠱⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⣰⢿⣽⠤⠼⣤⡁⠎⡘⢠⡦⡟⣧⣽⠞⠫⠂⠀⡀⠒⠀⠈⠑⢅⢀⠘⡸⣷⣭⢾⣽⣻⣞⣏⣟⡷⢃⠂⠀⠈⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⣼⡿⠋⡇⠀⠀⠀⠙⣧⡞⡯⢵⣻⠞⠁⠊⠀⢀⣤⣶⡾⣟⣿⢷⣶⣤⣀⠈⠢⠙⡛⠾⠷⠿⠚⡋⠁⠊⠀⣀⣀⣈⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠻⢤⡡⢨⡀⠀⠀⠀⠸⣯⣝⡿⠁⠀⡊⠀⣴⡿⣯⢷⣻⡽⣳⣟⡾⣽⣻⣶⠀⠀⠀⢁⠀⠀⠁⠀⣀⣶⣿⣿⣻⢯⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠙⠳⣔⡀⠀⠀⠀⣷⠏⠀⣠⡘⠀⣾⡿⣽⡽⣛⣳⣟⣷⣻⣽⢳⣟⡾⡇⠀⠐⠏⠇⠀⡠⣵⣿⣳⠿⣼⣳⡟⣾⢿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠙⠶⣀⢀⡇⠀⠀⠓⠃⠀⣿⡽⣯⡽⣿⡽⣞⣯⢷⢾⣟⡾⣽⡇⠀⠀⠀⠀⠀⡆⣿⣍⣿⣻⢧⡾⣽⡿⣞⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠈⠙⡏⠃⠦⣀⡀⠄⠘⢿⣧⣼⢷⣻⣟⣾⢻⣉⣹⣷⠟⠀⢀⠴⡄⠀⠀⢁⣿⡽⡞⣷⢿⣛⣷⣻⢽⡾⢷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⢸⠆⡴⢦⣑⠉⠓⢦⡀⠙⠛⠿⢧⣿⡾⠯⠟⠋⠁⠀⠀⠈⠗⠁⠠⢄⠀⠪⠻⣷⣯⣟⡽⣶⢯⡿⣤⣼⢧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⢸⢸⡀⠀⠈⠓⡎⡀⠙⠒⢄⡠⠐⠀⠀⠀⠀⠀⠀⠀⢁⣨⣤⣶⡶⣶⢦⣤⣀⠑⠈⠹⠛⠛⠛⠉⠩⠄⠈⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠸⣆⡇⠀⠀⠀⣧⠟⡇⠇⡠⢬⠙⠒⠤⣀⠀⠀⢁⣴⡿⣯⡷⣯⣽⢿⣯⣻⣽⢿⣦⠀⠀⠀⢰⡲⠀⠀⠀⠈⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⡇⣸⡄⢀⣄⡀⠀⠐⢿⣯⣽⣳⠿⣧⣟⣻⣶⣻⣞⠿⣞⣧⠀⠀⠀⠀⠀⠘⠓⠀⢈⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡋⢀⡇⠙⠤⠜⠀⠈⢳⠀⣀⠈⠳⢯⣟⣷⣻⢷⣫⣶⣯⢿⡽⣾⠆⠀⠀⠀⡐⡁⢁⣴⡿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡜⡁⢸⠇⠀⠀⠀⠀⠀⡞⢸⠁⠉⠲⢄⡈⠳⢯⣟⡏⢱⣟⡾⣽⡿⡀⢀⢤⡰⠀⢰⣿⢯⣟⣳⠿⣆⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠇⢸⠀⠀⠀⠀⠀⣸⢁⡼⠀⠀⠀⠀⠙⣦⣠⡎⠻⢿⣽⣽⠞⠑⠁⠀⠉⢀⡆⢺⡿⣾⡝⣯⣟⡿⣆⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⠴⠃⠀⠀⠀⠀⠀⠹⡴⠇⠀⠀⠀⠀⠀⠻⠏⡇⡖⠦⣌⡁⡁⣀⠀⠀⠀⠀⠀⠹⢟⣷⣹⢯⣟⣽⢿⡄⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⢧⠃⠀⠈⢙⡆⢎⣁⡂⠀⡀⠀⠀⠈⢛⠯⣿⣮⣟⣽⣷⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣾⠀⠀⠀⠸⣄⡼⠁⠙⢶⠈⠳⠄⢀⡀⠀⠐⣠⠭⡉⠂⢳⡀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡎⢰⠑⠲⢄⡙⠂⠀⠑⠚⠁⠀⠀⠹⡄⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⠀⢸⠀⠀⠀⠙⢶⡀⠀⠢⣄⡀⠀⠀⠑⣄⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠃⣸⠀⠀⠀⠀⠀⠙⡎⢐⡀⢝⠢⡀⠀⢸⡀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⠏⠁⠀⠀⠀⠀⠀⠀⣷⡏⠹⢆⡀⠉⠷⠆⣷\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠙⢦⡀⡤⠏\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⡁⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⡇⡇⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠁⠀\n" + RESET);
    }
}
