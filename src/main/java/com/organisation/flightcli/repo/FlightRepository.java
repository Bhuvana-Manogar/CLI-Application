package com.organisation.flightcli.repo;

import com.organisation.flightcli.model.Flight;
import java.util.List;
import java.util.Optional;

public interface FlightRepository {
    void save(Flight flight);
    List<Flight> findAll();
    Optional<Flight> findByNumber(String flightNumber);
}
