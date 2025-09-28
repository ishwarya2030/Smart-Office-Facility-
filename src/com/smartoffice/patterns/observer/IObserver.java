package com.smartoffice.patterns.observer;

import com.smartoffice.model.Room;

// DESIGN PATTERN: Observer (Observer Interface)
// Defines the method that all observers must implement.
// This allows the Subject (Room) to notify observers without knowing their concrete types.
public interface IObserver {
    void update(Room room);
}