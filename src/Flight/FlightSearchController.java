package Flight;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FlightSearchController {

    private final FlightDataFactory dataFactory = new FlightDataFactory();
    public ObservableList<Flight> flightList = FXCollections.observableArrayList();
    ObservableList<String> Departure_LocationsList = FXCollections.observableArrayList("","REY","EGS","AEY","IFJ","VEY","KEF");
    ObservableList<String> Arrival_LocationsList = FXCollections.observableArrayList("","REY","EGS","AEY","IFJ","VEY","KEF");



    /**
     * Leitar af flugi eftir attributum
     * @param departureLocation brottfararstaður, departureLocation = null ef ekki á að leita eftir
     * @param arrivalLocation komustaður, arrivalLocation = null ef ekki á að leita eftir
     * @param flightDate dagsetning (ár-mánuður-dagur), flightDate = null ef ekki á að leita eftir
     * @param meal máltíð í flugi eða ekki, meal = null ef ekki á að leita eftir
     * @return listi af flugum
     */

    public ObservableList<Flight> searchByAttribute(String departureLocation, String arrivalLocation, String flightDate, Boolean meal) {
        String dep = departureLocation == null || departureLocation.equals("") ? "%" : departureLocation;
        String arr = arrivalLocation == null || arrivalLocation.equals("") ? "%" : arrivalLocation;
        String date = flightDate == null || flightDate.equals("") ? "%" : flightDate;
        return dataFactory.getFlights(dep, arr, date, meal);
    }



    public static void main(String[] args) {

        }
    }



