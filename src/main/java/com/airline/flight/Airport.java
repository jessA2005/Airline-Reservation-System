package com.airline.flight;

public class Airport {
    private String airportCode;
    private String name;
    private String city;
    private String country;

    public Airport(String airportCode, String name, String city, String country) {
        this.airportCode = airportCode;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void displayInfo() {
        System.out.println("Airport: " + name + " (" + airportCode + ") - " + city + ", " + country);
    }

    @Override
    public String toString() {
        return name + " (" + airportCode + ")";
    }
}
