package com.smartoffice.patterns.observer;

// DESIGN PATTERN: Observer (Subject Interface)
// Defines the contract for any object that can be observed.
public interface ISubject {
    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers();
}