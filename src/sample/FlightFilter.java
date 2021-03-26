package sample;

import java.util.Date;

public class FlightFilter {
    private Date date; //lastestDepartureDate?
    private String departureLocation;
    private String arrivalLocation;
    private Boolean extraLegRoom;
    private Boolean emergencyExit;
    private int maxPrice; //priceMax

    public FlightFilter(Date date){
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
    public String getDepartureLocation(){return departureLocation;}
    public String getArrivalLocation(){return arrivalLocation;}
    public Boolean hasExtraLegRoom(){return extraLegRoom;}
    public Boolean hasEmergencyExit(){return emergencyExit;}
    public int getMaxPrice(){return maxPrice;}

}
