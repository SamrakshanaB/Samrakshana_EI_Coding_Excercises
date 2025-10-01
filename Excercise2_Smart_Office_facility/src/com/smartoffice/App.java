package com.smartoffice;

import com.smartoffice.singleton.*;
import com.smartoffice.observer.*;
import com.smartoffice.command.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        CommandInvoker invoker = new CommandInvoker();
        OfficeConfig config = OfficeConfig.getInstance();

        System.out.println("=== Smart Office Facility ===");

        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Configure number of rooms");
            System.out.println("2. Set maximum capacity for a room");
            System.out.println("3. Add occupants to a room");
            System.out.println("4. Block a room (book)");
            System.out.println("5. Cancel a booking");
            System.out.println("6. Show all room status");
            System.out.println("7. Exit");
            System.out.print("Enter choice (1-7): ");

            String choice = sc.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter number of rooms to configure: ");
                        int count = Integer.parseInt(sc.nextLine());
                        config.configureRooms(count);
                        for (Room room : config.getAllRooms()) {
                            room.addObserver(new Light());
                            room.addObserver(new AirConditioner());
                        }
                        break;

                    case "2":
                        System.out.print("Enter Room ID to set capacity: ");
                        int roomId = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter maximum capacity: ");
                        int cap = Integer.parseInt(sc.nextLine());
                        Room room = config.getRoom(roomId);
                        if (room != null) room.setCapacity(cap);
                        else System.out.println("Invalid room number.");
                        break;

                    case "3":
                        System.out.print("Enter Room ID to add occupants: ");
                        int rId = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter number of occupants: ");
                        int occ = Integer.parseInt(sc.nextLine());
                        invoker.execute(new AddOccupantCommand(rId, occ));
                        break;

                    case "4":
                        System.out.print("Enter Room ID to book: ");
                        int bId = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter start time (HH:mm): ");
                        String time = sc.nextLine();
                        System.out.print("Enter duration in minutes: ");
                        int dur = Integer.parseInt(sc.nextLine());
                        invoker.execute(new BookRoomCommand(bId, time, dur));
                        break;

                    case "5":
                        System.out.print("Enter Room ID to cancel booking: ");
                        int cId = Integer.parseInt(sc.nextLine());
                        invoker.execute(new CancelRoomCommand(cId));
                        break;

                    case "6":
                        config.printAllRooms();
                        break;

                    case "7":
                        System.out.println("Exiting Smart Office. Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
