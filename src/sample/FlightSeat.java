package sample;

public class FlightSeat {
    private String seatNumber;
    private int price;
    private boolean avalible;
    private boolean extraLegRoom;
    private boolean emergencyExit;

    public FlightSeat(String seatNumber, int price, boolean avalible, boolean extraLegRoom, boolean emergencyExit) {
        this.seatNumber = seatNumber;
        this.price = price;
        this.avalible = avalible;
        this.extraLegRoom = extraLegRoom;
        this.emergencyExit = emergencyExit;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public int getPrice() {
        return price;
    }

    public boolean isAvalible() {
        return avalible;
    }

    public boolean isExtraLegRoom() {
        return extraLegRoom;
    }

    public boolean isEmergencyExit() {
        return emergencyExit;
    }
}
