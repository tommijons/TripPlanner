package Tour;

import javafx.collections.ObservableList;
import sample.User;

import java.time.LocalDate;

public interface TourDataFactoryInterface {
    ObservableList<User> getUsers(String email);

    //ObservableList<Seat> getSeats(int tour_id);

    ObservableList<Tour> getTours(String region, int duration1, int duration2, String service, LocalDate startDate, LocalDate endDate);
}