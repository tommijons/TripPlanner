package sample;

import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.Date;

public interface TourSearchService {
    public ArrayList<String> getTourEmailList(int tourID);
    public ObservableList<Tour> tourRegionSearch(String region);
    public ObservableList<Tour> tourServicesSearch(String services);
    public ObservableList<Tour> tourDurationSearch(int duration);
    public ObservableList<Tour> tourDateSearch(Date startDate, Date endDate);
    public boolean isFullyBooked(int tourID);
}
