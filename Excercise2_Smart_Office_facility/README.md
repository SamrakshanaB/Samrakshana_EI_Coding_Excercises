**Smart Office Facility Manager**

**Use Case**

Modern smart offices need efficient management of conference rooms, occupancy, and automation of resources.

This console-based application helps employees book conference rooms, manage occupancy, and automate lighting/AC control.

It ensures no double-booking conflicts, supports booking cancellation, and provides a clear status summary of all rooms.


**Given Functionalities**

Configure Rooms – Set up number of rooms in the office.

Set Capacity – Define maximum capacity for each room.

Add Occupants – Track occupancy dynamically with automated AC/Lights control.

Book Room – Reserve a room with start time and duration, with overlap prevention.

Cancel Booking – Cancel all bookings or a specific booking by start time.

Show Room Status – Display real-time status including capacity, occupants, and bookings.



**Error Handling**

Invalid capacity input → Shows proper message.

Room not found → Handled gracefully.

Overlapping booking attempt → Blocked with proper notification.

Cancel booking with no reservations → Informs the user.


**Additional Functionalities Added**

Multiple Non-Overlapping Bookings – Same room can hold multiple reservations at different times.

Dynamic Observer Notifications – AC/Lights observers get notified automatically when occupancy changes.

Time Conversion & Validation – Handles AM/PM properly while checking overlaps.

Clear Console Messages – User-friendly feedback for every action.


**Design Patterns Used**

Singleton Pattern – OfficeConfig ensures only one office configuration exists across the system.

Factory Pattern – (Optional for extension) Could be used for creating room objects in a unified way.

Command Pattern – Encapsulates actions like BookRoomCommand, CancelRoomCommand, etc., for scalability.

Observer Pattern – Occupancy changes automatically notify observers (AC, Lights).



