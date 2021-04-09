package sample;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class HotelFilter {
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String location;
    private int maxPrice;
    private int minSize;
    private int minRating;
    private int minBeds;
    private boolean threeStar;
    private boolean fourStar;
    private boolean fiveStar;
    public HotelFilter(LocalDate checkIn, LocalDate checkOut, String location,
                       int maxPrice, int minSize, int minRating, int minBeds,
                       boolean threeStar,boolean fourStar,boolean fiveStar){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.location = location;
        this.maxPrice = maxPrice;
        this.minSize = minSize;
        this.minRating = minRating;
        this.minBeds = minBeds;
        this.threeStar = threeStar;
        this.fourStar = fourStar;
        this.fiveStar = fiveStar;
    }

    public HotelFilter(){
        //TODO get rid of this function! (change callers to use the other constructor)
        checkIn = LocalDate.now();
        checkOut = checkIn.plus(1, ChronoUnit.DAYS);
        location = "Reykjavík";
        maxPrice = Integer.MAX_VALUE;
        minSize = 0;
        minRating = 0;
        minBeds = 1;
        threeStar = true;
        fourStar = true;
        fiveStar = true;
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

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public boolean isThreeStar() { return threeStar; }

    public boolean isFourStar() { return fourStar; }

    public boolean isFiveStar() { return fiveStar; }
}
