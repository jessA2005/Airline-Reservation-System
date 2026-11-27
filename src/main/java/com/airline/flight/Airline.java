package com.airline.flight;
public class Airline {
    private String airlineId;
    private String name;
    private String country;

    public Airline(String airlineId, String name, String country) {
        setAirlineId(airlineId);
        setName(name);
        setCountry(country);
    }

    public String getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(String airlineId) {
        if (airlineId == null || airlineId.trim().isEmpty()) {
            throw new IllegalArgumentException("Airline ID cannot be null or empty.");
        }
        this.airlineId = airlineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Airline name cannot be null or empty.");
        }
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Airline country cannot be null or empty.");
        }
        this.country = country;
    }

    public void displayInfo() {
        System.out.println("Airline ID: " + airlineId + " | Name: " + name + " | Country: " + country);
    }

    @Override
    public String toString() {
        return name + " [" + airlineId + "]";
    }
}
