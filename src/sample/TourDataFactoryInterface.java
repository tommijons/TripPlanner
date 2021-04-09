package sample;

import javafx.collections.ObservableList;

public interface TourDataFactoryInterface {
    ObservableList<User> getUsers(String email);

    ObservableList<Seat> getSeats(int tour_id);

    ObservableList<Tour> getTours(String departureLocation, String arrivalLocation, String tourDate, Boolean mealService);
}