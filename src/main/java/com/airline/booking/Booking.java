/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.airline.booking;
import com.airline.user.Passenger;
import com.airline.flight.Flight;

/**
 *
 * @author yasmaan
 */

/****
 * METHODS
 * confirmBooking(), cancelBooking(), calculateTotal(), 
 * getBookingId(), getPassenger(),getFlight(), getSeat(), getStatus()
 * getTotalAmount(), displayInfo()
 * 
*/
public class Booking {
    private final String bookingId;
    private BookingStatus status;
    private double totalAmount;
    private final Passenger passenger;
    private final Flight flight;
    private final Seat seat;
    
public Booking(String bookingId, Passenger passenger, Flight flight, Seat seat) {
    this.bookingId = bookingId;
    this.passenger = passenger;
     this.flight = flight;
    this.seat = seat;
    this.status = BookingStatus.PENDING;
}
    public void confirmBooking() {
    if (status == BookingStatus.PENDING && !seat.isAvailable())
            status = BookingStatus.CONFIRMED;
   
    }
    public void cancelBooking() {
    if(status!=BookingStatus.CANCELLED) {
    status = BookingStatus.CANCELLED;
    seat.release(); //handle release error?
    }
    }
    //getters start
    public double calculateTotal() {
    totalAmount = flight.calculatePrice();
    return totalAmount;
    }
    public String getBookingId() {
        return bookingId;
    }
    public Passenger getPassenger() {
        return passenger;
    }
    public Flight getFlight() {
        return flight;
    }
    public Seat getSeat() {
        return seat;
    }
    public BookingStatus getStatus() {
        return status;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    //getters end
    public void displayInfo() {
    System.out.println("Booking ID: " + bookingId);
        System.out.println("Passenger: " + passenger.getPassportNumber());
        System.out.println("Flight: " + flight.getFlightId());
        System.out.println("Seat: " + seat.getSeatNumber());
        System.out.println("Status: " + status);
        System.out.println("Total: " + totalAmount);
    }
    
}
