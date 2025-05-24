package com.kodilla.exception.test;

public class FlightApplication {
    public static void main(String[] args) throws RouteNotFoundException {
        Flight flight1 = new Flight("LAX", "JFK");
        Flight flight2 = new Flight("LAX", "LHR");
        Flight flight3 = new Flight("LAX", "XXX");
        FlightSearch flightSearch = new FlightSearch();

        try {
            Flight result = flightSearch.findFlight(flight1);
            System.out.println("Flight to " + result.getDepartureAirport() + " was found!");
        }
        catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Flight result = flightSearch.findFlight(flight2);
            System.out.println("Flight to " + result.getDepartureAirport() + " was found!");
        }
        catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Flight result = flightSearch.findFlight(flight3);
            System.out.println("Flight to " + result.getDepartureAirport() + " was found!");
        }
        catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
