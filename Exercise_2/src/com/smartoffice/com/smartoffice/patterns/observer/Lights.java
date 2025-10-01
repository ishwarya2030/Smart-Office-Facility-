package com.smartoffice.patterns.observer;

import com.smartoffice.model.Room;
import com.smartoffice.util.Logger;

public class Lights implements IObserver {
    @Override
    public void update(Room room) {
        if (room.isOccupied()) {
            Logger.log("Lights: Turned ON for Room " + room.getRoomNumber());
        } else {
            Logger.log("Lights: Turned OFF for Room " + room.getRoomNumber());
        }
    }
}