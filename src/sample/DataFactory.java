package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Date;

public class DataFactory {
    public DataFactory(){
    }
    public ObservableList<TravelPackage> getTravelPackages(){
        ObservableList<TravelPackage> travelPackages = FXCollections.observableArrayList();
        return travelPackages;
    }
    public ArrayList<DayTrip> getDayTrips(){
        ArrayList<DayTrip> dayTrips = new ArrayList<>();
        DayTrip daytrip1 = new DayTrip("Grindavík","12032021", 1000,true,true,false, "www.erkomideldgos.is");
        DayTrip daytrip2 = new DayTrip("Vogar","14032021", 2000,true,true, false,"www.erkomideldgos.is");
        DayTrip daytrip3 = new DayTrip("Hafnarfjörður","16032021", 3000,false,false, true,"www.erkomideldgos.is");
        dayTrips.add(daytrip1);
        dayTrips.add(daytrip2);
        dayTrips.add(daytrip3);
        return dayTrips;
    }
    public ArrayList<Flight> getFlights(){
        ArrayList<Flight> flights = new ArrayList<>();
        return flights;
    }
    public ArrayList<Hotel> getHotels(){
        ArrayList<Hotel> hotels = new ArrayList<>();
        return hotels;
    }
}
