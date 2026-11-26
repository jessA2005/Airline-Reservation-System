/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.airline.booking;

/**
 *
 * @author yasmaan
 */
public class Seat {
    private final String seatNumber;
    private final SeatClass seatClass;
    private boolean available;
    
    public Seat(String seatNumber, SeatClass seatClass) {
        
        if (seatNumber == null || seatNumber.isBlank())
        throw new IllegalArgumentException("Seat number can't be empty.");

    if (seatClass == null) 
        throw new IllegalArgumentException("Seat class can't be null.");
    
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.available = true;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public boolean reserve() {
    if (!available) return false;

        available = false;
        return true;
    
    }
    public void release() {
    available = true;
    }
    public String getSeatNumber() {
        return seatNumber;
    }
    public SeatClass getSeatClass() {
        return seatClass;
    }
    
    public void displayInfo() {
        System.out.println("Seat: " + seatNumber);
        System.out.println("Class: " + seatClass);
        System.out.println("Available: " + available);
    }
}
