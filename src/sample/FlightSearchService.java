package sample;

import javafx.collections.ObservableList;

public interface FlightSearchService {
    public ObservableList<Flight> getFlights(String departureLocation, String arrivalLocation, String flightDate, Boolean mealService);
    public ObservableList<FlightSeat> getSeats(int flight_id);
}
