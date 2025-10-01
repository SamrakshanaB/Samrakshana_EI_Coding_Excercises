package com.smartoffice.command;

import com.smartoffice.singleton.OfficeConfig;
import com.smartoffice.singleton.Room;

public class AddOccupantCommand implements Command {
    private int roomId;
    private int count;

    public AddOccupantCommand(int roomId, int count) {
        this.roomId = roomId;
        this.count = count;
    }

    @Override
    public void execute() {
        OfficeConfig config = OfficeConfig.getInstance();
        if (!config.roomExists(roomId)) {
            System.out.println("Room " + roomId + " does not exist.");
            return;
        }

        Room room = config.getRoom(roomId);

        // Capacity validation
        if (count > room.getCapacity()) {
            System.out.println("Cannot add " + count + " occupants. Max capacity is " + room.getCapacity() + ".");
            return; // Do not update occupants
        }

        room.setOccupied(count);

        // Print appropriate messages based on occupancy
        if (count >= 2) {
            System.out.println("Lights turned on.");
            System.out.println("AC turned on.");
            System.out.println("Room " + roomId + " is now occupied by " + count + " persons.");
        } else if (count == 0) {
            System.out.println("Room " + roomId + " is now unoccupied. AC and lights turned off.");
        } else {
            System.out.println("Room " + roomId + " occupancy insufficient to mark as occupied.");
        }
    }
}
