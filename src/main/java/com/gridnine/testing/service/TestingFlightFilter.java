package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestingFlightFilter implements FlightFilter {

    public List<Flight> departureBeforeRequestedDateExclude(List<Flight> flights, LocalDateTime requestedDate) {
        List<Flight> result = new ArrayList<>(flights);
        for (Flight flight : flights) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getDepartureDate().isBefore(requestedDate)) {
                    result.remove(flight);
                }
            }
        }
        return result;
    }

    public List<Flight> arrivalBeforeDepartureExclude(List<Flight> flights) {
        List<Flight> result = new ArrayList<>(flights);
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            for (Segment segment : segments) {
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                    result.remove(flight);
                }
            }
        }
        return result;
    }

    public List<Flight> groundTimeMoreThanTwoHoursExclude(List<Flight> flights) {
        List<Flight> result = new ArrayList<>(flights);
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            int groundTime = 0;
            if (segments.size() > 1) {
                for (int i = 0; i < segments.size() - 1; i++) {
                    groundTime += Math.abs(Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate()).toHours());
                }
                if (groundTime > 2) {
                    result.remove(flight);
                }
            }
        }
        return result;
    }
}