package com.organisation.flightcli.service;

import com.organisation.flightcli.model.*;
import com.organisation.flightcli.repo.FlightRepository;
import com.organisation.flightcli.exception.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {
    private final FlightRepository flightRepo;

    public FlightService(FlightRepository flightRepo) {
        this.flightRepo = flightRepo;
    }

    public void registerFlight(Flight flight) {
        flightRepo.save(flight);
    }

    public List<Flight> getFlightsByOrigin(String iataCode) {
        return flightRepo.findAll().stream()
                .filter(f -> f.origin().iataCode().equalsIgnoreCase(iataCode))
                .collect(Collectors.toList());
    }

    public Flight getFlight(String flightNo) {
        return flightRepo.findById(flightNo)
                .orElseThrow(() -> new EntityNotFoundException("Flight " + flightNo + " not found."));
    }
}
