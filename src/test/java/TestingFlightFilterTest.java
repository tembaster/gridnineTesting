import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightFilter;
import com.gridnine.testing.service.TestingFlightFilter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;


class TestingFlightFilterTest {

    List<Flight> testFlights;
    FlightFilter flightFilter = new TestingFlightFilter();

    @BeforeEach
    void setUp() {
        testFlights = FlightTestData.getList();
    }

    @AfterEach
    void tearDown() {
        testFlights = null;
    }

    @Test
    public void departureBeforeRequestedDateExclude(){
        List<Flight> expected = new ArrayList<>(testFlights);
        List<Flight> actual = flightFilter.departureBeforeRequestedDateExclude(testFlights, FlightTestData.requestedDate);
        expected.remove(1);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void arrivalBeforeDepartureExclude() {
        List<Flight> expected = new ArrayList<>(testFlights);
        List<Flight> actual = flightFilter.arrivalBeforeDepartureExclude(testFlights);
        expected.remove(4);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void groundTimeMoreThanTwoHoursExclude() {
        List<Flight> expected = new ArrayList<>(testFlights);
        List<Flight> actual = flightFilter.groundTimeMoreThanTwoHoursExclude(testFlights);
        expected.remove(3);
        Assertions.assertIterableEquals(expected, actual);
    }
}