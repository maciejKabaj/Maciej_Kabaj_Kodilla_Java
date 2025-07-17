package com.kodilla.good.patterns.challenges.flights;

import com.kodilla.good.patterns.challenges.flights.models.City;
import com.kodilla.good.patterns.challenges.flights.repository.FlightRepository;
import com.kodilla.good.patterns.challenges.flights.service.FlightSearchService;

public class ApplicationFlights {
    public static void main(String[] args) {
        FlightRepository flightRepository = new FlightRepository();
        FlightSearchService flightSearchService = new FlightSearchService(flightRepository.getFlights());
        City gdansk = new City("Gdansk");
        City wroclaw = new City("Wroclaw");
        City krakow = new City("Krakow");
        City warszawa = new City("Warszawa");

        System.out.println("Flight list to cities:");
        System.out.println(flightSearchService.findFlightsTo(gdansk));
        System.out.println(flightSearchService.findFlightsTo(wroclaw));
        System.out.println(flightSearchService.findFlightsTo(krakow));
        System.out.println(flightSearchService.findFlightsTo(warszawa));

        System.out.println("\nFlight list from cities:");
        System.out.println(flightSearchService.findFlightsFrom(gdansk));
        System.out.println(flightSearchService.findFlightsFrom(wroclaw));
        System.out.println(flightSearchService.findFlightsFrom(krakow));
        System.out.println(flightSearchService.findFlightsFrom(warszawa));

        System.out.println("\nFlight list of indirect routes:");
        System.out.println(flightSearchService.findAllFlightsWithStopover(gdansk, warszawa));
        System.out.println(flightSearchService.findAllFlightsWithStopover(wroclaw, krakow));
    }
}