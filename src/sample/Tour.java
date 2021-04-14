
package sample;

import java.time.LocalDate;

public class Tour {
    private int tourID;
    private String tourName;
    private String tourInfo;
    private LocalDate tourDate;
    private int availableSpots;
    private int bookedSpots;
    private int tourPrice;
    private boolean fullyBooked;
    private String tourRegion;
    private int duration;
    private String services;

    @Override
    public String toString() {
        return "\n" + tourName + "\nVerð: " + tourPrice + "\nLengd: " + duration + "\nDagsetning: " + tourDate;
    }

    public Tour(String tourName, String tourInfo, LocalDate tourDate, int availableSpots, int tourPrice, String tourRegion, int duration, String services) {
        this.tourName = tourName;
        this.tourInfo = tourInfo;
        this.tourDate = tourDate;
        this.availableSpots = availableSpots;
        this.tourPrice = tourPrice;
        this.tourRegion = tourRegion;
        this.duration = duration;
        this.services = services;
    }
    public Tour() {
        this.tourName = "Enginn túr";
        this.tourInfo = "Engar upplýsingar";
        this.tourDate = LocalDate.now();
        this.availableSpots = 0;
        this.tourPrice = 0;
        this.tourRegion = "Hvergi";
        this.duration = 0;
        this.services = "Engar";
    }

    public int getTourID() {
        return tourID;
    }

    public void setTourID(int tourID) {
        this.tourID = tourID;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getTourInfo() {
        return tourInfo;
    }

    public void setTourInfo(String tourInfo) {
        this.tourInfo = tourInfo;
    }

    public LocalDate getTourDate() {
        return tourDate;
    }

    public void setTourDate(LocalDate tourDate) {
        this.tourDate = tourDate;
    }

    public int getAvailableSpots() {
        return availableSpots;
    }

    public void setAvailableSpots(int availableSpots) {
        this.availableSpots = availableSpots;
    }

    public int getBookedSpots() {
        return bookedSpots;
    }

    public void setBookedSpots(int bookedSpots) {
        this.bookedSpots = bookedSpots;
    }

    public int getTourPrice() {
        return tourPrice;
    }

    public void setTourPrice(int tourPrice) {
        this.tourPrice = tourPrice;
    }

    public boolean isFullyBooked() {
        return fullyBooked;
    }

    public void setFullyBooked(boolean fullyBooked) {
        this.fullyBooked = fullyBooked;
    }

    public String getTourRegion() {
        return tourRegion;
    }

    public void setTourRegion(String tourRegion) {
        this.tourRegion = tourRegion;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }
}