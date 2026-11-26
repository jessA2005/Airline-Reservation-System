package com.airline.flight;

public class Airline {
    private String airlineId;
    private String name;
    private String country;

    public Airline(String airlineId, String name, String country) {
        this.airlineId = airlineId;
        this.name = name;
        this.country = country;
    }

    public String getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(String airlineId) {
        this.airlineId = airlineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
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
