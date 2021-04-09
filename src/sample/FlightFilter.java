package sample;

import java.time.LocalDate;
import java.util.Date;

public class FlightFilter {
    private String departureLocation;
    private String arrivalLocation;
    private LocalDate DepartureDate;
    private LocalDate ReturnDate;
    private Boolean meal;
    public FlightFilter(String departureLocation, String arrivalLocation, LocalDate DepartureDate, LocalDate ReturnDate, Boolean meal) {
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.DepartureDate = DepartureDate;
        this.ReturnDate = ReturnDate;
        this.meal = meal;
    }
    /*

    public FlightFilter() {
        // TODO get rid.
        departureLocation = "Rey";
        arrivalLocation = "Ak";
        DepartureDate = "10/01/21";
        returnDate = "10/01/21";
        meal = true;
    }*/


    public String getDepartureLocation() {
        return departureLocation;
    }

    public LocalDate getDepartureDate() { return DepartureDate; }

    public LocalDate getReturnDate() { return ReturnDate; }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public Boolean getMeal() {
        return meal;
    }
}
