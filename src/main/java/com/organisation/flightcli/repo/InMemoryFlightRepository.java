package com.organisation.flightcli.repo;

import com.organisation.flightcli.model.Flight;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryFlightRepository implements FlightRepository {
    private final List<Flight> database = new ArrayList<>();

    @Override
    public void save(Flight flight) {
        database.removeIf(f -> f.flightNumber().equalsIgnoreCase(flight.flightNumber()));
        database.add(flight);
    }

    @Override
    public List<Flight> findAll() { return new ArrayList<>(database); }

    @Override
    public Optional<Flight> findByNumber(String flightNumber) {
        return database.stream()
                .filter(f -> f.flightNumber().equalsIgnoreCase(flightNumber))
                .findFirst();
    }
}
