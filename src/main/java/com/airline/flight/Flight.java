package com.airline.flight;

public abstract class Flight implements Comparable<Flight> {
    protected String flightId;
    protected double basePrice;
    protected Airport origin;
    protected Airport destination;

    public Flight(String flightId, double basePrice, Airport origin, Airport destination) {
        setFlightId(flightId);
        setBasePrice(basePrice);
        setOrigin(origin);
        setDestination(destination);
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        if (flightId == null || flightId.trim().isEmpty()) {
            throw new IllegalArgumentException("Flight ID cannot be null or empty.");
        }
        this.flightId = flightId;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice < 0) {
            throw new IllegalArgumentException("Base price cannot be negative.");
        }
        this.basePrice = basePrice;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        if (origin == null) {
            throw new IllegalArgumentException("Origin airport cannot be null.");
        }
        if (this.destination != null && origin.getAirportCode().equalsIgnoreCase(this.destination.getAirportCode())) {
            throw new IllegalArgumentException("Origin and destination airports cannot be the same.");
        }
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        if (destination == null) {
            throw new IllegalArgumentException("Destination airport cannot be null.");
        }
        if (this.origin != null && destination.getAirportCode().equalsIgnoreCase(this.origin.getAirportCode())) {
            throw new IllegalArgumentException("Origin and destination airports cannot be the same.");
        }
        this.destination = destination;
    }

    public abstract double calculatePrice();

    public abstract void displayInfo();

    @Override
    public int compareTo(Flight other) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot compare to a null flight.");
        }
        return Double.compare(this.calculatePrice(), other.calculatePrice());
    }
}