package sample;

import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.Date;

public interface TourSearchService {
    ObservableList<Tour> tours = null;

    public ArrayList<String> getTourEmailList(int tourID);
    public ObservableList<Tour> tourRegionSearch(String region, ObservableList<Tour> full);
    public ObservableList<Tour> tourServicesSearch(String services, ObservableList<Tour> full);
    public ObservableList<Tour> tourDurationSearch(int duration1, int duration2, ObservableList<Tour> full);
    public ObservableList<Tour> tourDateSearch(Date startDate, Date endDate, ObservableList<Tour> full);
    public boolean isFullyBooked(int tourID);
}