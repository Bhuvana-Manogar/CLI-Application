package com.organisation.flightcli.repo;
import com.organisation.flightcli.model.*;
import java.util.*;

public class FlightRepository implements CrudRepository<Flight, String> {
    private final Map<String, Flight> storage = new HashMap<>();
    public void save(Flight f) { storage.put(f.flightNumber(), f); }
    public Optional<Flight> findById(String id) { return Optional.ofNullable(storage.get(id)); }
    public List<Flight> findAll() { return new ArrayList<>(storage.values()); }
}
