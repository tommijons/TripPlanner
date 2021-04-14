package sample;

import Flight.Flight;
import Hotel.Hotel;
import Tour.Tour;
import javafx.collections.ObservableList;

public class SearchResults {
    ObservableList<Flight> availableFlights;
    ObservableList<Flight> availableReturnFlights;
    ObservableList<Hotel> availableHotels;
    ObservableList<Tour> availableTours;
    TravelPackage cheapPackage;
    TravelPackage standardPackage;
    TravelPackage luxuryPackage;

    public SearchResults(ObservableList<Flight> flights, ObservableList<Flight> returnFlights,ObservableList<Hotel> hotels, ObservableList<Tour> tours,
                         TravelPackage cheapPackage, TravelPackage standardPackage, TravelPackage luxuryPackage) {
        availableFlights = flights;
        availableReturnFlights = returnFlights;
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
