package sample;

public class TravelPackage {
    private Hotel hotel;
    private Flight flight;
    private Tour daytrip;

    public int getTotalPrice() {
        return totalPrice;
    }

    private int totalPrice;

    public TravelPackage(Hotel hotel, Flight flight, Tour daytrip){
        this.hotel = hotel;
        this.flight = flight;
        this.daytrip = daytrip;
        this.totalPrice = hotel.getPrice() + flight.getPrice() + daytrip.getTourPrice();
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

    public Tour getDaytrip() {
        return daytrip;
    }

    public void setDaytrip(Tour daytrip) {
        this.daytrip = daytrip;
    }

    @Override
    public String toString() {
        return "Travel Package";
    }
}
