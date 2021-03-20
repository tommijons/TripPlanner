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
        return tpc.createCheapPackage(availableHotels,availableFlights,availableDayTrips);
    }
    public TravelPackage getStandardPackage() {
        return tpc.createStandardPackage(availableHotels,availableFlights,availableDayTrips);
    }
    public TravelPackage getLuxuryPackage() {
        return tpc.createLuxuryPackage(availableHotels,availableFlights,availableDayTrips);
    }
}
