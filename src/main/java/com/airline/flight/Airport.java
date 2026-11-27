package com.airline.flight;

public class Airport {
    private String airportCode;
    private String name;
    private String city;
    private String country;

    public Airport(String airportCode, String name, String city, String country) {
        setAirportCode(airportCode);
        setName(name);
        setCity(city);
        setCountry(country);
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        if (airportCode == null || airportCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Airport code cannot be null or empty.");
        }
        this.airportCode = airportCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Airport name cannot be null or empty.");
        }
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("Airport city cannot be null or empty.");
        }
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Airport country cannot be null or empty.");
        }
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