package com.smartoffice.patterns.observer;

import com.smartoffice.model.Room;

public interface IObserver {
    void update(Room room);
}