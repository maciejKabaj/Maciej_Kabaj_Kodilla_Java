package com.kodilla.good.patterns.challenges.flights.repository;

import com.kodilla.good.patterns.challenges.flights.models.City;
import com.kodilla.good.patterns.challenges.flights.models.Flight;

import java.util.HashSet;
import java.util.Set;

public class FlightRepository {
    private final Set<Flight> flights;

    public FlightRepository() {

        City gdansk = new City("Gdansk");
        City wroclaw = new City("Wroclaw");
        City krakow = new City("Krakow");
        City warszawa = new City("Warszawa");

        flights = new HashSet<>();
        flights.add(new Flight(gdansk, wroclaw));
        flights.add(new Flight(gdansk, krakow));
        flights.add(new Flight(krakow, wroclaw));
        flights.add(new Flight(wroclaw, gdansk));
        flights.add(new Flight(wroclaw, warszawa));
        flights.add(new Flight(krakow, warszawa));
        flights.add(new Flight(warszawa, gdansk));
    }

    public Set<Flight> getFlights() {
        return flights;
    }
}
