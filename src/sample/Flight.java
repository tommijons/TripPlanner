package sample;

import java.util.Date;

public class Flight {
    private int id;
    private String departureLocation;
    private String arrivalLocation;
    private String departureTime;
    private String arrivalTime;
    private String flightDate;
    private int price;
    private String airline;
    private boolean mealService;

    public Flight(Integer id, String departureLocation, String arrivalLocation, String departureTime, String arrivalTime, String flightDate, int price, String airline, boolean mealService) {
        this.id = id;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightDate = flightDate;
        this.price = price;
        this.airline = airline;
        this.mealService = mealService;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getArrivalLocation() { return arrivalLocation; }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public String getDepartureLocation() { return departureLocation; }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public boolean isMealService() {
        return mealService;
    }

    public void setMealService(boolean mealService) {
        this.mealService = mealService;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String s = "Flugfélag:  " + airline +
                "\nFrá: " + arrivalLocation + "\t\t Til: " + departureLocation +
                "\t\t Verð: " + price + "kr." + "\n" +
                departureTime + "\t\t " + arrivalTime + "\n\n";

        String s2 = "id: " + id + "\t" +
                "departureLocation: " + departureLocation + "\t" +
                "arrivalLocation: " + arrivalLocation + "\t" +
                "departureTime: " + departureTime + "\t" +
                "arrivalTime: " + arrivalTime + "\t" +
                "flightDate: " + flightDate + "\t" +
                "price: " + price + "\t" +
                "airline: " + airline + "\t" +
                "mealService: " + mealService + "\n";
        return s2;
    }

}
