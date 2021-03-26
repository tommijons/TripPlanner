package sample;

import javafx.collections.ObservableList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TravelPackageAssembler {
    private Flight[] availableFlights;
    private Hotel[] availableHotels;
    private ObservableList<Tour> availableTours;
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

    public ObservableList<Tour> getAvailableTours() {
        return availableTours;
    }

    public void setAvailableTours(ObservableList<Tour> availableTours) {
        this.availableTours = availableTours;
    }

    public TravelPackageAssembler(Flight[] flights, Hotel[] hotels, ObservableList<Tour> tours) {
        this.availableFlights = flights;
        this.availableHotels = hotels;
        this.availableTours = tours;
        SortByPrice();
    }

    private void SortByPrice(){
        Arrays.sort(availableFlights, Comparator.comparingInt(Flight::getPrice));
        Arrays.sort(availableHotels, Comparator.comparingInt(Hotel::getPrice));
        Collections.sort(availableTours, Comparator.comparingInt(Tour::getTourPrice));
    }
    public TravelPackage getCheapPackage() {
        return tpc.createCheapPackage(availableHotels,availableFlights, availableTours);
    }
    public TravelPackage getStandardPackage() {
        return tpc.createStandardPackage(availableHotels,availableFlights, availableTours);
    }
    public TravelPackage getLuxuryPackage() {
        return tpc.createLuxuryPackage(availableHotels,availableFlights, availableTours);
    }
}
