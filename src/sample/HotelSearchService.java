package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public interface HotelSearchService {
    public ObservableList<Hotel> getHotelSearchResults(ArrayList<Hotel> hotels, String location,
                                                              LocalDate selectedArrDate, LocalDate selectedDepDate,
                                                              int selectedNumOfGuests, int selectedNumOfRooms,
                                                              boolean threeStar, boolean fourStar, boolean fiveStar);

}
