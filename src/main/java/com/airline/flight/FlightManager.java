package com.airline.flight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlightManager {
    private List<Flight> flights;

    public FlightManager() {
        this.flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("Flight cannot be null.");
        }
        if (findFlight(flight.getFlightId()) != null) {
            throw new IllegalArgumentException("Flight with ID " + flight.getFlightId() + " already exists.");
        }
        flights.add(flight);
    }

    public boolean removeFlight(String flightId) {
        if (flightId == null || flightId.trim().isEmpty()) {
            return false;
        }
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getFlightId().equalsIgnoreCase(flightId)) {
                flights.remove(i);
                return true;
            }
        }
        return false;
    }

    public Flight findFlight(String flightId) {
        if (flightId == null || flightId.trim().isEmpty()) {
            return null;
        }
        for (Flight flight : flights) {
            if (flight.getFlightId().equalsIgnoreCase(flightId)) {
                return flight;
            }
        }
        return null;
    }

    public List<Flight> searchFlights(String from, String to) {
        List<Flight> result = new ArrayList<>();
        if (from == null || from.trim().isEmpty() || to == null || to.trim().isEmpty()) {
            return result;
        }
        String cleanFrom = from.trim();
        String cleanTo = to.trim();
        for (Flight flight : flights) {
            boolean matchesOrigin = flight.getOrigin().getAirportCode().equalsIgnoreCase(cleanFrom)
                    || flight.getOrigin().getCity().equalsIgnoreCase(cleanFrom);
            boolean matchesDestination = flight.getDestination().getAirportCode().equalsIgnoreCase(cleanTo)
                    || flight.getDestination().getCity().equalsIgnoreCase(cleanTo);

            if (matchesOrigin && matchesDestination) {
                result.add(flight);
            }
        }
        return result;
    }

    public void displayFlights() {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
            return;
        }
        System.out.println("=== Flights List ===");
        for (Flight flight : flights) {
            flight.displayInfo();
            System.out.println();
        }
    }

    public <T extends Comparable<T>> void sortFlights(List<T> flights) {
        if (flights == null) {
            throw new IllegalArgumentException("Flights list cannot be null.");
        }
        Collections.sort(flights);
    }
}