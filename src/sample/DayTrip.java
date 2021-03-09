package sample;

import java.util.Date;

public class DayTrip {
    private String Location;
    private String Date;
    private int Price;
    private Boolean handicap;
    private Boolean Physical;
    private Boolean transport;
    private String URL;


    public DayTrip(String location, String date, int price, Boolean handicap, Boolean physical, Boolean transport, String url) {
        this.Location = location;
        this.Date = date;
        this.Price = price;
        this.handicap = handicap;
        this.Physical = physical;
        this.transport = transport;
        this.URL = url;
    }

    @Override
    public String toString() {
        return "DayTrip{" +
                "Location='" + Location + '\'' +
                ", Date='" + Date + '\'' +
                ", Price=" + Price +
                ", handicap=" + handicap +
                ", Physical=" + Physical +
                ", transport=" + transport +
                ", URL='" + URL + '\'' +
                '}';
    }

    public String getLocation() {
        return Location;
    }

    public String getDate() {
        return Date;
    }

    public int getPrice() {
        return Price;
    }

    public Boolean getHandicap() {
        return handicap;
    }

    public Boolean getPhysical() {
        return Physical;
    }

    public Boolean getTransport() {
        return transport;
    }

    public String getURL() {
        return URL;
    }
}
