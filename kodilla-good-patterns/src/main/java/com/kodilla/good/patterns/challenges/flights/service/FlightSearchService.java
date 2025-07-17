package com.kodilla.good.patterns.challenges.flights.service;

import com.kodilla.good.patterns.challenges.flights.models.City;
import com.kodilla.good.patterns.challenges.flights.models.Flight;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightSearchService {

    private final Set<Flight> flights;

    public FlightSearchService(Set<Flight> flights) {
        this.flights = flights;
    }

    public Set<Flight> findFlightsFrom(City departure) {
        return flights.stream()
                .filter(f -> f.getDeparture().equals(departure))
                .collect(Collectors.toSet());
    }

    public Set<Flight> findFlightsTo(City arrival) {
        return flights.stream()
                .filter(f -> f.getArrival().equals(arrival))
                .collect(Collectors.toSet());
    }

    public Set<List<Flight>> findAllFlightsWithStopover(City from, City to) {
        Set<Flight> flightsFrom = findFlightsFrom(from);
        Set<Flight> flightsTo = findFlightsTo(to);
        return flightsFrom.stream()
                .flatMap(f1 ->
                        flightsTo.stream()
                                .filter(f2 -> f1.getArrival().equals(f2.getDeparture()))
                                .map(f2 -> List.of(f1, f2))
                )
                .collect(Collectors.toSet());
    }

    public Set<Flight> getFlights() {
        return new HashSet<>(flights);
    }
}
