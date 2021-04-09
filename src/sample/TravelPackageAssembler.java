package sample;

import javafx.collections.ObservableList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TravelPackageAssembler {
    private ObservableList<Flight> availableFlights;
    private ObservableList<Hotel> availableHotels;
    private ObservableList<Tour> availableDayTrips;
    private TravelPackageController tpc;

    public ObservableList<Flight> getAvailableFlights() {
        return availableFlights;
    }

    public void setAvailableFlights(ObservableList<Flight> availableFlights) {
        this.availableFlights = availableFlights;
    }

    public ObservableList<Hotel> getAvailableHotels() {
        return availableHotels;
    }

    public void setAvailableHotels(ObservableList<Hotel> availableHotels) {
        this.availableHotels = availableHotels;
    }

    public ObservableList<Tour> getAvailableDayTrips() {
        return availableDayTrips;
    }

    public void setAvailableDayTrips(ObservableList<Tour> availableDayTrips) {
        this.availableDayTrips = availableDayTrips;
    }

    public TravelPackageAssembler(ObservableList<Flight> flights, ObservableList<Hotel> hotels, ObservableList<Tour> tours) {
        Collections.copy(availableFlights, flights);
        Collections.copy(availableHotels, hotels);
        Collections.copy(availableDayTrips, tours);
        SortByPrice();
    }

    private void SortByPrice(){
        Collections.sort(availableFlights, Comparator.comparingInt(Flight::getPrice));
        Collections.sort(availableHotels, Comparator.comparingInt(Hotel::getHotel_base_price));
        Collections.sort(availableDayTrips, Comparator.comparingInt(Tour::getTourPrice));
    }
    public TravelPackage getCheapPackage() {
        return tpc.createCheapPackage(availableHotels,availableFlights,availableDayTrips);
    }
    public TravelPackage getStandardPackage() {
        return tpc.createStandardPackage(availableHotels,availableFlights,availableDayTrips);
    }
    public TravelPackage getLuxuryPackage() {
        return tpc.createLuxuryPackage(availableHotels,availableFlights,availableDayTrips);
    }
}
