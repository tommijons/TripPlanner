package sample;

import java.util.Date;

class DayTrip {
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
}
