/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.airline.booking;
import java.util.ArrayList;
import java.util.List;
import com.airline.user.Passenger;
import com.airline.flight.Flight;

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
    
    public Booking findBooking(String bookingId) {
    for(Booking booking: bookings) {
    if(booking.getBookingId().equals(bookingId)) return booking;
    }
    return null;
    }
    
    public boolean confirmBooking(String bookingId) {
    Booking booking = findBooking(bookingId);
    if(booking == null || booking.getStatus() != BookingStatus.PENDING) return false;
    booking.confirmBooking();
    booking.calculateTotal();
    return true;
    }
    
    public boolean cancelBooking(String bookingId) {
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
    boolean found = false;
    
    for(Booking booking: bookings) {
    if(booking.getPassenger().getPassportumber().equals(passenger.getPassportNumber())) {
    booking.displayInfo();
    found = true;
    }
    }
    
    
    }
    
}
