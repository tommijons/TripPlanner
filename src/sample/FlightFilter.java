package sample;

import java.util.Date;

public class FlightFilter {
    private String departureLocation;
    private String arrivalLocation;
    private String flightDate;
    private Boolean meal;
    public FlightFilter(String departureLocation, String arrivalLocation, String flightDate, Boolean meal) {
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.flightDate = flightDate;
        this.meal = meal;
    }

    public FlightFilter() {
        // TODO get rid.
        departureLocation = "Rey";
        arrivalLocation = "Ak";
        flightDate = "10/01/21";
        meal = true;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public Boolean getMeal() {
        return meal;
    }
}
