package com.smartoffice.service;

import com.smartoffice.manager.FacilityManager;
import com.smartoffice.model.Booking;
import com.smartoffice.util.Logger;
import java.util.Map;

public class AdminService {
    private static final String ADMIN_PASSWORD = "admin123";

    public boolean authenticate(String password) {
        return ADMIN_PASSWORD.equals(password);
    }

    public void showAllBookings(FacilityManager manager) {
        Map<Integer, Booking> bookings = manager.getBookings();

        System.out.println("\n--- Admin Panel: Current Room Bookings ---");
        if (bookings.isEmpty()) {
            Logger.log("No rooms are currently booked.");
        } else {
            for (Booking booking : bookings.values()) {
                String summary = String.format(
                    "  - Room %d: Booked from %s to %s",
                    booking.getRoomNumber(),
                    booking.getStartTime(),
                    booking.getEndTime()
                );
                System.out.println(summary);
            }
        }
        System.out.println("------------------------------------------");
    }
}