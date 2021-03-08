package sample;

public class Booking {
    private User user;
    private TravelPackage travelPackage;
    private int ccinfo;

    public User getUser() {
        return user;
    }

    public TravelPackage getTravelPackage() {
        return travelPackage;
    }

    public int getCcinfo() {
        return ccinfo;
    }

    public Booking(User user, TravelPackage travelPackage, int ccinfo) {
        this.user = user;
        this.travelPackage = travelPackage;
        this.ccinfo = ccinfo;
    }

    public void setTravelPackage(TravelPackage travelPackage) {
        this.travelPackage = travelPackage;
    }
}
