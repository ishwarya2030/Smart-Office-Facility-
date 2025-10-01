package com.smartoffice.model;

import java.time.LocalTime;

public class Booking {
    private final int roomNumber;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public Booking(int roomNumber, LocalTime startTime, int durationMinutes) {
        this.roomNumber = roomNumber;
        this.startTime = startTime;
        this.endTime = startTime.plusMinutes(durationMinutes);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public boolean overlaps(LocalTime otherStart, LocalTime otherEnd) {
        return startTime.isBefore(otherEnd) && endTime.isAfter(otherStart);
    }
}