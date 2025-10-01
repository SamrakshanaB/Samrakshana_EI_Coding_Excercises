package com.smartoffice.singleton;

import java.util.*;

public class OfficeConfig {
    private static OfficeConfig instance;
    private Map<Integer, Room> rooms = new HashMap<>();

    private OfficeConfig() {}

    public static OfficeConfig getInstance() {
        if (instance == null) {
            instance = new OfficeConfig();
        }
        return instance;
    }

    public void configureRooms(int count) {
        rooms.clear();
        for (int i = 1; i <= count; i++) {
            rooms.put(i, new Room(i));
        }
        System.out.println("Office configured with " + count + " meeting rooms:");
        rooms.keySet().forEach(r -> System.out.println("Room " + r));
    }

    public Room getRoom(int id) { return rooms.get(id); }
    public boolean roomExists(int id) { return rooms.containsKey(id); }
    public Collection<Room> getAllRooms() { return rooms.values(); }

    public void printAllRooms() {
        System.out.println("\n=== Current Room Status ===");
        for (Room r : rooms.values()) {
            r.printStatus();
        }
    }
}
