package com.airline.user;

import com.airline.booking.Booking;
import com.airline.booking.BookingManager;

public abstract class Passenger extends User {

    protected String passportNumber;
    protected String phoneNumber;

    public Passenger(
            int userId,
            String name,
            String email,
            String password,
            String passportNumber,
            String phoneNumber) {

        super(userId, name, email, password);

        if (passportNumber == null || passportNumber.isEmpty()) {
            throw new IllegalArgumentException("Invalid Passport number.");
        }
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Invalid Phone number.");
        }

        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
    }

    public void viewBookings(BookingManager manager) {
        if (manager == null) {
            throw new IllegalArgumentException("BookingManager cannot be null.");
        }

        try {
            manager.displayPassengerBookings(this);
        } catch (Exception e) {
            System.out.println("Error viewing bookings: " + e.getMessage());
        }
    }

    public void cancelBooking(
            String bookingId,
            BookingManager manager) {

        if (bookingId == null || bookingId.isEmpty()) {
            throw new IllegalArgumentException("Invalid booking ID.");
        }
        if (manager == null) {
            throw new IllegalArgumentException("BookingManager cannot be null.");
        }

        try {
            Booking booking = manager.findBooking(bookingId);

            if (booking == null) {
                System.out.println("Booking not found.");
                return;
            }

            if (booking.getPassenger() == null || booking.getPassenger().getPassportNumber() == null) {
                System.out.println("Booking passenger details are missing.");
                return;
            }

            if (!booking.getPassenger().getPassportNumber()
                    .equals(this.passportNumber)) {
                System.out.println("You cannot cancel this booking.");
                return;
            }

            boolean cancelled = manager.cancelBooking(bookingId);

            if (cancelled) {
                System.out.println("Booking cancelled successfully.");
            } else {
                System.out.println("Booking could not be cancelled.");
            }
        } catch (Exception e) {
            System.out.println("Error cancelling booking: " + e.getMessage());
        }
    }

    public abstract void displayInfo();

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
