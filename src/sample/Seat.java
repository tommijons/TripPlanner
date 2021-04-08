package sample;

public class Seat {
    private int flight_id;
    private int seatID;
    private boolean isAvailable;
    private boolean isFirstClass;
    private boolean isEmergency;

    public Seat(int flight_id, int seatID, boolean isAvailable, boolean isFirstClass, boolean isEmergency) {
        this.flight_id = flight_id;
        this.seatID = seatID;
        this.isAvailable = isAvailable;
        this.isFirstClass = isFirstClass;
        this.isEmergency = isEmergency;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) { this.flight_id = flight_id; }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean isFirstClass() {
        return isFirstClass;
    }

    public void setFirstClass(boolean isFirstClass) {
        this.isFirstClass = isFirstClass;
    }

    public boolean isEmergency() {
        return isEmergency;
    }

    public void setEmergency(boolean isEmergency) { this.isEmergency = isEmergency; }

    @Override
    public String toString() {
        return "flight_id: " + flight_id + "\t" +
                "seatID: " + seatID + "\t" +
                "isAvailable: " + isAvailable + "\t" +
                "isFirstClass: " + isFirstClass + "\t" +
                "isEmergency: " + isEmergency + "\n";
    }
}
