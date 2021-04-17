package tripPackage;

import Flight.Flight;
import Hotel.Hotel;
import Tour.Tour;
import Flight.Seat;
import javafx.collections.ObservableList;
import Hotel.*;

public class TravelPackage {
    private Hotel hotel;
    private Flight flight;
    private Flight returnFlight;
    private Tour daytrip;
    private ObservableList<Seat> seatsOut;
    private ObservableList<Seat> seatsHome;
    private ObservableList<Room> rooms;
    private int totalPrice;


    public TravelPackage(Hotel hotel, Flight flight, Flight returnFlight, Tour daytrip,ObservableList<Seat> seatsOut,ObservableList<Seat> seatsHome,ObservableList<Room> rooms){
        this.hotel = hotel;
        this.flight = flight;
        this.returnFlight = returnFlight;
        this.daytrip = daytrip;
        this.totalPrice = hotel.getHotel_base_price() + flight.getPrice() + returnFlight.getPrice() + daytrip.getTourPrice();
        this.seatsOut = seatsOut;
        this.seatsHome = seatsHome;
        this.rooms = rooms;
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

    public ObservableList<Seat> getSeatsOut() {
        return seatsOut;
    }

    public ObservableList<Seat> getSeatsHome() {
        return seatsHome;
    }

    public ObservableList<Room> getRooms() {
        return rooms;
    }

    @Override
    public String toString() {
        return "DEPARTURE FLIGHT: \n" + getFlight() + "\n"
                + "seats: " + getSeatsOut().size() + "\n\n"
                + "RETURN FLIGHT: \n" + getReturnFlight() + "\n"
                + "seats: " + getSeatsHome().size() + "\n\n"
                + "HOTEL \n" + getHotel() + "\n"
                + "Rooms: " + getRooms().size() + "\n\n"
                + "TOUR \n" + getDaytrip() + "\n\n"
                + "TOTAL PRICE \n" + getTotalPrice() + "\n\n";
    }
}
