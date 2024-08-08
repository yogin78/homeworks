package com.kodilla.exceptions.test;

import java.util.HashMap;
import java.util.Map;

public class FindFlight {

    private final Map<String, Boolean> airportAvailability;

    public FindFlight() {
        airportAvailability = new HashMap<>();
        airportAvailability.put("Poznań", true);
        airportAvailability.put("Wrocław", true);
        airportAvailability.put("Warszawa", true);
        airportAvailability.put("Rzeszów", false);
        airportAvailability.put("Kraków", true);
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        String arrivalAirport = flight.getArrivalAirport();

        if (!airportAvailability.containsKey(arrivalAirport)) {
            throw new RouteNotFoundException("Airport " + arrivalAirport + " is not reachable.");
        }

        return airportAvailability.get(arrivalAirport);
    }
}

