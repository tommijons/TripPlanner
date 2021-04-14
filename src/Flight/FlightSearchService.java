package Flight;

import javafx.collections.ObservableList;
import sample.Seat;

public interface FlightSearchService {
    public ObservableList<Flight> getFlights(String departureLocation, String arrivalLocation, String flightDate, Boolean mealService);
    public ObservableList<Seat> getSeats(int flight_id);
}
