package sample;

import java.util.Date;

public class DayTrip {


    private String Location;
    private Date Date;
    private int Price;
    private Boolean handicap;
    private Boolean Physical;
    private String[] tags;
    private Boolean transport;
    private String URL;

    DayTrip(String l, Date d, int p, Boolean h, Boolean ph, String[] t, Boolean tr, String u) {
        Location = l;
        Date = d;
        Price = p;
        handicap = h;
        Physical = ph;
        tags = t;
        transport = tr;
        URL = u;
    }

    public String getLocation() {
        return Location;
    }

    public java.util.Date getDate() {
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

    public String[] getTags() {
        return tags;
    }

    public Boolean getTransport() {
        return transport;
    }

    public String getURL() {
        return URL;
    }
}
