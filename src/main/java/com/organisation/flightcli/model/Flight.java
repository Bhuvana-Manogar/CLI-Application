package com.organisation.flightcli.model;

import java.time.LocalDateTime;

public record Flight(String flightNumber, String origin, String destination,
                     LocalDateTime departureTime, String status) {

}
