package sample;

import java.util.Date;

public class TourFilter {

    private final Date earliestDate;
    private final Date latestDate;
    private final String location;
    private final int maxPrice;
    private final String services;
    private final int maxDuration;
    private final int minSpots;


    public TourFilter(Date earliest, Date latest, String location, int maxPrice, String services, int maxDuration, int minSpots) {
        earliestDate = earliest;
        latestDate = latest;
        this.location = location;
        this.maxPrice = maxPrice;
        this.services = services;
        this.maxDuration = maxDuration;
        this.minSpots = minSpots;
    }

    public TourFilter() {
        //TODO get rid of this function! (change callers to use the other constructor)
        earliestDate = new Date();
        latestDate = new Date();
        location = "Here";
        maxPrice = Integer.MAX_VALUE;
        services = "";
        maxDuration = -1;
        this.minSpots = 1;
    }

    public Date getEarliestDate() {
        return earliestDate;
    }

    public Date getLatestDate() {
        return latestDate;
    }

    public String getLocation() {
        return location;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public int getMaxDuration() { return maxDuration; }

    public String getServices() { return services; }

    public int getMinSpots() { return minSpots; }
}
