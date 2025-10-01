package com.smartoffice.manager;

import com.smartoffice.model.Booking;
import com.smartoffice.model.Room;
import com.smartoffice.patterns.observer.AirConditioner;
import com.smartoffice.patterns.observer.Lights;
import com.smartoffice.util.Logger;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class FacilityManager {
    private static FacilityManager instance;
    private final Map<Integer, Room> rooms = new HashMap<>();
    private final Map<Integer, Booking> bookings = new HashMap<>();

    private FacilityManager() {}

    public static synchronized FacilityManager getInstance() {
        if (instance == null) {
            instance = new FacilityManager();
        }
        return instance;
    }

    public void configureRooms(int count) {
        rooms.clear();
        bookings.clear();
        for (int i = 1; i <= count; i++) {
            Room room = new Room(i, 10);
            room.addObserver(new Lights());
            room.addObserver(new AirConditioner());
            rooms.put(i, room);
        }
        Logger.log("Office configured with " + count + " meeting rooms.");
    }

    public boolean roomExists(int roomNumber) {
        return rooms.containsKey(roomNumber);
    }

    public void updateOccupancy(int roomNumber, int occupantCount) {
        Room room = rooms.get(roomNumber);
        if (room == null) { // This check is mostly for safety; main validation is in UI
            Logger.error("Room " + roomNumber + " does not exist.");
            return;
        }
        room.setOccupantCount(occupantCount);
        if (occupantCount >= 2) {
             Logger.log("Room " + roomNumber + " is now occupied by " + occupantCount + " persons.");
        } else if (occupantCount > 0) {
             Logger.log("Room " + roomNumber + " occupancy insufficient to mark as occupied.");
        } else {
             Logger.log("Room " + roomNumber + " is now unoccupied.");
        }
    }
    
    public void bookRoom(int roomNumber, LocalTime startTime, int duration) {
        LocalTime endTime = startTime.plusMinutes(duration);
        for (Booking existingBooking : bookings.values()) {
            if (existingBooking.getRoomNumber() == roomNumber && existingBooking.overlaps(startTime, endTime)) {
                Logger.error("Room " + roomNumber + " is already booked during this time. Cannot book.");
                return;
            }
        }
        Booking newBooking = new Booking(roomNumber, startTime, duration);
        bookings.put(roomNumber, newBooking);
        Logger.log("Room " + roomNumber + " booked from " + startTime + " for " + duration + " minutes.");
    }

    public void cancelBooking(int roomNumber) {
        if (!bookings.containsKey(roomNumber)) {
            Logger.error("Room " + roomNumber + " is not booked. Cannot cancel booking.");
            return;
        }
        bookings.remove(roomNumber);
        Logger.log("Booking for Room " + roomNumber + " cancelled successfully.");
    }

    public Map<Integer, Booking> getBookings() {
        return this.bookings;
    }
}