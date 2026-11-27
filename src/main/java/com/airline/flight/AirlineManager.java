package com.airline.flight;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class AirlineManager {
    private List<Airline> airlines;

    public AirlineManager() {
        this.airlines = new ArrayList<>();
    }

    public void addAirline(Airline airline) {
        if (airline == null) {
            throw new IllegalArgumentException("Airline cannot be null.");
        }
        if (findAirline(airline.getAirlineId()) != null) {
            throw new IllegalArgumentException("Airline with ID " + airline.getAirlineId() + " already exists.");
        }
        airlines.add(airline);
    }

    public boolean removeAirline(String airlineId) {
        if (airlineId == null || airlineId.trim().isEmpty()) {
            return false;
        }
        for (int i = 0; i < airlines.size(); i++) {
            if (airlines.get(i).getAirlineId().equalsIgnoreCase(airlineId)) {
                airlines.remove(i);
                return true;
            }
        }
        return false;
    }

    public Airline findAirline(String airlineId) {
        if (airlineId == null || airlineId.trim().isEmpty()) {
            return null;
        }
        for (Airline airline : airlines) {
            if (airline.getAirlineId().equalsIgnoreCase(airlineId)) {
                return airline;
            }
        }
        return null;
    }

    public void displayAirlines() {
        if (airlines.isEmpty()) {
            System.out.println("No airlines available.");
            return;
        }
        System.out.println("=== Airlines List ===");
        for (Airline airline : airlines) {
            airline.displayInfo();
        }
    }
}