package com.smartoffice;

import com.smartoffice.manager.FacilityManager;
import com.smartoffice.patterns.command.*;
import com.smartoffice.service.AdminService;
import com.smartoffice.util.Logger;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FacilityManager manager = FacilityManager.getInstance();
        AdminService adminService = new AdminService();
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;

        printWelcomeMessage();

        while (shouldContinue) {
            System.out.print("\nEnter command > ");
            String commandName = scanner.nextLine().trim().toLowerCase();
            
            ICommand commandToExecute = null;

            try {
                switch (commandName) {
                    case "c": // Config
                        System.out.print("  Number of rooms: ");
                        int roomCount = scanner.nextInt();
                        scanner.nextLine(); 
                        manager.configureRooms(roomCount);
                        break;
                    
                    case "a": // Add Occupant
                        System.out.print("  Room No: ");
                        int roomNumForAdd = scanner.nextInt();
                        
                        // IMMEDIATE VALIDATION
                        if (!manager.roomExists(roomNumForAdd)) {
                            Logger.error("Room " + roomNumForAdd + " does not exist. Please try again.");
                            scanner.nextLine(); // Consume the rest of the line
                            continue; // Go back to the start of the loop
                        }
                        
                        System.out.print("  Occupant Count: ");
                        int count = scanner.nextInt();
                        scanner.nextLine(); 
                        commandToExecute = new UpdateOccupancyCommand(manager, roomNumForAdd, count);
                        break;
                        
                    case "b": // Block Room
                        System.out.print("  Room No: ");
                        int roomNumForBlock = scanner.nextInt();

                        // IMMEDIATE VALIDATION
                        if (!manager.roomExists(roomNumForBlock)) {
                            Logger.error("Room " + roomNumForBlock + " does not exist. Please try again.");
                            scanner.nextLine(); 
                            continue;
                        }

                        scanner.nextLine(); 
                        System.out.print("  Start Time (HH:mm): ");
                        String timeStr = scanner.nextLine();
                        LocalTime time = LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("HH:mm"));
                        System.out.print("  Duration (minutes): ");
                        int duration = scanner.nextInt();
                        scanner.nextLine();
                        commandToExecute = new BookRoomCommand(manager, roomNumForBlock, time, duration);
                        break;
                        
                    case "x": // Cancel Booking
                        System.out.print("  Room No to cancel: ");
                        int roomNumForCancel = scanner.nextInt();

                        // IMMEDIATE VALIDATION
                        if (!manager.roomExists(roomNumForCancel)) {
                            Logger.error("Room " + roomNumForCancel + " does not exist. Please try again.");
                            scanner.nextLine(); 
                            continue;
                        }

                        scanner.nextLine(); 
                        commandToExecute = new CancelBookingCommand(manager, roomNumForCancel);
                        break;

                    case "v": // View Admin Details
                         System.out.print("  Enter Admin Password: ");
                         String password = scanner.nextLine();
                         if (adminService.authenticate(password)) {
                             adminService.showAllBookings(manager);
                         } else {
                             Logger.error("Access Denied. Incorrect password.");
                         }
                         break;

                    case "h": // Help
                        printWelcomeMessage();
                        break;

                    case "q": // Quit/Exit
                        shouldContinue = false;
                        Logger.log("Exiting system. Goodbye!");
                        break;
                        
                    default:
                        Logger.error("Unknown command. Type 'h' to see all commands.");
                        break;
                }
                
                if (commandToExecute != null) {
                    commandToExecute.execute();
                }

            } catch (InputMismatchException e) {
                Logger.error("Invalid input. Please enter a valid number.");
                scanner.nextLine(); 
            } catch (DateTimeParseException e) {
                Logger.error("Invalid time format. Please use HH:mm (e.g., 09:30).");
            } catch (Exception e) {
                Logger.error("An error occurred: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void printWelcomeMessage() {
        System.out.println("\n==============================================");
        System.out.println("  Welcome to the Smart Office Facility System");
        System.out.println("==============================================");
        System.out.println("Enter a command character to begin:\n");
        
        System.out.println("  c   - Configure Rooms");
        System.out.println("  a   - Add/Update Occupants");
        System.out.println("  b   - Block (Book) a Room");
        System.out.println("  x   - Cancel a Booking");
        System.out.println("  v   - View Admin Details (password required)");
        System.out.println("  h   - Help (Show this guide)");
        System.out.println("  q   - Quit");
        System.out.println("----------------------------------------------");
    }
}