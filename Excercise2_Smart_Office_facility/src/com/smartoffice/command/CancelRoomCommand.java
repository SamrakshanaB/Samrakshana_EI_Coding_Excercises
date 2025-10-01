package com.smartoffice.command;

import com.smartoffice.singleton.OfficeConfig;
import com.smartoffice.singleton.Room;
import java.util.Iterator;

public class CancelRoomCommand implements Command {
    private int roomId;
    private String startTime; // Optional: cancel specific booking

    public CancelRoomCommand(int roomId) {
        this.roomId = roomId;
        this.startTime = null;
    }

    public CancelRoomCommand(int roomId, String startTime) {
        this.roomId = roomId;
        this.startTime = startTime;
    }

    @Override
    public void execute() {
        OfficeConfig config = OfficeConfig.getInstance();
        if (!config.roomExists(roomId)) {
            System.out.println("Room " + roomId + " does not exist.");
            return;
        }
        Room room = config.getRoom(roomId);

        if (room.getBookings().isEmpty()) {
            System.out.println("Room " + roomId + " has no bookings to cancel.");
            return;
        }

        if (startTime == null) {
            room.getBookings().clear();
            System.out.println("All bookings for Room " + roomId + " cancelled successfully.");
        } else {
            Iterator<Room.Booking> it = room.getBookings().iterator();
            boolean found = false;
            while (it.hasNext()) {
                Room.Booking b = it.next();
                if (b.getStartTime().equalsIgnoreCase(startTime)) {
                    it.remove();
                    found = true;
                    System.out.println("Booking for Room " + roomId + " at " + startTime + " cancelled successfully.");
                    break;
                }
            }
            if (!found) {
                System.out.println("No booking found for Room " + roomId + " at " + startTime + ".");
            }
        }
    }
}
