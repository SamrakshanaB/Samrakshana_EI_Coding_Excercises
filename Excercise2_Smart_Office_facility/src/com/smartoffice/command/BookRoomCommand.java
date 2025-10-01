package com.smartoffice.command;

import com.smartoffice.singleton.OfficeConfig;
import com.smartoffice.singleton.Room;

public class BookRoomCommand implements Command {
    private int roomId;
    private String startTime;
    private int duration;

    public BookRoomCommand(int roomId, String startTime, int duration) {
        this.roomId = roomId;
        this.startTime = startTime;
        this.duration = duration;
    }

    @Override
    public void execute() {
        OfficeConfig config = OfficeConfig.getInstance();
        if (!config.roomExists(roomId)) {
            System.out.println("Invalid room number. Please enter a valid room number.");
            return;
        }
        Room room = config.getRoom(roomId);

        if (room.isOverlapping(startTime, duration)) {
            System.out.println("Room " + roomId + " is already booked during this time. Cannot book.");
        } else {
            room.addBooking(startTime, duration);
            System.out.println("Room " + roomId + " booked from " + startTime + " for " + duration + " minutes.");
        }
    }
}
