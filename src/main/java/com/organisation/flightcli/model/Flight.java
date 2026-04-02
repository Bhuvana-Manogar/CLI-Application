package com.organisation.flightcli.model;
import java.time.LocalDateTime;

public record Flight(
    String flightNumber, 
    Airport origin, 
    Airport destination, 
    Airline airline, 
    LocalDateTime departureTime, 
    String status
) {}
