package com.pluralsight.levantpie.ui;

import com.pluralsight.levantpie.models.toppings.Regular;
import com.pluralsight.levantpie.models.toppings.Sauce;
import com.pluralsight.levantpie.models.toppings.premium.Cheese;
import com.pluralsight.levantpie.models.toppings.premium.Meat;
import com.pluralsight.levantpie.services.ReceiptFileManager;
import com.pluralsight.levantpie.models.products.Drink;
import com.pluralsight.levantpie.models.products.GarlicKnots;
import com.pluralsight.levantpie.order.Order;
import com.pluralsight.levantpie.models.products.Pizza;

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
            System.out.println(BLUE + "1)New Order🛍️" + RESET);
            System.out.println(RED + "0)Exit👋\n" + RESET);

            System.out.print(WHITE + "Enter your choice: " + RESET);
            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    order = new Order();
                    displayOrderScreen();
                    break;
                case "0":
                    running = false;
                    System.out.println("\nThank's For Visiting!😁");
                    break;
                default:
                    System.out.println("\n❌Invalid choice, try again🔄️\n");
            }
        }
    }

    public void displayOrderScreen(){
        boolean running = true;

        while(running){
            System.out.println(GREEN + "\n1)Add Pizza🍕");
            System.out.println("2)Add Drink🥤");
            System.out.println("3)Add Garlic Knots🧄🍞");
            System.out.println("4)Checkout✅");
            System.out.println("5)Cancel Order❌\n" + RESET);

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

    public void addPizza() {
        String crustChoice = "";
        String sizeChoice = "";
        String stuffedCrustChoice;

        //crust type
        label:
        while (true) {
            System.out.println(GREEN + "\nWhat Kind of crust would you like?");
            System.out.println("1)Thin");
            System.out.println("2)Regular");
            System.out.println("3)Thick");
            System.out.println("4)Cauliflower" + RESET);
            System.out.print(WHITE + "\nEnter your choice: " + RESET);
            crustChoice = scanner.nextLine();

            switch (crustChoice) {
                case "1":
                    crustChoice = "Thin";
                    break label;
                case "2":
                    crustChoice = "Regular";
                    break label;
                case "3":
                    crustChoice = "Thick";
                    break label;
                case "4":
                    crustChoice = "Cauliflower";
                    break label;
                default:
                    System.out.println("\n❌Invalid choice try again🔄️");
                    break;
            }
        }

        //pizza size
        while (true) {
            System.out.println(GREEN + "\nPick the Pizza size📏");
            System.out.println("8");
            System.out.println("12");
            System.out.println("16" + RESET);
            System.out.print(WHITE + "\nEnter your choice: " + RESET);
            sizeChoice = scanner.nextLine();

            if (sizeChoice.equals("8") || sizeChoice.equals("12") || sizeChoice.equals("16")) {
                break;
            } else {
                System.out.println("\n❌Invalid choice try again🔄️");
            }
        }

        //is it stuffed
        boolean isStuffed = false;
        while (true) {
            System.out.println(GREEN + "\nWould you like stuffed crust?");
            System.out.println("1)Yes");
            System.out.println("2)No" + RESET);
            System.out.print(WHITE + "\nEnter your choice: " + RESET);
            stuffedCrustChoice = scanner.nextLine();

            if (stuffedCrustChoice.equals("1")) {
                isStuffed = true;
                break;
            } else if (stuffedCrustChoice.equals("2")) {
                isStuffed = false;
                break;
            } else {
                System.out.println("\n❌Invalid choice try again🔄️");
            }
        }
        Pizza pizza = new Pizza(crustChoice, isStuffed, sizeChoice);
        order.addItem(pizza);

        //meat menu
        boolean isExtra = false;
        boolean meatRunning = true;
        while (meatRunning) {
            System.out.println(GREEN + "\nMeat Toppings🥩");
            System.out.println("Select your Meats (0 when done)");
            System.out.println("1)Pepperoni🐷");
            System.out.println("2)Sausage🌭");
            System.out.println("3)Ham🐷");
            System.out.println("4)Bacon🥓");
            System.out.println("5)Chicken🐔");
            System.out.println("6)Meatball🧆");
            System.out.println("0)Done adding meats" + RESET);
            System.out.print(WHITE + "\nEnter your choice: " + RESET);
            String meatChoice = scanner.nextLine();

            switch (meatChoice) {
                case "1" -> {
                    while (true) {
                        System.out.print(GREEN + "\nExtra Pepperoni? (Y/N): " + RESET);
                        String extraPepperoni = scanner.nextLine();
                        if (extraPepperoni.equalsIgnoreCase("Y")) {
                            isExtra = true;
                            break;
                        } else if (extraPepperoni.equalsIgnoreCase("N")) {
                            isExtra = false;
                            break;
                        } else {
                            System.out.println("\n❌Invalid choice try again🔄️");
                        }
                    }
                    Meat pepperoni = new Meat("Pepperoni", isExtra);
                    pizza.addTopping(pepperoni);
                    System.out.println(PURPLE + "\nPepperoni added!🙌" + RESET);
                }
                case "2" -> {
                    while (true) {
                        System.out.print(GREEN + "\nExtra Sausage? (Y/N): " + RESET);
                        String extraSausage = scanner.nextLine();
                        if (extraSausage.equalsIgnoreCase("Y")) {
                            isExtra = true;
                            break;
                        } else if (extraSausage.equalsIgnoreCase("N")) {
                            isExtra = false;
                            break;
                        } else {
                            System.out.println("\n❌Invalid choice try again🔄️");
                        }
                    }
                    Meat sausage = new Meat("Sausage", isExtra);
                    pizza.addTopping(sausage);
                    System.out.println(PURPLE + "\nSausage added!🙌" + RESET);
                }
                case "3" -> {
                    while (true) {
                        System.out.print(GREEN + "\nExtra Ham? (Y/N): " + RESET);
                        String extraHam = scanner.nextLine();
                        if (extraHam.equalsIgnoreCase("Y")) {
                            isExtra = true;
                            break;
                        } else if (extraHam.equalsIgnoreCase("N")) {
                            isExtra = false;
                            break;
                        } else {
                            System.out.println("\n❌Invalid choice try again🔄️");
                        }
                    }
                    Meat ham = new Meat("Ham", isExtra);
                    pizza.addTopping(ham);
                    System.out.println(PURPLE + "\nHam added!🙌" + RESET);
                }
                case "4" -> {
                    while (true) {
                        System.out.print(GREEN + "\nExtra Bacon? (Y/N): " + RESET);
                        String extraBacon = scanner.nextLine();
                        if (extraBacon.equalsIgnoreCase("Y")) {
                            isExtra = true;
                            break;
                        } else if (extraBacon.equalsIgnoreCase("N")) {
                            isExtra = false;
                            break;
                        } else {
                            System.out.println("\n❌Invalid choice try again🔄️");
                        }
                    }
                    Meat bacon = new Meat("Bacon", isExtra);
                    pizza.addTopping(bacon);
                    System.out.println(PURPLE + "\nBacon added!🙌" + RESET);
                }
                case "5" -> {
                    while (true) {
                        System.out.print(GREEN + "\nExtra Chicken? (Y/N): " + RESET);
                        String extraChicken = scanner.nextLine();
                        if (extraChicken.equalsIgnoreCase("Y")) {
                            isExtra = true;
                            break;
                        } else if (extraChicken.equalsIgnoreCase("N")) {
                            isExtra = false;
                            break;
                        } else {
                            System.out.println("\n❌Invalid choice try again🔄️");
                        }
                    }
                    Meat chicken = new Meat("Chicken", isExtra);
                    pizza.addTopping(chicken);
                    System.out.println(PURPLE + "\nChicken added!🙌" + RESET);
                }
                case "6" -> {
                    while (true) {
                        System.out.print(GREEN + "\nExtra Meatball? (Y/N): " + RESET);
                        String extraMeatball = scanner.nextLine();
                        if (extraMeatball.equalsIgnoreCase("Y")) {
                            isExtra = true;
                            break;
                        } else if (extraMeatball.equalsIgnoreCase("N")) {
                            isExtra = false;
                            break;
                        } else {
                            System.out.println("\n❌Invalid choice try again🔄️");
                        }
                    }
                    Meat meatball = new Meat("Meatball", isExtra);
                    pizza.addTopping(meatball);
                    System.out.println(PURPLE + "\nMeatball added!🙌" + RESET);
                }
                case "0" -> meatRunning = false;

                default -> System.out.println("\n❌Invalid choice try again🔄️");
            }
        }
        //cheese menu
        boolean cheeseRunning = true;
        while (cheeseRunning) {
            System.out.println(GREEN + "\nCheese Toppings🧀");
            System.out.println("Select your Cheese (0 when done)");
            System.out.println("1)Mozzarella🧀");
            System.out.println("2)Parmesan🧀");
            System.out.println("3)Ricotta🧀");
            System.out.println("4)Goat Cheese🐐🧀");
            System.out.println("5)Buffalo🦬🧀");
            System.out.println("0)Done adding cheese" + RESET);
            System.out.print(WHITE + "\nEnter your choice: " + RESET);
            String cheeseChoice = scanner.nextLine();

            switch (cheeseChoice) {
                case "1" -> {
                    while (true) {
                        System.out.print(GREEN + "\nExtra Mozzarella? (Y/N): " + RESET);
                        String extraMozzarella = scanner.nextLine();
                        if (extraMozzarella.equalsIgnoreCase("Y")) {
                            isExtra = true;
                            break;
                        } else if (extraMozzarella.equalsIgnoreCase("N")) {
                            isExtra = false;
                            break;
                        } else {
                            System.out.println("\n❌Invalid choice try again🔄️");
                        }
                    }
                    Cheese mozzarella = new Cheese("Mozzarella", isExtra);
                    pizza.addTopping(mozzarella);
                    System.out.println(PURPLE + "\nMozzarella added!🙌" + RESET);
                }
                case "2" -> {
                    while (true) {
                        System.out.print(GREEN + "\nExtra Parmesan? (Y/N): " + RESET);
                        String extraParmesan = scanner.nextLine();
                        if (extraParmesan.equalsIgnoreCase("Y")) {
                            isExtra = true;
                            break;
                        } else if (extraParmesan.equalsIgnoreCase("N")) {
                            isExtra = false;
                            break;
                        } else {
                            System.out.println("\n❌Invalid choice try again🔄️");
                        }
                    }
                    Cheese parmesan = new Cheese("Parmesan", isExtra);
                    pizza.addTopping(parmesan);
                    System.out.println(PURPLE + "\nParmesan added!🙌" + RESET);
                }
                case "3" -> {
                    while (true) {
                        System.out.print(GREEN + "\nExtra Ricotta? (Y/N): " + RESET);
                        String extraRicotta = scanner.nextLine();
                        if (extraRicotta.equalsIgnoreCase("Y")) {
                            isExtra = true;
                            break;
                        } else if (extraRicotta.equalsIgnoreCase("N")) {
                            isExtra = false;
                            break;
                        } else {
                            System.out.println("\n❌Invalid choice try again🔄️");
                        }
                    }
                    Cheese ricotta = new Cheese("Ricotta", isExtra);
                    pizza.addTopping(ricotta);
                    System.out.println(PURPLE + "\nRicotta added!🙌" + RESET);
                }
                case "4" -> {
                    while (true) {
                        System.out.print(GREEN + "\nExtra Goat Cheese? (Y/N): " + RESET);
                        String extraGoatCheese = scanner.nextLine();
                        if (extraGoatCheese.equalsIgnoreCase("Y")) {
                            isExtra = true;
                            break;
                        } else if (extraGoatCheese.equalsIgnoreCase("N")) {
                            isExtra = false;
                            break;
                        } else {
                            System.out.println("\n❌Invalid choice try again🔄️");
                        }
                    }
                    Cheese goatCheese = new Cheese("Goat Cheese", isExtra);
                    pizza.addTopping(goatCheese);
                    System.out.println(PURPLE + "\nGoat Cheese added!🙌" + RESET);
                }
                case "5" -> {
                    while (true) {
                        System.out.print(GREEN + "\nExtra Buffalo? (Y/N): " + RESET);
                        String extraBuffalo = scanner.nextLine();
                        if (extraBuffalo.equalsIgnoreCase("Y")) {
                            isExtra = true;
                            break;
                        } else if (extraBuffalo.equalsIgnoreCase("N")) {
                            isExtra = false;
                            break;
                        } else {
                            System.out.println("\n❌Invalid choice try again🔄️");
                        }
                    }
                    Cheese buffalo = new Cheese("Buffalo", isExtra);
                    pizza.addTopping(buffalo);
                    System.out.println(PURPLE + "\nBuffalo added!🙌" + RESET);
                }
                case "0" -> {
                    cheeseRunning = false;
                }
                default -> System.out.println("\n❌Invalid choice try again🔄️");
            }
        }

        //regular menu
        boolean regularToppingRunning = true;
        while (regularToppingRunning) {
            System.out.println(GREEN + "\nSelect Toppings");
            System.out.println("1)Onions🧅");
            System.out.println("2)Mushrooms🍄‍🟫");
            System.out.println("3)Bell Peppers🫑");
            System.out.println("4)Olives🫒");
            System.out.println("5)Tomatoes🍅");
            System.out.println("6)Spinach🌿");
            System.out.println("7)Basil🌿");
            System.out.println("8)Pineapple🍍");
            System.out.println("9)Anchovies🐟");
            System.out.println("0)Done adding Toppings" + RESET);
            System.out.print(WHITE + "\nEnter your choice: " + RESET);
            String regularToppingChoice = scanner.nextLine();

            switch (regularToppingChoice) {
                case "1" -> {
                    pizza.addTopping(new Regular("Onions"));
                    System.out.println(PURPLE + "\nOnions added!🙌" + RESET);
                }

                case "2" -> {
                    pizza.addTopping(new Regular("Mushrooms"));
                    System.out.println(PURPLE + "\nMushrooms added!🙌" + RESET);
                }

                case "3" -> {
                    pizza.addTopping(new Regular("Bell Peppers"));
                    System.out.println(PURPLE + "\nBell Peppers added!🙌" + RESET);
                }

                case "4" -> {
                    pizza.addTopping(new Regular("Olives"));
                    System.out.println(PURPLE + "\nOlives added!🙌" + RESET);
                }

                case "5" -> {
                    pizza.addTopping(new Regular("Tomatoes"));
                    System.out.println(PURPLE + "\nTomatoes added!🙌" + RESET);
                }

                case "6" -> {
                    pizza.addTopping(new Regular("Spinach"));
                    System.out.println(PURPLE + "\nSpinach added!🙌" + RESET);
                }

                case "7" -> {
                    pizza.addTopping(new Regular("Basil"));
                    System.out.println(PURPLE + "\nBasil added!🙌" + RESET);
                }

                case "8" -> {
                    pizza.addTopping(new Regular("Pineapple"));
                    System.out.println(PURPLE + "\nPineapple added!🙌" + RESET);
                }

                case "9" -> {
                    pizza.addTopping(new Regular("Anchovies"));
                    System.out.println(PURPLE + "\nAnchovies added!🙌" + RESET);
                }

                case "0" ->regularToppingRunning  = false;

                default -> System.out.println("\n❌Invalid choice try again🔄️");
            }
        }

        //sauce menu
        boolean sauceRunning = true;
        while (sauceRunning) {
            System.out.println(GREEN + "\nSelect Sauce");
            System.out.println("1)marinara🍅");
            System.out.println("2)Alfredo🧀");
            System.out.println("3)Pesto🌿");
            System.out.println("4)BBQ");
            System.out.println("5)Olive Oil🫒");
            System.out.println("0)Done adding sauce" + RESET);
            System.out.print(WHITE + "\nEnter your choice: " + RESET);
            String sauceChoice = scanner.nextLine();

            switch (sauceChoice) {
                case "1" -> {
                    pizza.addTopping(new Sauce("Marinara"));
                    System.out.println(PURPLE + "\nMarinara added!🙌" + RESET);
                }

                case "2" -> {
                    pizza.addTopping(new Sauce("Alfredo"));
                    System.out.println(PURPLE + "\nAlfredo added!🙌" + RESET);
                }

                case "3" -> {
                    pizza.addTopping(new Sauce("Pesto"));
                    System.out.println(PURPLE + "\nPesto added!🙌" + RESET);
                }

                case "4" -> {
                    pizza.addTopping(new Sauce("BBQ"));
                    System.out.println(PURPLE + "\nBBQ added!🙌" + RESET);
                }

                case "5" -> {
                    pizza.addTopping(new Sauce("Olive Oil"));
                    System.out.println(PURPLE + "\nOlive Oil added!🙌" + RESET);
                }

                case "0" -> sauceRunning = false;

                default -> System.out.println("\n❌Invalid choice try again🔄️");
            }
        }

    }

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