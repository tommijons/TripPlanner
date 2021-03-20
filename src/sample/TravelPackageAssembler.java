package sample;

import java.util.Arrays;
import java.util.Comparator;

public class TravelPackageAssembler {
    private Flight[] availableFlights;
    private Hotel[] availableHotels;
    private DayTrip[] availableDayTrips;
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

    public DayTrip[] getAvailableDayTrips() {
        return availableDayTrips;
    }

    public void setAvailableDayTrips(DayTrip[] availableDayTrips) {
        this.availableDayTrips = availableDayTrips;
    }

    public TravelPackageAssembler(Flight[] flights, Hotel[] hotels, DayTrip[] daytrips) {
        availableFlights = flights.clone();
        availableHotels = hotels.clone();
        availableDayTrips = daytrips.clone();
        SortByPrice();
    }

    private void SortByPrice(){
        Arrays.sort(availableFlights, Comparator.comparingInt(Flight::getPrice));

        Arrays.sort(availableHotels, Comparator.comparingInt(Hotel::getPrice));

        Arrays.sort(availableDayTrips, Comparator.comparingInt(DayTrip::getPrice));
    }

    public TravelPackage getCheapPackage() {
        //TODO: use TravelPackageController to create packages
        return new TravelPackage(availableHotels[0], availableFlights[0], availableDayTrips[0]);
    }

    public TravelPackage getStandardPackage() {
        //TODO: use TravelPackageController to create packages
        return new TravelPackage(availableHotels[Math.floorDiv(availableHotels.length, 2)],
                availableFlights[Math.floorDiv(availableFlights.length, 2)],
                availableDayTrips[Math.floorDiv(availableDayTrips.length, 2)]);
    }

    public TravelPackage getLuxuryPackage() {
        //TODO: use TravelPackageController to create packages
        return new TravelPackage(availableHotels[availableHotels.length - 1],
                availableFlights[availableFlights.length - 1],
                availableDayTrips[availableDayTrips.length - 1]);
    }
}
