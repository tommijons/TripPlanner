package Flight;

import javafx.collections.ObservableList;
import sample.User;

public interface FlightDataFactoryInterface {
    ObservableList<User> getUsers(String email);

    ObservableList<Seat> getSeats(int flight_id);

    ObservableList<Flight> getFlights(String departureLocation, String arrivalLocation, String flightDate, Boolean mealService);
}