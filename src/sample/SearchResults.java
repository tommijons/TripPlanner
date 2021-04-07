package sample;

import javafx.collections.ObservableList;

public class SearchResults {
    Flight[] availableFlights;
    Hotel[] availableHotels;
    ObservableList<Tour> availableTours;
    TravelPackage cheapPackage;
    TravelPackage standardPackage;
    TravelPackage luxuryPackage;



    public SearchResults(Flight[] flights, Hotel[] hotels, ObservableList<Tour> tours,
                         TravelPackage cheapPackage, TravelPackage standardPackage, TravelPackage luxuryPackage) {
        availableFlights = flights;
        availableHotels = hotels;
        availableTours = tours;
        this.cheapPackage = cheapPackage;
        this.standardPackage = standardPackage;
        this.luxuryPackage = luxuryPackage;
    }

    public Flight[] getAvailableFlights() {
        return availableFlights;
    }

    public Hotel[] getAvailableHotels() {
        return availableHotels;
    }

    public ObservableList<Tour> getAvailableTours() {
        return availableTours;
    }

    public TravelPackage getCheapPackage() {
        return cheapPackage;
    }

    public TravelPackage getStandardPackage() {
        return standardPackage;
    }

    public TravelPackage getLuxuryPackage() {
        return luxuryPackage;
    }
}
