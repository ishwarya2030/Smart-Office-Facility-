package com.smartoffice.service;

import com.smartoffice.manager.FacilityManager;
import com.smartoffice.model.Booking;
import com.smartoffice.util.Logger;

import java.util.Map;

/**
 * Handles admin-only functionality like authentication and viewing reports.
 */
public class AdminService {
    // A simple, hardcoded password for the admin feature.
    private static final String ADMIN_PASSWORD = "admin123";

    /**
     * Checks if the provided password is correct.
     */
    public boolean authenticate(String password) {
        return ADMIN_PASSWORD.equals(password);
    }

    /**
     * Displays a summary of all current room bookings.
     * This fulfills the optional requirement for usage statistics.
     */
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