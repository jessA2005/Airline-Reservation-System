package com.airline.flight;

import java.util.ArrayList;
import java.util.List;

public class AirlineManager {
    private List<Airline> airlines;

    public AirlineManager() {
        this.airlines = new ArrayList<>();
    }

    public void addAirline(Airline airline) {
        if (airline != null) {
            airlines.add(airline);
        }
    }

    public boolean removeAirline(String airlineId) {
        for (int i = 0; i < airlines.size(); i++) {
            if (airlines.get(i).getAirlineId().equals(airlineId)) {
                airlines.remove(i);
                return true;
            }
        }
        return false;
    }

    public Airline findAirline(String airlineId) {
        for (Airline airline : airlines) {
            if (airline.getAirlineId().equals(airlineId)) {
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
