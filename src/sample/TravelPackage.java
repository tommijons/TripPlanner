package sample;

import Flight.Flight;
import Hotel.Hotel;
import Tour.Tour;
import Flight.Seat;
import javafx.collections.ObservableList;


public class TravelPackage {
    private Hotel hotel;
    private Flight flight;
    private Flight returnFlight;
    private Tour daytrip;
    private ObservableList<Seat> seatsOut;
    private ObservableList<Seat> seatsHome;
    private int totalPrice;

    public TravelPackage(Hotel hotel, Flight flight, Flight returnFlight, Tour daytrip,ObservableList<Seat> seatsOut,ObservableList<Seat> seatsHome){
        this.hotel = hotel;
        this.flight = flight;
        this.returnFlight = returnFlight;
        this.daytrip = daytrip;
        this.totalPrice = hotel.getHotel_base_price() + flight.getPrice() + returnFlight.getPrice() + daytrip.getTourPrice();
        this.seatsOut = seatsOut;
        this.seatsHome = seatsHome;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Flight getReturnFlight() { return returnFlight; }

    public void setReturnFlight(Flight returnFlight) { this.returnFlight = returnFlight; }

    public Tour getDaytrip() {
        return daytrip;
    }

    public void setDaytrip(Tour daytrip) {
        this.daytrip = daytrip;
    }

    public int getTotalPrice() { return totalPrice; }

    @Override
    public String toString() {
        return "Flug út: " + getFlight() + "\n"
                + "Flug heim: " + getReturnFlight() + "\n"
                + "Hótel " + getHotel() + "\n"
                + "Dagsferð " + getDaytrip() + "\n"
                + "Verð " + getTotalPrice() + "\n";
    }
}
