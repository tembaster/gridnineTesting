package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightFilter {

    List<Flight> departureBeforeRequestedDateExclude(List<Flight> flights, LocalDateTime requestedDate);

    List<Flight> arrivalBeforeDepartureExclude(List<Flight> flights);

    List<Flight> groundTimeMoreThanTwoHoursExclude(List<Flight> flights);
}
