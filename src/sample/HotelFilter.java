package sample;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class HotelFilter {
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String location;
    private int selectedNumOfGuests;
    private int selectedNumOfRooms;
    private boolean threeStar;
    private boolean fourStar;
    private boolean fiveStar;
    public HotelFilter(LocalDate checkIn, LocalDate checkOut, String location,
                       int selectedNumOfGuests, int selectedNumOfRooms,
                       boolean threeStar,boolean fourStar,boolean fiveStar){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.location = location;
        this.selectedNumOfGuests = selectedNumOfGuests;
        this.selectedNumOfRooms = selectedNumOfRooms;
        this.threeStar = threeStar;
        this.fourStar = fourStar;
        this.fiveStar = fiveStar;
    }
/*
    public HotelFilter(){
        //TODO get rid of this function! (change callers to use the other constructor)
        checkIn = LocalDate.now();
        checkOut = checkIn.plus(1, ChronoUnit.DAYS);
        location = "Reykjavík";
        minSize = 0;
        minBeds = 1;
        threeStar = true;
        fourStar = true;
        fiveStar = true;
    }*/

    public String getLocation() { return location; }

    public int getSelectedNumOfGuests() { return selectedNumOfGuests; }

    public int getSelectedNumOfRooms() { return selectedNumOfRooms; }

    public LocalDate getCheckIn() { return checkIn; }

    public LocalDate getCheckOut() { return checkOut; }

    public boolean isThreeStar() { return threeStar; }

    public boolean isFourStar() { return fourStar; }

    public boolean isFiveStar() { return fiveStar; }
}
