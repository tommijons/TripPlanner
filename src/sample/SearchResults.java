package sample;

public class SearchResults {
    Flight[] availableFlights;
    Hotel[] availableHotels;
    Tour[] availableDayTrips;
    TravelPackage cheapPackage;
    TravelPackage standardPackage;
    TravelPackage luxuryPackage;



    public SearchResults(Flight[] flights, Hotel[] hotels, Tour[] dayTrips,
                         TravelPackage cheapPackage, TravelPackage standardPackage, TravelPackage luxuryPackage) {
        availableFlights = flights;
        availableHotels = hotels;
        availableDayTrips = dayTrips;
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

    public Tour[] getAvailableDayTrips() {
        return availableDayTrips;
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
