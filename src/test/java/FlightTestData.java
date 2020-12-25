import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.time.LocalDateTime.of;

public class FlightTestData {

    public static final LocalDateTime requestedDate = of(2020,12,25,15,00);

    public static final Segment seg1 = new Segment(of(2020,12,25,16,00),
            of(2020,12,25,18,00));

    public static final Segment seg2 = new Segment(of(2020,12,23,13,00),
            of(2020,12,25,18,00));

    public static final Segment seg3 = new Segment(of(2020,12,25,16,00),
            of(2020,12,25,18,00));

    public static final Segment seg4 = new Segment(of(2020,12,25,19,00),
            of(2020,12,25,23,00));

    public static final Segment seg5 = new Segment(of(2020,12,26,01,00),
            of(2020,12,26,10,00));

    public static final Segment seg6 = new Segment(of(2020,12,25,16,00),
            of(2020,12,25,11,00));

    /* normal case */
    public static final Flight flight1 = new Flight(Arrays.asList(seg1));

    /* departure date is before requested date */
    public static final Flight flight2 = new Flight(Arrays.asList(seg2));

    /* normal case, 2 segments*/
    public static final Flight flight3 = new Flight(Arrays.asList(seg3, seg4));

    /* ground time is more than 2 hours */
    public static final Flight flight4 = new Flight(Arrays.asList(seg3, seg4, seg5));

    /* arrival dateTime is before departure dateTime */
    public static final Flight flight5 = new Flight(Arrays.asList(seg6));

    public static List<Flight> getList() {
        return Arrays.asList(flight1,flight2,flight3,flight4,flight5);
    }

}
