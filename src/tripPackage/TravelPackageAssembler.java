package tripPackage;

import Flight.*;
import Hotel.Hotel;
import Tour.Tour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

// No longer used
public class TravelPackageAssembler {
    private ObservableList<Flight> availableFlights;
    private ObservableList<Flight> availableReturnFlights;
    private ObservableList<Hotel> availableHotels;
    private ObservableList<Tour> availableDayTrips;
    private int travellers;
    private int rooms;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private TravelPackageController tpc = new TravelPackageController();
    FlightDataFactory fdf;

    public ObservableList<Flight> getAvailableFlights() {
        return availableFlights;
    }

    public void setAvailableFlights(ObservableList<Flight> availableFlights) {
        this.availableFlights = availableFlights;
    }

    public ObservableList<Flight> getAvailableReturnFlights() {
        return availableReturnFlights;
    }

    public void setAvailableReturnFlights(ObservableList<Flight> availableReturnFlights) {
        this.availableReturnFlights = availableReturnFlights;
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

    public TravelPackageAssembler(ObservableList<Flight> flights, ObservableList<Flight> returnFlights, ObservableList<Hotel> hotels, ObservableList<Tour> tours, int travellers, int rooms, LocalDate checkIn,LocalDate checkOut, FlightDataFactory fdf) {
        availableFlights = FXCollections.observableArrayList();
        availableReturnFlights = FXCollections.observableArrayList();
        availableHotels = FXCollections.observableArrayList();
        availableDayTrips = FXCollections.observableArrayList();
        availableFlights.addAll(flights);
        availableReturnFlights.addAll(returnFlights);
        availableHotels.addAll(hotels);
        availableDayTrips.addAll(tours);
        this.fdf = fdf;
        this.travellers = travellers;
        this.rooms = rooms;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        //SortByPrice();
    }

  /*  private void SortByPrice(){
        Collections.sort(availableFlights, Comparator.comparingInt(Flight::getPrice));
        Collections.sort(availableReturnFlights, Comparator.comparingInt(Flight::getPrice));
        Collections.sort(availableHotels, Comparator.comparingInt(Hotel::getHotel_base_price));
        Collections.sort(availableDayTrips, Comparator.comparingInt(Tour::getTourPrice));
    }*/

    public TravelPackage getCheapPackage() {
        return tpc.createCheapPackage(availableHotels,availableFlights, availableReturnFlights,availableDayTrips,travellers,rooms,checkIn,checkOut,fdf);
    }

    public TravelPackage getStandardPackage() {
        return tpc.createStandardPackage(availableHotels,availableFlights,availableReturnFlights,availableDayTrips,travellers,rooms,checkIn,checkOut,fdf);
    }

    public TravelPackage getLuxuryPackage() {
        return tpc.createLuxuryPackage(availableHotels,availableFlights,availableReturnFlights,availableDayTrips,travellers,rooms,checkIn,checkOut,fdf);
    }
}
