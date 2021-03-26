package sample;

import java.util.Date;

public class DayTripFilter {

    private Date earliestDate;
    private Date latestDate;
    private String location;
    private Boolean handicapAccessible;
    private int maxPrice;
    private String[] tags;


    public DayTripFilter(Date earliest, Date latest, String location, boolean mustBeHandicapAccessible, int maxPrice, String[] tags) {
        earliestDate = earliest;
        latestDate = latest;
        this.location = location;
        handicapAccessible = mustBeHandicapAccessible;
        this.maxPrice = maxPrice;
        this.tags = tags;
    }

    public DayTripFilter(){
        //TODO get rid of this function! (change callers to use the other constructor)
        earliestDate = new Date();
        latestDate = new Date();
        location = "Here";
        handicapAccessible = false;
        maxPrice = Integer.MAX_VALUE;
        tags = new String[0];

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

    public Boolean getHandicapAccessible() {
        return handicapAccessible;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

}
