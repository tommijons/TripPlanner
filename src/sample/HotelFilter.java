package sample;

import java.util.Date;

public class HotelFilter {
    private Date checkIn;
    private Date checkOut;
    private String location;
    private int maxPrice;
    private int minSize;
    private int minRating;
    private int minBeds;
    public HotelFilter(Date checkIn, Date checkOut, String location, int maxPrice, int minSize, int minRating, int minBeds){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.location = location;
        this.maxPrice = maxPrice;
        this.minSize = minSize;
        this.minRating = minRating;
        this.minBeds = minBeds;
    }

    public HotelFilter(){
        //TODO get rid of this function! (change callers to use the other constructor)
        checkIn = new Date();
        checkOut = new Date();
        location = "Here";
        maxPrice = Integer.MAX_VALUE;
        minSize = 0;
        minRating = 0;
        minBeds = 1;
    }

    public String getLocation() {
        return location;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public int getMinSize() {
        return minSize;
    }

    public int getMinBeds() {
        return minBeds;
    }

    public int getMinRating() {
        return minRating;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }
}
