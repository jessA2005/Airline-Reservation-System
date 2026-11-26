package com.airline.user;

import java.util.NoSuchElementException;
import java.util.Scanner;
import com.airline.booking.Booking;
import com.airline.booking.BookingManager;
import com.airline.flight.Flight;
import com.airline.flight.FlightManager;
import com.airline.flight.AirlineManager;

public class Admin extends User {

    private String employeeId;

    public Admin(
            int userId,
            String name,
            String email,
            String password,
            String employeeId) {

        super(userId, name, email, password);
        if (employeeId == null || employeeId.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Employee ID.");
        }
        this.employeeId = employeeId.trim();
    }

    public void addFlight(Flight flight, FlightManager flightManager) {
        if (flight == null) {
            throw new IllegalArgumentException("Flight cannot be null.");
        }
        if (flightManager == null) {
            throw new IllegalArgumentException("FlightManager cannot be null.");
        }

        try {
            flightManager.addFlight(flight);
            System.out.println("Admin " + name + " added a new flight.");
        } catch (Exception e) {
            System.out.println("Error adding flight: " + e.getMessage());
        }
    }

    public void removeFlight(String flightId, FlightManager flightManager) {
        if (flightId == null || flightId.isEmpty()) {
            throw new IllegalArgumentException("Flight ID cannot be null or empty.");
        }
        if (flightManager == null) {
            throw new IllegalArgumentException("FlightManager cannot be null.");
        }

        try {
            flightManager.removeFlight(flightId);
            System.out.println("Admin " + name + " removed flight ID: " + flightId);
        } catch (Exception e) {
            System.out.println("Error removing flight: " + e.getMessage());
        }
    }

    public void manageAirlines(AirlineManager airlineManager) {
        if (airlineManager == null) {
            throw new IllegalArgumentException("AirlineManager cannot be null.");
        }

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Airline Management ---");
            System.out.println("1. View all airlines");
            System.out.println("2. Add an airline");
            System.out.println("3. Remove an airline");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            String choice;
            try {
                choice = scanner.nextLine().trim();
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("Input stream unavailable. Exiting Airline Management.");
                break;
            }

            switch (choice) {
                case "1":
                    try {
                        airlineManager.displayAirlines();
                    } catch (Exception e) {
                        System.out.println("Error displaying airlines: " + e.getMessage());
                    }
                    break;
                case "2":
                    System.out.println("Notice: Airline creation requires Member 1's Airline object.");
                    break;
                case "3":
                    System.out.print("Enter Airline ID to remove: ");
                    try {
                        String airlineId = scanner.nextLine().trim();
                        if (airlineId.isEmpty()) {
                            System.out.println("Airline ID cannot be empty.");
                            break;
                        }
                        airlineManager.removeAirline(airlineId);
                    } catch (NoSuchElementException | IllegalStateException e) {
                        System.out.println("Input stream unavailable. Exiting Airline Management.");
                        exit = true;
                    } catch (Exception e) {
                        System.out.println("Error removing airline: " + e.getMessage());
                    }
                    break;
                case "4":
                    exit = true;
                    System.out.println("Exiting Airline Management.");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    public void viewAllBookings(BookingManager bookingManager) {
        if (bookingManager == null) {
            throw new IllegalArgumentException("BookingManager cannot be null.");
        }

        System.out.println("Admin " + name + " is viewing all system bookings:");

        try {
            if (bookingManager.getBookings() == null || bookingManager.getBookings().isEmpty()) {
                System.out.println("No bookings in the system.");
                return;
            }

            for (Booking booking : bookingManager.getBookings()) {
                if (booking != null) {
                    booking.displayInfo();
                }
            }
        } catch (Exception e) {
            System.out.println("Error viewing bookings: " + e.getMessage());
        }
    }

    public void managePassengers(UserManager userManager) {
        if (userManager == null) {
            throw new IllegalArgumentException("UserManager cannot be null.");
        }

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Passenger Management ---");
            System.out.println("1. View all users");
            System.out.println("2. Remove a user");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            String choice;
            try {
                choice = scanner.nextLine().trim();
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("Input stream unavailable. Exiting Passenger Management.");
                break;
            }

            switch (choice) {
                case "1":
                    try {
                        userManager.displayUsers();
                    } catch (Exception e) {
                        System.out.println("Error displaying users: " + e.getMessage());
                    }
                    break;
                case "2":
                    System.out.print("Enter User ID to remove: ");
                    try {
                        int userId = Integer.parseInt(scanner.nextLine().trim());
                        boolean success = userManager.removeUser(userId);
                        if (success) {
                            System.out.println("User removed successfully.");
                        } else {
                            System.out.println("User not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. User ID must be a number.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid User ID: " + e.getMessage());
                    } catch (NoSuchElementException | IllegalStateException e) {
                        System.out.println("Input stream unavailable. Exiting Passenger Management.");
                        exit = true;
                    } catch (Exception e) {
                        System.out.println("Error removing user: " + e.getMessage());
                    }
                    break;
                case "3":
                    exit = true;
                    System.out.println("Exiting Passenger Management.");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    public String getEmployeeId() {
        return employeeId;
    }
}
