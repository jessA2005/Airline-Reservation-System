package com.airline.flight;

public abstract class Flight implements Comparable<Flight> {
    protected String flightId;
    protected double basePrice;
    protected Airport origin;
    protected Airport destination;

    public Flight(String flightId, double basePrice, Airport origin, Airport destination) {
        this.flightId = flightId;
        this.basePrice = basePrice;
        this.origin = origin;
        this.destination = destination;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public abstract double calculatePrice();

    public abstract void displayInfo();

    @Override
    public int compareTo(Flight other) {
        return Double.compare(this.calculatePrice(), other.calculatePrice());
    }
}
