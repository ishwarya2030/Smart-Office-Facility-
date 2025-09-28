package com.smartoffice.patterns.command;

import com.smartoffice.manager.FacilityManager;
import java.time.LocalTime;

// DESIGN PATTERN: Command (Concrete Command)
// Encapsulates the action of booking a room.
public class BookRoomCommand implements ICommand {
    private final FacilityManager manager;
    private final int roomNumber;
    private final LocalTime startTime;
    private final int duration;

    public BookRoomCommand(FacilityManager manager, int roomNumber, LocalTime startTime, int duration) {
        this.manager = manager;
        this.roomNumber = roomNumber;
        this.startTime = startTime;
        this.duration = duration;
    }

    @Override
    public void execute() {
        manager.bookRoom(roomNumber, startTime, duration);
    }
}