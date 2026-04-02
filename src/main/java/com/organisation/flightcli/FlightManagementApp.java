package com.organisation.flightcli;

import com.organisation.flightcli.model.Flight;
import com.organisation.flightcli.repo.InMemoryFlightRepository;
import com.organisation.flightcli.service.FlightService;
import java.time.LocalDateTime;
import java.util.Scanner;

public class FlightManagementApp {
    public static void main(String[] args) {
        FlightService service = new FlightService(new InMemoryFlightRepository());
        Scanner scanner = new Scanner(System.in);

        service.syncFlightData(new Flight("AA123", "chennai", "bangalore", LocalDateTime.now(), "SCHEDULED"));
        service.syncFlightData(new Flight("BA456", "delhi", "hyderabad", LocalDateTime.now(), "DELAYED"));
        service.syncFlightData(new Flight("BA756", "mumbai", "bangalore", LocalDateTime.now(), "AVAILABLE"));
        service.syncFlightData(new Flight("BC456", "delhi", "hyderabad", LocalDateTime.now(), "AVAILABLE"));
        service.syncFlightData(new Flight("SA456", "trichy", "chennai", LocalDateTime.now(), "DELAYED"));

        System.out.println("Airline CLI System");
        
        while (true) {
            System.out.println("\nCommands: list, search [no], filter [from] [to], exit");
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ");

            try {
                switch (parts[0].toLowerCase()) {
                    case "list" -> service.getAllFlights().forEach(System.out::println);
                    case "search" -> System.out.println(service.getFlightDetails(parts[1]));
                    case "filter" -> service.filterByRoute(parts[1], parts[2]).forEach(System.out::println);
                    case "exit" -> System.exit(0);
                    default -> System.out.println("Unknown command.");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
