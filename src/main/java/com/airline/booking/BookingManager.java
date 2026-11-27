/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.airline.booking;
import java.util.ArrayList;
import java.util.List;
import com.airline.user.Passenger;
import com.airline.flight.Flight;
import com.airline.booking.exception.*;

/**
 *
 * @author yasmaan
 */


/****
 * METHODS
 * creatBooking(), findBooking(), confirmBooking(), 
 * cancelBooking(), DisplayBookings(),displayPassengerBookings
 * 
*/
public class BookingManager {
    private final List<Booking> bookings;
    
    public BookingManager() {
    bookings = new ArrayList<>();
    
    }
    
    public boolean createBooking(String bookingId, Passenger passenger, Flight flight, Seat seat) {
    if (!seat.reserve()) {
            System.out.println("Seat is not available.");
            return false;
        }
    Booking booking = new Booking(bookingId, passenger, flight, seat);
    
    bookings.add(booking);
    return true;
    }
    
    public Booking findBooking(String bookingId) throws BookNotFoundException {
    for(Booking booking: bookings) {
    if(booking.getBookingId().equals(bookingId)) return booking;
    }
    throw new BookNotFoundException("Booking not found: " + bookingId);
    }
    
    public boolean confirmBooking(String bookingId) throws BookNotFoundException {
    Booking booking = findBooking(bookingId);
    if(booking == null || booking.getStatus() != BookingStatus.PENDING) return false;
    booking.confirmBooking();
    booking.calculateTotal();
    return true;
    
    }
    
    public boolean cancelBooking(String bookingId) throws BookNotFoundException {
        Booking booking = findBooking(bookingId);
    if(booking == null || booking.getStatus() == BookingStatus.CANCELLED) return false;
    
    booking.cancelBooking();
    return true;
    }
    
    public void displayBookings() {
    for(Booking booking: bookings) {
    booking.displayInfo();
    System.out.println("*********");
    }
    }
    
    public void displayPassengerBookings(Passenger passenger) {
        
    if (passenger == null) throw new IllegalArgumentException("Passenger cannot be null.");
     
    boolean found = false;
    
    for(Booking booking: bookings) {
    if(booking.getPassenger().getPassportNumber().equals(passenger.getPassportNumber())) {
    booking.displayInfo();
    found = true;
    }
    }
    
    if (!found) {
    System.out.println("No bookings found.");
}
    
    
    }
    
    public List<Booking> getAllBookings() {
    return new ArrayList<>(bookings);
}
    
}
