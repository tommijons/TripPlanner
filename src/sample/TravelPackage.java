package sample;

public class TravelPackage {
    private Hotel hotel;
    private Flight flight;
    private Flight returnFlight;
    private Tour daytrip;
    private int totalPrice;

    public TravelPackage(Hotel hotel, Flight flight, Flight returnFlight, Tour daytrip){
        this.hotel = hotel;
        this.flight = flight;
        this.returnFlight = returnFlight;
        this.daytrip = daytrip;
        this.totalPrice = hotel.getHotel_base_price() + flight.getPrice() + returnFlight.getPrice() + daytrip.getTourPrice();
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
        return "Flug út: " + getFlight().getFlightDate().toString() + "\n"
                + "Flug heim: " + getReturnFlight().getFlightDate().toString() + "\n"
                + "Hótel " + getHotel().getHotel_name() + "\n"
                + "Dagsferð " + getDaytrip().getTourName() + "\n"
                + "Verð " + getTotalPrice() + "\n";
    }
}
