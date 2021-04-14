package Tour;

import javafx.collections.ObservableList;


import java.time.LocalDate;
import java.util.ArrayList;

public interface TourSearchService {
    ObservableList<Tour> tours = null;

    public ArrayList<String> getTourEmailList(int tourID);
    public ObservableList<Tour> tourRegionSearch(String region, ObservableList<Tour> full);
    public ObservableList<Tour> tourServicesSearch(String services, ObservableList<Tour> full);
    public ObservableList<Tour> tourDurationSearch(int duration1, int duration2, ObservableList<Tour> full);
    public ObservableList<Tour> tourDateSearch(LocalDate startDate, LocalDate endDate, ObservableList<Tour> full);
    public boolean isFullyBooked(int tourID);
}
