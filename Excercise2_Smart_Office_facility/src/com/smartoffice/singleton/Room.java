package com.smartoffice.singleton;

import com.smartoffice.observer.Observer;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

public class Room {
    private int id;
    private int capacity;
    private boolean occupied;
    private int occupants;
    private List<Observer> observers = new ArrayList<>();
    private Timer timer;

    // List of bookings for this room
    private List<Booking> bookings = new ArrayList<>();

    public Room(int id) {
        this.id = id;
        this.occupied = false;
        this.occupants = 0;
    }

    public int getId() { return id; }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            System.out.println("Invalid capacity. Please enter a valid positive number.");
        } else {
            this.capacity = capacity;
            System.out.println("Room " + id + " maximum capacity set to " + capacity + ".");
        }
    }

    public int getCapacity() { return capacity; }

    public void addObserver(Observer obs) { observers.add(obs); }

    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(occupied);
        }
    }

    public void setOccupied(int occupants) {
        if (occupants > capacity) {
            System.out.println("Cannot add " + occupants + " occupants. Max capacity is " + capacity + ".");
            return;
        }

        this.occupants = occupants;

        if (occupants >= 2) {
            this.occupied = true;
            cancelAutoRelease();
        } else {
            this.occupied = false;
            scheduleAutoRelease();
        }
        notifyObservers();

        if (occupied)
            System.out.println("Lights turned on.\nAC turned on.");
        else
            System.out.println("Lights turned off.\nAC turned off.");
    }

    public boolean isOccupied() { return occupied; }
    public int getOccupants() { return occupants; }

    // Booking class with encapsulation
    public static class Booking {
        private String startTime; // HH:mm
        private int duration;     // in minutes

        public Booking(String startTime, int duration) {
            this.startTime = startTime;
            this.duration = duration;
        }

        public String getStartTime() { return startTime; }
        public int getDuration() { return duration; }
    }

    // Add a new booking if no overlap
    public boolean isOverlapping(String newStart, int newDuration) {
        int newStartMin = convertToMinutes(newStart);
        int newEndMin = newStartMin + newDuration;

        for (Booking b : bookings) {
            int existingStart = convertToMinutes(b.getStartTime());
            int existingEnd = existingStart + b.getDuration();
            if (newStartMin < existingEnd && existingStart < newEndMin) {
                return true;
            }
        }
        return false;
    }

    public void addBooking(String startTime, int duration) {
        bookings.add(new Booking(startTime, duration));
    }

    public List<Booking> getBookings() { return bookings; }

    private int convertToMinutes(String time) {
        time = time.toLowerCase();
        boolean pm = time.contains("pm");
        boolean am = time.contains("am");
        time = time.replace("am", "").replace("pm", "").trim();

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);
        if (pm && hour != 12) hour += 12;
        if (am && hour == 12) hour = 0;
        return hour * 60 + min;
    }

    // Auto-release bookings if room is unoccupied for 5 minutes
    private void scheduleAutoRelease() {
        cancelAutoRelease();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!occupied) {
                    System.out.println("\nRoom " + id + " is now unoccupied for >5 mins. Booking released. AC and lights off.");
                    bookings.clear();
                }
            }
        }, 5 * 60 * 1000); // 5 minutes
    }

    private void cancelAutoRelease() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    // Print room status
    public void printStatus() {
        System.out.print("Room " + id + " | Capacity: " + capacity
                + " | Occupants: " + occupants
                + " | Occupied: " + occupied
                + " | Bookings: ");

        if (bookings.isEmpty()) {
            System.out.println("None");
        } else {
            for (Booking b : bookings) {
                System.out.print("[" + b.getStartTime() + " for " + b.getDuration() + " mins] ");
            }
            System.out.println();
        }
    }
}
