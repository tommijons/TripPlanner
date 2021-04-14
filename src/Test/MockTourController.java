package Test;

import Tour.Tour;
import Tour.TourSearchService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.time.LocalDate;
import java.util.ArrayList;

public class MockTourController implements TourSearchService {
    ObservableList<Tour> tours = null;


    public MockTourController(ObservableList<Tour> tours) {
        this.tours = tours;
    }

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
                "Horseriding in Eyjafjörður A","Bring warm clothes",
                LocalDate.of(2020, 7, 7), 3,10000, "Akureyri",
                (duration1+duration2)/2,"Family friendly"));
        results.add(new Tour(
                "Horseriding in Eyjafjörður B","Bring warm clothes",
                LocalDate.of(2020, 7, 7), 3,20000, "Akureyri",
                (duration1+duration2)/2,"Family friendly"));
        results.add(new Tour(
                "Horseriding in Eyjafjörður C","Bring warm clothes",
                LocalDate.of(2020, 7, 7), 1,10000, "Akureyri",
                (duration1+duration2)/2,"Family friendly"));
        return results;
    }
    public ObservableList<Tour> tourDateSearch(LocalDate startDate, LocalDate endDate, ObservableList<Tour> tours) {
        ObservableList<Tour> results = FXCollections.observableArrayList();
        results.add(new Tour(
                "Horseriding in Eyjafjörður","Bring warm clothes",
                LocalDate.of(startDate.getYear(),startDate.getMonth(), startDate.getDayOfMonth()), 10,10000, "Akureyri",
                10,"Family friendly"));
        return results;
    }

    public boolean isFullyBooked(int tourID){
        return tourID != 0;
    }
}
