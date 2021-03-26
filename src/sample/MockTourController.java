package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class MockTourController implements TourSearchService {
    ObservableList<Tour> tours = null;

    public ArrayList<String> getTourEmailList(int tourID) {
        ArrayList<String> results = new ArrayList<String>();
        results.add("tester@testing.test");
        return results;
    }

    public ObservableList<Tour> tourRegionSearch(String region, ObservableList<Tour> tours) {
        ObservableList<Tour> results = FXCollections.observableArrayList();
        results.add(new Tour(
                "Horseriding in " + region,"Bring warm clothes",
                LocalDate.of(2020, 7, 7), 10,10000, region,
                7,"Family friendly"));
        return results;
    }

    public ObservableList<Tour> tourServicesSearch(String services, ObservableList<Tour> tours) {
        ObservableList<Tour> results = FXCollections.observableArrayList();
        results.add(new Tour(
                "Horseriding in Eyjafjörður","Bring warm clothes",
                LocalDate.of(2020, 7, 7), 10,10000, "Akureyri",
                7,services));
        return results;
    }

    public ObservableList<Tour> tourDurationSearch(int duration1, int duration2, ObservableList<Tour> tours) {
        ObservableList<Tour> results = FXCollections.observableArrayList();
        results.add(new Tour(
                "Horseriding in Eyjafjörður","Bring warm clothes",
                LocalDate.of(2020, 7, 7), 10,10000, "Akureyri",
                (duration1+duration2)/2,"Family friendly"));
        return results;
    }
    public ObservableList<Tour> tourDateSearch(Date startDate, Date endDate, ObservableList<Tour> tours) {
        ObservableList<Tour> results = FXCollections.observableArrayList();
        results.add(new Tour(
                "Horseriding in Eyjafjörður","Bring warm clothes",
                LocalDate.of(startDate.getYear(),startDate.getMonth(), startDate.getDay()), 10,10000, "Akureyri",
                new Date(endDate.getTime() - startDate.getTime()).getHours(),"Family friendly"));
        return results;
    }
    public boolean isFullyBooked(int tourID){
        return tourID != 0;
    }
}
