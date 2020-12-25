package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightFilter;
import com.gridnine.testing.service.TestingFlightFilter;
import com.gridnine.testing.util.FlightBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Flight> flights = FlightBuilder.createFlights();
        printFlights(flights);
        String vars = "123";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FlightFilter flightFilter = new TestingFlightFilter();
        for(String input = br.readLine(); vars.contains(input); input = br.readLine()) {
            if (input.equals("1")) {
                printFlights(flightFilter.departureBeforeRequestedDateExclude(flights, LocalDateTime.now()));
            }

            if (input.equals("2")) {
                printFlights(flightFilter.arrivalBeforeDepartureExclude(flights));
            }

            if (input.equals("3")) {
                printFlights(flightFilter.groundTimeMoreThanTwoHoursExclude(flights));
            }
        }
        br.close();
    }

    static void printFlights(List<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println(flight);
            System.out.println("-----");
        }
        System.out.println("Выберите фильтр:\n1 - Исключить из списка вылет до текущего момента времени\n" +
                "2 - Исключить из списка полёты, где имеются сегменты с датой прилёта раньше даты вылета\n" +
                "3 - Исключить из списка полёты, при которых общее время, проведённое на земле превышает два часа");
    }
}