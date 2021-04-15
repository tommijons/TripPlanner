package Flight;

public class BookingDisplay {
    private String departureLocation;
    private String arrivalLocation;
    private String departureTime;
    private String arrivalTime;
    private String flightDate;
    private String airline;
    private Boolean mealService;
    private String seatId;

    public BookingDisplay(Flight flight, Seat seat) {
        this.departureLocation = flight.getDepartureLocation();
        this.arrivalLocation = flight.getArrivalLocation();
        this.departureTime = flight.getDepartureTime();
        this.arrivalTime = flight.getArrivalTime();
        this.flightDate = flight.getFlightDate();
        this.airline = flight.getAirline();
        this.mealService = flight.isMealService();
        this.seatId = Integer.toString(seat.getSeatID());
    }

    public String getFlightDate() {
        return flightDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public String getAirline() {
        return airline;
    }

    public Boolean getMealService() {
        return mealService;
    }

    public String getSeatId() {
        return seatId;
    }
}