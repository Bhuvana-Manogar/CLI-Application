package com.organisation.flightcli;

import com.organisation.flightcli.model.*;
import com.organisation.flightcli.repo.FlightRepository;
import com.organisation.flightcli.service.FlightService;
import java.time.LocalDateTime;
import java.util.Scanner;

public class FlightManagementApp {
    public static void main(String[] args) {
        FlightService service = new FlightService(new FlightRepository());
        Scanner sc = new Scanner(System.in);

        Airport jfk = new Airport("JFK", "John F. Kennedy", "New York");
        Airport lax = new Airport("LAX", "Los Angeles Intl", "Los Angeles");
        Airline delta = new Airline("DAL", "Delta Air Lines", "USA");

        service.registerFlight(new Flight("DL101", jfk, lax, delta, LocalDateTime.now().plusHours(3), "ON_TIME"));

        System.out.println(" Flight Management System ");
        while (true) {
            System.out.println("\n1. List All  2. Search Flight  3. Filter by Origin  4. Exit");
            System.out.print("> ");
            String choice = sc.nextLine();

            try {
                if (choice.equals("1")) {
                    service.getFlight("DL101"); // Simple trigger
                    System.out.println("Current Flights in System:");
                    service.getFlightsByOrigin("JFK").forEach(System.out::println);
                } else if (choice.equals("4")) break;
                else System.out.println("Feature pending API integration.");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
