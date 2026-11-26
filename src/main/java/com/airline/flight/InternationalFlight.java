package com.airline.flight;

public class InternationalFlight extends Flight{
    private double internationalTax;
    private String visaRequirements;

    public InternationalFlight(String flightId, double basePrice, Airport origin, Airport destination, double internationalTax, String visaRequirements) {
        super(flightId, basePrice, origin, destination);
        this.internationalTax = internationalTax;
        this.visaRequirements = visaRequirements;
    }

    public double getInternationalTax() {
        return internationalTax;
    }

    public void setInternationalTax(double internationalTax) {
        this.internationalTax = internationalTax;
    }

    public String getVisaRequirements() {
        return visaRequirements;
    }

    public void setVisaRequirements(String visaRequirements) {
        this.visaRequirements = visaRequirements;
    }
    @Override
    public double calculatePrice() {
        return basePrice + internationalTax;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== International Flight ===");
        System.out.println("Flight ID: " + flightId);
        System.out.println("Route: " + origin + " -> " + destination);
        System.out.println("Base Price: " + basePrice + " | International Tax: " + internationalTax);
        System.out.println("Visa Requirements: " + visaRequirements);
        System.out.println("Total Price: " + calculatePrice());
    }
}
