package com.kodilla.good.patterns.challenges.flights.models;

import java.util.Objects;

public class Flight {

    private final City departure;
    private final City arrival;

    public Flight(City departure, City arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public City getDeparture() {
        return departure;
    }

    public City getArrival() {
        return arrival;
    }

    @Override
    public String toString() {
        return departure + " -> " + arrival;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(departure, flight.departure) && Objects.equals(arrival, flight.arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departure, arrival);
    }
}
