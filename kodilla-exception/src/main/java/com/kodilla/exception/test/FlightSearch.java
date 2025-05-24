package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    public Flight findFlight(Flight flight) throws RouteNotFoundException{
        Map<String, Boolean> flightMap = new HashMap<String, Boolean>();
        flightMap.put("JFK", true);
        flightMap.put("LHR", false);
        flightMap.put("CDG", true);
        String arrivalAirport = flight.getArrivalAirport();
        if (!flightMap.containsKey(arrivalAirport)) {
            throw new RouteNotFoundException("Airport " + arrivalAirport + " is not found in the system!");
        } else if (!flightMap.get(arrivalAirport)) {
            throw new RouteNotFoundException("Airport " + arrivalAirport + " is unavailable from your location!");
        }
        return flight;
    }


}
