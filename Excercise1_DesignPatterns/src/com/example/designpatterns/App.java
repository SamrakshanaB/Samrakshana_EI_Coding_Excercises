// File: src/com/example/designpatterns/App.java
package com.example.designpatterns;

import com.example.designpatterns.behavioural.observer.*;
import com.example.designpatterns.behavioural.strategy.*;
import com.example.designpatterns.creational.singleton.*;
import com.example.designpatterns.creational.factory.*;
import com.example.designpatterns.structural.adapter.*;
import com.example.designpatterns.structural.decorator.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Design Patterns Demo ===");
            System.out.println("1. Observer Pattern");
            System.out.println("2. Strategy Pattern");
            System.out.println("3. Singleton Pattern");
            System.out.println("4. Factory Pattern");
            System.out.println("5. Adapter Pattern");
            System.out.println("6. Decorator Pattern");
            System.out.println("0. Exit");
            System.out.print("Choose a pattern to demo: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> runObserverDemo(sc);
                case 2 -> runStrategyDemo(sc);
                case 3 -> runSingletonDemo();
                case 4 -> runFactoryDemo(sc, sc);
                case 5 -> runAdapterDemo(sc);
                case 6 -> runDecoratorDemo(sc);
                case 0 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // ---------------- Observer Pattern ----------------
    private static void runObserverDemo(Scanner sc) {
        System.out.println("\n=== Observer Pattern Demo ===");
        StockMarket stockMarket = new StockMarket();
        System.out.print("Enter first investor name: ");
        Investor i1 = new RetailInvestor(sc.nextLine());
        System.out.print("Enter second investor name: ");
        Investor i2 = new RetailInvestor(sc.nextLine());

        stockMarket.registerObserver(i1);
        stockMarket.registerObserver(i2);

        System.out.print("Enter stock price: ");
        double price = sc.nextDouble();
        stockMarket.setPrice(price);
    }

    // ---------------- Strategy Pattern ----------------
    private static void runStrategyDemo(Scanner sc) {
        System.out.println("\n=== Strategy Pattern Demo ===");
        System.out.println("Choose payment method: 1. UPI 2. PayPal 3. Credit Card");
        int payChoice = sc.nextInt();
        System.out.print("Enter amount to pay: ");
        int amount = sc.nextInt();

        PaymentStrategy strategy = switch (payChoice) {
            case 1 -> new UpiPayment();
            case 2 -> new PayPalPayment();
            case 3 -> new CreditCardPayment();
            default -> {
                System.out.println("Invalid choice. Using UPI by default.");
                yield new UpiPayment();
            }
        };

        PaymentContext context = new PaymentContext(strategy);
        context.executePayment(amount);
    }

    // ---------------- Singleton Pattern ----------------
    private static void runSingletonDemo() {
        System.out.println("\n=== Singleton Pattern Demo ===");
        LoggerSingleton logger = LoggerSingleton.getInstance();
        logger.log("This is a singleton logger message.");
    }

    // ---------------- Factory Pattern ----------------
private static void runFactoryDemo(Scanner sc, Scanner sc2) {
    System.out.println("\n=== Factory Pattern Demo ===");
    System.out.print("Enter shape type (circle/square/rectangle): ");
    String type = sc2.nextLine();
    try {
        Shape shape = ShapeFactory.getShape(type);
        shape.draw();
        System.out.println("Shape structure:");
        shape.printStructure(); // Show the textual shape
    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}

    // ---------------- Adapter Pattern ----------------
private static void runAdapterDemo(Scanner sc) {
    System.out.println("\n=== Adapter Pattern Demo ===");
    System.out.print("Enter media filename (without extension): ");
    String filename = sc.next();
    System.out.print("Enter file type (mp3/mp4/vlc): ");
    String filetype = sc.next();

    MediaPlayer player;
    if(filetype.equalsIgnoreCase("mp3")) {
        player = new MP3Player();
    } else {
        player = new MediaAdapter(); // adapts MP4/VLC
    }
    player.play(filename, filetype);
}


    // ---------------- Decorator Pattern ----------------
    private static void runDecoratorDemo(Scanner sc) {
        System.out.println("\n=== Decorator Pattern Demo ===");
        Coffee coffee = new SimpleCoffee();
        System.out.print("Add Milk? (yes/no): ");
        if (sc.next().equalsIgnoreCase("yes")) {
            coffee = new MilkDecorator(coffee);
        }
        System.out.print("Add Sugar? (yes/no): ");
        if (sc.next().equalsIgnoreCase("yes")) {
            coffee = new SugarDecorator(coffee);
        }
        System.out.println(coffee.getDescription() + " costs $" + coffee.cost());
    }
}
