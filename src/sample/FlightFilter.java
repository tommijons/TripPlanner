package sample;

import java.time.LocalDate;
import java.util.Date;

public class FlightFilter {
    private String departureLocation;
    private String arrivalLocation;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private boolean meal;

    public FlightFilter(String depLoc, String arrLoc, LocalDate d, LocalDate r , boolean m) {
        departureLocation = depLoc;
        arrivalLocation = arrLoc;
        departureDate = d;
        returnDate = r;
        meal = m;
    }

    @Override
    public String toString() {
        return "FlightFilter{" +
                "departureLocation='" + departureLocation + '\'' +
                ", arrivalLocation='" + arrivalLocation + '\'' +
                ", departureDate=" + departureDate +
                ", returnDate=" + returnDate +
                ", meal=" + meal +
                '}';
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isMeal() {
        return meal;
    }

    public void setMeal(boolean meal) {
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


}
