package UserManager;

import java.util.Scanner;

public class Admin extends User {

    private String employeeId;

    public Admin(
            int userId,
            String name,
            String email,
            String password,
            String employeeId) {

        super(userId, name, email, password);
        this.employeeId = employeeId;
    }

    public void addFlight(Flight flight, FlightManager flightManager) {

        flightManager.addFlight(flight);
        System.out.println("Admin " + name + " added a new flight.");
    }

    public void removeFlight(String flightId, FlightManager flightManager) {

        flightManager.removeFlight(flightId);
        System.out.println("Admin " + name + " removed flight ID: " + flightId);
    }

    public void manageAirlines(AirlineManager airlineManager) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Airline Management ---");
            System.out.println("1. View all airlines");
            System.out.println("2. Add an airline");
            System.out.println("3. Remove an airline");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    airlineManager.displayAirlines();
                    break;
                case "2":
                    System.out.println("Notice: Airline creation requires Member 1's Airline object.");
                    break;
                case "3":
                    System.out.print("Enter Airline ID to remove: ");
                    String airlineId = scanner.nextLine();
                    airlineManager.removeAirline(airlineId);
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
        System.out.println("Admin " + name + " is viewing all system bookings:");
        

        if (bookingManager.getBookings().isEmpty()) {
            System.out.println("No bookings in the system.");
            return;
        }

        for (Booking booking : bookingManager.getBookings()) {

            System.out.println(booking.displayInfo());
        }
    }

    public void managePassengers(UserManager userManager) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Passenger Management ---");
            System.out.println("1. View all users");
            System.out.println("2. Remove a user");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    userManager.displayUsers();
                    break;
                case "2":
                    System.out.print("Enter User ID to remove: ");
                    try {
                        int userId = Integer.parseInt(scanner.nextLine());
                        boolean success = userManager.removeUser(userId);
                        if (success) {
                            System.out.println("User removed successfully.");
                        } else {
                            System.out.println("User not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. User ID must be a number.");
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
