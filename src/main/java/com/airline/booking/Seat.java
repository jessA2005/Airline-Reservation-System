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
    private String seatNumber;
    private SeatClass seatClass;
    private boolean available;
    
    public Seat(String seatNumber, SeatClass seatClass) {
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
