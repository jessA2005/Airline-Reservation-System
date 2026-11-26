package com.airline.flight;

public class DomesticFlight extends Flight {
    private double domesticTax;

    public DomesticFlight(String flightId, double basePrice, Airport origin, Airport destination, double domesticTax) {
        super(flightId, basePrice, origin, destination);
        this.domesticTax = domesticTax;
    }

    public double getDomesticTax() {
        return domesticTax;
    }

    public void setDomesticTax(double domesticTax) {
        this.domesticTax = domesticTax;
    }

    @Override
    public double calculatePrice() {
        return basePrice + domesticTax;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Domestic Flight ===");
        System.out.println("Flight ID: " + flightId);
        System.out.println("Route: " + origin + " -> " + destination);
        System.out.println("Base Price: " + basePrice + " | Domestic Tax: " + domesticTax);
        System.out.println("Total Price: " + calculatePrice());
    }
}
