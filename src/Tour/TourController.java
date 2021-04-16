package Tour;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tripPackage.User;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;


public class TourController {
    private TourDataFactory tourdataFactory = new TourDataFactory();
    private ObservableList<Tour> tours= tourdataFactory.getTours();

    public long localDateToMillis (LocalDate value){
        Instant i = value.atStartOfDay(ZoneId.systemDefault()).toInstant();
        long timeInMillis = i.toEpochMilli();

        return timeInMillis;
    }

    public void changesSpotsAfterBooking(Tour tour, int spots){
        int newAvailableSpots= tour.getAvailableSpots()-spots;
        tourdataFactory.updateSpotsForTour(tour.getTourID(),newAvailableSpots);
    }
    public void changesSpotsAfterDeleteBooking(Tour tour, int spots){
        int newAvailableSpots= tour.getAvailableSpots() +spots;
        tourdataFactory.updateSpotsForTour(tour.getTourID(),newAvailableSpots);
    }

    public Tour findTourByID(int ID){
        ObservableList<Tour> tours= tourdataFactory.getTours();
        Tour theTour = null;
        for (Tour tour: tours){
            if (tour.getTourID()==ID){
                theTour=tour;
            }
        }
        return theTour;
    }

    public void addTour(Tour tour) {
        long millis = localDateToMillis(tour.getTourDate());
        tourdataFactory.insertTour(tour.getTourName(),
                tour.getTourInfo(), tour.getAvailableSpots(),tour.getTourPrice(),
                tour.getTourRegion(), tour.getDuration(), tour.getServices(),
                millis);
    }

    public void deleteTour(int tourID) {
        tourdataFactory.deleteTour(tourID);
    }

    public Boolean isFullyBooked(int tourID){
        boolean isFull=false;
        for (Tour tour: tours){
            if (tour.getTourID()==tourID){
                if(tour.getAvailableSpots()<=0)
                    isFull=true;
            }
        }
        return isFull;
    }

    public ObservableList<Tour> tourRegionSearch(String region) {
        ObservableList<Tour> result = FXCollections.observableArrayList();
        tours.forEach((tab) -> {
            if (tab.getTourRegion().equals(region)){
                result.add(tab);}});
        return  result;}

    public ObservableList<Tour> tourDurationSearch(int duration1, int duration2, ObservableList<Tour> full) {
        ObservableList<Tour> result = FXCollections.observableArrayList();
        for (Tour tour : full) {
            if (tour.getDuration() >= duration1 && tour.getDuration() <= duration2 ) {
                result.add(tour);
            }
        }
        return result;
    }

    public ObservableList<Tour> tourServicesSearch(String service, ObservableList<Tour> full) {
        ObservableList<Tour> result = FXCollections.observableArrayList();
        for (Tour tour : full) {
            if (tour.getServices().contains(service)) {
                result.add(tour);
            }
        }
        return result;
    }

    public ObservableList<Tour> tourDateSearch(LocalDate startDate, LocalDate endDate, ObservableList<Tour> full) {
        ObservableList<Tour> result = FXCollections.observableArrayList();
        for (Tour tour : full) {
            if (tour.getTourDate().isAfter(startDate) && tour.getTourDate().isBefore(endDate)) {
                result.add(tour);
            }
        }
        return result;
    }
    public ArrayList<User> getTourEmailList(int tourID){
        ArrayList<User> users = new ArrayList<>();
        ObservableList<Booking> bookings= tourdataFactory.getBookings();
        for (Booking booking : bookings){
            if (booking.getTour().getTourID()==tourID){
                users.add(booking.getUser());
            }
        }
        return users;
    }

    public Tour findTourByName(String tourName){
        Tour theTour =null;
        ObservableList<Tour> tour= tourdataFactory.getTours();
        for (Tour t: tour){
            if (t.getTourName().equals(tourName)){
                theTour=t;
            }
        }
        return theTour;
    }
}