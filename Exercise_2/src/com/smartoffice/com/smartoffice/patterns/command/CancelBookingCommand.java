package com.smartoffice.patterns.command;

import com.smartoffice.manager.FacilityManager;

public class CancelBookingCommand implements ICommand {
    private final FacilityManager manager;
    private final int roomNumber;

    public CancelBookingCommand(FacilityManager manager, int roomNumber) {
        this.manager = manager;
        this.roomNumber = roomNumber;
    }

    @Override
    public void execute() {
        manager.cancelBooking(roomNumber);
    }
}