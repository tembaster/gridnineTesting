package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightFilter;
import com.gridnine.testing.service.TestingFlightFilter;
import com.gridnine.testing.util.ConsoleHelper;
import com.gridnine.testing.util.FlightBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Flight> flights = FlightBuilder.createFlights();
        ConsoleHelper.printFlights(flights);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FlightFilter flightFilter = new TestingFlightFilter();
        while(true) {
            String input = br.readLine();
            if (input.equals("1")) {
                ConsoleHelper.printFlights(flightFilter.departureBeforeRequestedDateExclude(flights, LocalDateTime.now()));
            }
            if (input.equals("2")) {
                ConsoleHelper.printFlights(flightFilter.arrivalBeforeDepartureExclude(flights));
            }
            if (input.equals("3")) {
                ConsoleHelper.printFlights(flightFilter.groundTimeMoreThanTwoHoursExclude(flights));
            } if (input.equals("4")) {
                br.close();
                return;
            }
        }
    }
}