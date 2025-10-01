package com.smartoffice.patterns.observer;

import com.smartoffice.model.Room;
import com.smartoffice.util.Logger;

public class AirConditioner implements IObserver {
    @Override
    public void update(Room room) {
        if (room.isOccupied()) {
            Logger.log("AirConditioner: Turned ON for Room " + room.getRoomNumber());
        } else {
            Logger.log("AirConditioner: Turned OFF for Room " + room.getRoomNumber());
        }
    }
}