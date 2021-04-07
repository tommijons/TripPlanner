package sample;

import javafx.collections.ObservableList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TravelPackageAssembler {
    private Flight[] availableFlights;
    private Hotel[] availableHotels;
    private ObservableList<Tour> availableDayTrips;
    private TravelPackageController tpc;

    public Flight[] getAvailableFlights() {
        return availableFlights;
    }

    public void setAvailableFlights(Flight[] availableFlights) {
        this.availableFlights = availableFlights;
    }

    public Hotel[] getAvailableHotels() {
        return availableHotels;
    }

    public void setAvailableHotels(Hotel[] availableHotels) {
        this.availableHotels = availableHotels;
    }

    public ObservableList<Tour> getAvailableDayTrips() {
        return availableDayTrips;
    }

    public void setAvailableDayTrips(ObservableList<Tour> availableDayTrips) {
        this.availableDayTrips = availableDayTrips;
    }

    public TravelPackageAssembler(Flight[] flights, Hotel[] hotels, ObservableList<Tour> tours) {
        availableFlights = flights.clone();
        availableHotels = hotels.clone();
        Collections.copy(availableDayTrips, tours);
        SortByPrice();
    }

    private void SortByPrice(){
        Arrays.sort(availableFlights, Comparator.comparingInt(Flight::getPrice));
        Arrays.sort(availableHotels, Comparator.comparingInt(Hotel::getHotel_base_price));
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
