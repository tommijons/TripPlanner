package sample;

import java.util.Date;

public class Flight {
    private String departureLocation;
    private String arrivalLocation;
    private String departureDate;
    private String arrivalDate;
    private int price;


    public Flight(String departureLocation, String arrivalLocation, String departureDate, String arrivalDate, int price) {
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.price = price;

    }

    @Override
    public String toString() {
        return "Flight{" +
                "departureLocation='" + departureLocation + '\'' +
                ", arrivalLocation='" + arrivalLocation + '\'' +
                '}';
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public int getPrice() {
        return price;
    }



}
