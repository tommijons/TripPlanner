package sample;

public class SearchResults {
    Flight[] availableFlights;
    Hotel[] availableHotels;
    DayTrip[] availableDayTrips;
    TravelPackage cheapPackage;
    TravelPackage standardPackage;
    TravelPackage luxuryPackage;



    public SearchResults(Flight[] flights, Hotel[] hotels, DayTrip[] dayTrips,
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

    public DayTrip[] getAvailableDayTrips() {
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
