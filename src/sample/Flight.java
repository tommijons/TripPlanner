package sample;

import java.util.Date;

public class Flight {
    private String departureLocation;
    private String arrivalLocation;
    private Date departureDate;
    private Date arrivalDate;
    private int price;
    private FlightSeat flightSeat;

    public Flight(String departureLocation, String arrivalLocation, Date departureDate, Date arrivalDate, int price, FlightSeat flightSeat) {
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.price = price;
        this.flightSeat = flightSeat;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public int getPrice() {
        return price;
    }



}
