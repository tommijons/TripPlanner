package sample;

import java.util.Date;

public class HotelFilter {
    private Date checkIn;
    private Date checkOut;
    public HotelFilter(Date checkIn, Date checkOut){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }
}
