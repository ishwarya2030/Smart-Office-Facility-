package com.smartoffice.model;

import com.smartoffice.patterns.observer.IObserver;
import com.smartoffice.patterns.observer.ISubject;
import java.util.ArrayList;
import java.util.List;

public class Room implements ISubject {
    private final int roomNumber;
    private int capacity;
    private int occupantCount = 0;
    private boolean isOccupied = false;
    private final List<IObserver> observers = new ArrayList<>();

    public Room(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
    
    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupantCount(int count) {
        if (count < 0) return;
        this.occupantCount = count;
        
        boolean newOccupancyState = (count >= 2);
        if (newOccupancyState != this.isOccupied) {
            this.isOccupied = newOccupancyState;
            notifyObservers();
        }
    }
    
    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update(this);
        }
    }
}