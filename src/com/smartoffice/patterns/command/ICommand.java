package com.smartoffice.patterns.command;

// DESIGN PATTERN: Command (Command Interface)
// Declares a method for executing a particular action.
// This decouples the object that invokes the operation from the one that knows how to perform it.
public interface ICommand {
    void execute();
}