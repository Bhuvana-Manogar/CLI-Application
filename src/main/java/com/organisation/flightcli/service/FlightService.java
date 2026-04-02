package com.organisation.flightcli.service;

import com.organisation.flightcli.model.Flight;
import com.organisation.flightcli.repo.FlightRepository;
import com.organisation.flightcli.exception.FlightNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {
    private final FlightRepository repository;

    public FlightService(FlightRepository repository) {
        this.repository = repository;
    }

    public List<Flight> getAllFlights() {
        return repository.findAll();
    }

    public Flight getFlightDetails(String flightNumber) {
        return repository.findByNumber(flightNumber)
                .orElseThrow(() -> new FlightNotFoundException("Flight " + flightNumber + " not found."));
    }

    public List<Flight> filterByRoute(String origin, String destination) {
        return repository.findAll().stream()
                .filter(f -> f.origin().equalsIgnoreCase(origin) && f.destination().equalsIgnoreCase(destination))
                .collect(Collectors.toList());
    }

    public void syncFlightData(Flight flight) {
        repository.save(flight);
    }
}
