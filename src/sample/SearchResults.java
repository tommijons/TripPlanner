package sample;

import javafx.collections.ObservableList;

public class SearchResults {
    ObservableList<Flight> availableFlights;
    ObservableList<Hotel> availableHotels;
    ObservableList<Tour> availableTours;
    TravelPackage cheapPackage;
    TravelPackage standardPackage;
    TravelPackage luxuryPackage;



    public SearchResults(ObservableList<Flight> flights, ObservableList<Hotel> hotels, ObservableList<Tour> tours,
                         TravelPackage cheapPackage, TravelPackage standardPackage, TravelPackage luxuryPackage) {
        availableFlights = flights;
        availableHotels = hotels;
        availableTours = tours;
        this.cheapPackage = cheapPackage;
        this.standardPackage = standardPackage;
        this.luxuryPackage = luxuryPackage;
    }

    public ObservableList<Flight> getAvailableFlights() {
        return availableFlights;
    }

    public ObservableList<Hotel> getAvailableHotels() {
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
