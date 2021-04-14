package Hotel;

import Hotel.Hotel;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public interface HotelSearchService {
    public ObservableList<Hotel> getHotelSearchResults(ArrayList<Hotel> hotels, String location,
                                                       LocalDate selectedArrDate, LocalDate selectedDepDate,
                                                       int selectedNumOfGuests, int selectedNumOfRooms,
                                                       boolean threeStar, boolean fourStar, boolean fiveStar);

}
