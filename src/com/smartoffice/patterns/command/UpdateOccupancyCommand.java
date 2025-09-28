package com.smartoffice.patterns.command;

import com.smartoffice.manager.FacilityManager;

// DESIGN PATTERN: Command (Concrete Command)
// Encapsulates the action of updating room occupancy.
public class UpdateOccupancyCommand implements ICommand {
    private final FacilityManager manager;
    private final int roomNumber;
    private final int occupantCount;

    public UpdateOccupancyCommand(FacilityManager manager, int roomNumber, int occupantCount) {
        this.manager = manager;
        this.roomNumber = roomNumber;
        this.occupantCount = occupantCount;
    }

    @Override
    public void execute() {
        manager.updateOccupancy(roomNumber, occupantCount);
    }
}