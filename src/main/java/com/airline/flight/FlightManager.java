package com.airline.flight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlightManager {
    private List<Flight> flights;
    public FlightManager() {
        this.flights = new ArrayList<>();
    }
    public void addFlight(Flight flight) {
        if (flight != null) {
            flights.add(flight);
        }
    }
    public boolean removeFlight(String flightId) {
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getFlightId().equals(flightId)) {
                flights.remove(i);
                return true;
            }
        }
        return false;
    }
    public Flight findFlight(String flightId) {
        for (Flight flight : flights) {
            if (flight.getFlightId().equals(flightId)) {
                return flight;
            }
        }
        return null;
    }
    public List<Flight> searchFlights(String from, String to) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            boolean matchesOrigin = flight.getOrigin().getAirportCode().equalsIgnoreCase(from)
                    || flight.getOrigin().getCity().equalsIgnoreCase(from);
            boolean matchesDestination = flight.getDestination().getAirportCode().equalsIgnoreCase(to)
                    || flight.getDestination().getCity().equalsIgnoreCase(to);

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
        Collections.sort(flights);
    }

}
