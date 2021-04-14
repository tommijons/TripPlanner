package Tour;


import java.time.LocalDate;


public class TourFilter {

    private final LocalDate earliestDate;
    private final LocalDate latestDate;
    private final String location;
    private final int maxPrice;
    private final String services;
    private final int minDuration;
    private final int maxDuration;
    private final int minSpots;


    public TourFilter(LocalDate earliest, LocalDate latest, String location, int maxPrice,
                      String services, int minDuration, int maxDuration, int minSpots) {
        earliestDate = earliest;
        latestDate = latest;
        this.location = location;
        this.maxPrice = maxPrice;
        this.services = services;
        this.maxDuration = maxDuration;
        this.minDuration = minDuration;
        this.minSpots = minSpots;
    }

    public TourFilter() {
        //TODO get rid of this function! (change callers to use the other constructor)
        earliestDate = LocalDate.of(2021,6,7);
        latestDate = LocalDate.of(2021,6,12);
        location = "Here";
        maxPrice = Integer.MAX_VALUE;
        services = "";
        minDuration = 0;
        maxDuration = Integer.MAX_VALUE;
        this.minSpots = 1;
    }

    public LocalDate getEarliestDate() {
        return earliestDate;
    }

    public LocalDate getLatestDate() {
        return latestDate;
    }

    public String getLocation() {
        return location;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public int getMinDuration() { return minDuration; }

    public int getMaxDuration() { return maxDuration; }

    public String getServices() { return services; }

    public int getMinSpots() { return minSpots; }
}
